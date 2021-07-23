package com.example.springbusapp.conf;

import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@RemoteApplicationEventScan({"com.example.springbusapp.event"})
public class EventConfiguration {

}
