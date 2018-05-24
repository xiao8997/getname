package com.haoming.service;

import com.haoming.model.User;
import com.haoming.util.DatabaseHelper;
import com.haoming.util.PropsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaot on 2018/5/18.
 */
public class UserService {
    private final static Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    public List<User> getUserList() {
        String sql = "select * from user";
        return DatabaseHelper.queryEntityList(User.class,sql);
    }
}
