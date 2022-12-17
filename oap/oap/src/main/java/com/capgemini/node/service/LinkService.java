package com.capgemini.node.service;


import com.capgemini.node.model.Link;

import java.util.List;

public interface LinkService {

    public Link addLink(Link link);
    public List<Link> getAllLinks();
    public Link getLinkById(Integer id);
    public Link getLinkByName(String name);
    public void deleteLink(Integer id);
    public Link updateLink(Integer id, Link link);

}
