package com.san.pro.resource;

import com.san.pro.dao.MyDao;
import com.san.pro.model.User;
import com.san.pro.model.UserList;
import org.skife.jdbi.v2.sqlobject.Bind;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by sandeepkumar.s on 10/27/2015.
 */
@Path("demo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MyResource {

    private MyDao myDao;

    @Inject
    public MyResource(MyDao myDao) {
        this.myDao = myDao;
    }

    @POST
    @Path("/createTable")
    public void createTable() {
        myDao.createTable();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void insert(@Bind User user) {
        myDao.insert(user);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getById(@PathParam("id") Long id) {
        return myDao.findById(id);
    }

    @GET
    @Path("getByName/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getByName(@PathParam("name") String name) {
        return myDao.findByName(name);
    }

    @GET
    @Path("getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAll() {
        return myDao.findAll();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Long update(@PathParam("id") Long id, User model) {
        User user = myDao.findById(id);
        user.setName(model.getName());
        return myDao.update(user);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public List<User> getIN(UserList userList) {
        return myDao.findIN(userList.getUsersID());
    }

//    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
//    public List<User> getIN(List<Long> usersID) {
//        return myDao.findIN(usersID);
//    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Long id) {
        myDao.delete(id);
    }
}
