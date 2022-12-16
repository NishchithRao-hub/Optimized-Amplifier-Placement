package com.capgemini.node.service;

import com.capgemini.node.exception.LinkException;
import com.capgemini.node.model.Link;
import com.capgemini.node.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LinkServiceImpl implements LinkService{

    public LinkServiceImpl(){}
    public LinkRepository linkRepository;

    @Autowired
    public LinkServiceImpl(LinkRepository linkRepository){
        this.linkRepository = linkRepository;
    }

    @Override
    public Link addLink(Link link) {
        linkRepository.save(link);
        return link;
    }

    @Override
    public List<Link> getAllLinks() {
        return linkRepository.findAll();
    }

    @Override
    public Link getLinkById(Integer id) throws LinkException {
        Optional<Link> link = linkRepository.findById(id);
        if(link.isEmpty())
            throw new LinkException("Invalid Link ID");

        return link.get();
    }

    @Override
    public Link getLinkByName(String name) {
        Optional<Link> link= linkRepository.findByNameIgnoreCase(name);
        if(link.isEmpty())
            throw new LinkException("Invalid Link Name");

        return link.get();
    }

    @Override
    public void deleteLink(Integer id) {

        Optional<Link> optionalLink = linkRepository.findById(id);
        if(optionalLink.isEmpty())
            throw new LinkException("Invalid Link ID");

        linkRepository.deleteById(id);
    }

    @Override
    public Link updateLink(Integer id, Link link) {
        Optional<Link> link1 =linkRepository.findById(id);
        if (link1.isEmpty())
            throw new LinkException("Invalid Link ID");
        link1.get().setName(link.getName());
        link1.get().setLength(link.getLength());
        link1.get().setFrom_node(link.getFrom_node());
        link1.get().setTo_node(link.getTo_node());
        return link1.get();
    }
}
