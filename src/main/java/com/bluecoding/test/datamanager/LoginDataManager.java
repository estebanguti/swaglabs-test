package com.bluecoding.test.datamanager;

import com.bluecoding.test.model.Login;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
public class LoginDataManager {

    public List<Login> convertJsonToLoginDtos(String file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Login[] loginUsers = objectMapper.readValue(new File(file), Login[].class);
        return Arrays.asList(loginUsers);
    }

}
