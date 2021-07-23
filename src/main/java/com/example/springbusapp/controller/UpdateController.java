package com.example.springbusapp.controller;

import com.example.springbusapp.event.FooRemoteApplicationEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.bus.BusBridge;
import org.springframework.cloud.bus.event.PathDestinationFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateController {

    @Autowired
    protected BusBridge busBridge;

    @Value("${spring.cloud.bus.id}")
    protected String busId;
    
    @Value("${spring.application.name}")
    protected String application;

    @RequestMapping(value="/notify", method = RequestMethod.GET)
    public String update(@RequestParam String msg){

        FooRemoteApplicationEvent event = new FooRemoteApplicationEvent(this,"random", new PathDestinationFactory().getDestination(application),msg);
        busBridge.send(event);

        return "ok";
    }
}
