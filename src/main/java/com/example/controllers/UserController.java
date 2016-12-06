package com.example.controllers;

import com.example.models.User;
import com.example.models.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by u0109585 on 4/12/2016.
 */
@Controller
public class UserController {

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestBody User user){
        String userId = "";
        try{
            userDao.save(user);
            userId = String.valueOf(user.getId());
        }
        catch (Exception e){
            return "Error creating the user: " + e.toString();
        }
        return "User succesfully created with id = " + userId;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(long id){
        try{
            User user = new User(id);
            userDao.delete(user);
        }
        catch (Exception e){
            return "Error deleting the user:" + e.toString();
        }
        return "User succesfully deleted!";
    }

    @RequestMapping("get_by_email")
    @ResponseBody
    public String getByEmail(String email){
        String userId = "";
        try{
            User user = userDao.findByEmail(email);
            userId = String.valueOf(user.getId());
        }
        catch (Exception e){
            return "User not found";
        }
        return "The user id is: " + userId;
    }

    @RequestMapping("/update")
    @ResponseBody
    public String updateUser(long id, String email, String name){
        try{
            User user = userDao.findOne(id);
            user.setEmail(email);
            user.setName(name);
            userDao.save(user);
        }
        catch (Exception e){
            return "Error updating the user: " + e.toString();
        }
        return "User succesfully updated!";
    }

    @Autowired
    private UserDao userDao;

}
