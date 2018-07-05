package com.dubbodemo.test.dubbox.annotation.services;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;

import javax.validation.constraints.Min;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("users")
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
public interface UserRestService {

    @GET
    @Path("{id : \\d+}")
    User getUser(@Min(value = 1L, message = "User ID must be greater than 1") @PathParam("id") Long id);
}