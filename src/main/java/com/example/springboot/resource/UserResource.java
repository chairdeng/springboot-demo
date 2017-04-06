package com.example.springboot.resource;

import com.example.springboot.entity.User;
import com.example.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

/**
 * *****************************************
 *
 * @author 邓超【dengchao5@jd.com】
 * @date 2017/4/5 15:25
 * *****************************************
 */
@Component
@Path("/jax-rs/user")
public class UserResource {

    @Autowired
    private UserRepository userRepository;

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id")long id){
        User user = userRepository.findOne(id);
        return Response.status(Response.Status.OK).entity(user).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(User user){
        user = userRepository.save(user);
        return Response.created(URI.create("/jax-rs/user/"+user.getId())).build();
    }

    @PUT
    public void put(User user){
        if (user == null || user.getId() == null)
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        userRepository.save(user);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id")Long id){
        if (id == null)
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        userRepository.delete(id);
    }
}
