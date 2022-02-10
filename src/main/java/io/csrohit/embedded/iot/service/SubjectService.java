package io.csrohit.embedded.iot.service;

import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;
import io.csrohit.embedded.iot.model.Subject;
import io.csrohit.embedded.iot.repository.SubjectRepository;
import io.csrohit.embedded.iot.utils.rsql.CustomRsqlVisitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository repository;

    public List<Subject> findAll(String filter){
        Node rootNode = new RSQLParser().parse(filter);
        Specification<Subject> spec = rootNode.accept(new CustomRsqlVisitor<Subject>());
        return repository.findAll(spec);
    }
    public List<Subject> findAll(){return repository.findAll();}
    public Subject save(Subject subject){
        return repository.save(subject);
    }
}
