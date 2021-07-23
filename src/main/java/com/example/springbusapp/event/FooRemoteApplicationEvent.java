package com.example.springbusapp.event;

import org.springframework.cloud.bus.event.Destination;
import org.springframework.cloud.bus.event.RemoteApplicationEvent;

public class FooRemoteApplicationEvent extends RemoteApplicationEvent {

    private String msg;

    public FooRemoteApplicationEvent() {
    }

    public FooRemoteApplicationEvent(Object source, String originService, Destination destination, String msg) {
        super(source, originService, destination);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
