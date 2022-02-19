package io.csrohit.embedded.iot.utils.slack;

import com.github.seratch.jslack.Slack;
import com.github.seratch.jslack.api.model.Attachment;
import com.github.seratch.jslack.api.model.Attachment.AttachmentBuilder;
import com.github.seratch.jslack.api.model.Field;
import com.github.seratch.jslack.api.webhook.Payload;
import com.github.seratch.jslack.api.webhook.Payload.PayloadBuilder;
import io.csrohit.embedded.iot.config.Config;
import io.csrohit.embedded.iot.exception.ConfigNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SlackService {
    private static final Logger LOG = LoggerFactory.getLogger(SlackService.class);

    @Autowired
    private Config config;

    private String url;

    public SlackService() {
        url = config.getPORTFOLIO_WEBHOOK();
    }
    public enum SlackChannel {
        NotificationsBackInStock,
        DevOpsAlerts,
        AlertsAllApps
    }

    private static final Logger log = LoggerFactory.getLogger(SlackService.class);

    public void sendMessage(String title, SlackChannel slackChannel, SlackField... fields) {
        if(url == null || url.isEmpty()){
            LOG.error("Couldn't find webhook url for slack");
            return;
        }
        AttachmentBuilder builder = Attachment.builder();
        builder.color("good");
        builder.pretext("*" + title + "*");
        builder.fallback(title);

        List<Field> newFields = new ArrayList<>();
        for (SlackField field : fields) {
            newFields.add(field.field);
        }
        builder.fields(newFields);
//        switch (slackChannel) {
//            case DevOpsAlerts:
//                url = "https://hooks.slack.com/services";
//                break;
//            case NotificationsBackInStock:
//                url = "https://hooks.slack.com/services";
//                break;
//            case AlertsAllApps:
//                url = "https://hooks.slack.com/services";
//                break;
//        }

        sendSlackMessage("", builder.build(), url);
    }

    private void sendSlackMessage(String message, Attachment attachment, String url) {
        try {

            PayloadBuilder builder = Payload.builder();

            builder.channel("#portfolio"); //Not used

            builder.username("alerts-bot");
            builder.iconUrl("https://goo.gl/VRAx3Z");

            if (attachment != null) {
                List<Attachment> attachments = new ArrayList<>();
                attachments.add(attachment);
                builder.attachments(attachments);
            }

            builder.text(message);
            Payload payload = builder.build();

            Slack slack = Slack.getInstance();
            slack.send(url, payload);
        } catch (Exception e) {
            log.error("An error occurred while sending message to slack", e);
        }
    }
}