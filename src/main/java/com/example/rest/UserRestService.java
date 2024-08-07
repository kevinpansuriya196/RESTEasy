//package com.example.rest;
//
//import com.example.dao.UserDao;
//import com.example.model.User;
//
//import javax.inject.Inject;
//import javax.ws.rs.*;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//import java.util.List;
//import java.util.logging.Logger;
//
//@Path("/users")
//@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
//public class UserRestService {
//
//    private static final Logger LOGGER = Logger.getLogger(UserRestService.class.getName());
//
//    @Inject
//    private UserDao userDao;
//
//    @POST
//    public Response createUser(User user) {
//        if (userDao == null) {
//            LOGGER.severe("UserDao is null");
//            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("UserDao is not initialized").build();
//        }
//        userDao.createUser(user);
//        return Response.status(Response.Status.CREATED).entity(user).build();
//    }
//
//    @GET
//    @Path("/{id}")
//    public Response getUser(@PathParam("id") int id) {
//        if (userDao == null) {
//            LOGGER.severe("UserDao is null");
//            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("UserDao is not initialized").build();
//        }
//        User user = userDao.findUserById(id);
//        if (user != null) {
//            return Response.ok(user).build();
//        } else {
//            return Response.status(Response.Status.NOT_FOUND).build();
//        }
//    }
//
//    @GET
//    public List<User> getAllUsers() {
//        if (userDao == null) {
//            LOGGER.severe("UserDao is null");
//            return null;
//        }
//        return userDao.findAllUsers();
//    }
//
//    @PUT
//    @Path("/{id}")
//    public Response updateUser(@PathParam("id") int id, User user) {
//        if (userDao == null) {
//            LOGGER.severe("UserDao is null");
//            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("UserDao is not initialized").build();
//        }
//        User existingUser = userDao.findUserById(id);
//        if (existingUser != null) {
//            user.setId(id);
//            userDao.updateUser(user);
//            return Response.ok(user).build();
//        } else {
//            return Response.status(Response.Status.NOT_FOUND).build();
//        }
//    }
//
//    @DELETE
//    @Path("/{id}")
//    public Response deleteUser(@PathParam("id") int id) {
//        if (userDao == null) {
//            LOGGER.severe("UserDao is null");
//            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("UserDao is not initialized").build();
//        }
//        userDao.deleteUser(id);
//        return Response.noContent().build();
//    }
//}
