package com.example.springbusapp.listener;

import com.example.springbusapp.event.FooRemoteApplicationEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.bus.ServiceMatcher;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class FooEventListener implements ApplicationListener<FooRemoteApplicationEvent> {

    @Autowired
    private ServiceMatcher serviceMatcher;

    @Override
    public void onApplicationEvent(FooRemoteApplicationEvent fooRemoteApplicationEvent) {
        if(serviceMatcher.isForSelf(fooRemoteApplicationEvent)) {
            System.out.printf(fooRemoteApplicationEvent.getMsg());
        }else{
            System.out.printf("Unknown Event");
        }
    }
}
