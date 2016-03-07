package com.example.websocket.initializer;

import com.example.websocket.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.broker.BrokerAvailabilityEvent;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by yao on 16/2/25.
 */
@Component
public class UserGenerator implements ApplicationListener<BrokerAvailabilityEvent> {

    private SimpMessagingTemplate template;

    @Autowired
    public UserGenerator(SimpMessagingTemplate template) {
        this.template = template;

        template.setUserDestinationPrefix("/calcApp");
        ScheduledExecutorService scheduledExecutorService= Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                template.convertAndSend("user", new User() {{
                    setName("ua" + System.currentTimeMillis());
                }});
            }
        },1,1, TimeUnit.SECONDS);

    }

    @Override
    public void onApplicationEvent(BrokerAvailabilityEvent brokerAvailabilityEvent) {

    }

 /*   @Scheduled(fixedDelay = 1)
    public void sendDataUpdates() {
        this.template.convertAndSend("/calcApp/user", new User() {{
            setName("ua" + System.currentTimeMillis());
        }});
    }*/
}
