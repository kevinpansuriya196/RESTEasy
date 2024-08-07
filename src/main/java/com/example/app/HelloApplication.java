package com.example.app;

import com.example.rest.HelloRestService;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class HelloApplication extends Application {
    private Set<Object> singletons = new HashSet<>();

    public HelloApplication() {
        singletons.add(new HelloRestService());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
