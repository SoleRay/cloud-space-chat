package cloud.space.message.server.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageServerBoot implements SmartLifecycle{

    @Autowired
    private MessageServer messageServer;

    private boolean isRunning;

    @Override
    public void start() {
        messageServer.start();
        isRunning = true;
    }

    @Override
    public void stop() {
        messageServer.shutdown();
        log.info("Message Server shutdown.");
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }
}
