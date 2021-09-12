package cloud.space.message.resource;

import cloud.space.message.common.enums.EventLoopGroupEnum;
import cloud.space.message.server.provider.EventLoopGroupProvider;
import io.netty.channel.EventLoopGroup;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultClientResources implements ClientResources, InitializingBean {

    @Value("${netty.server.boss threads:1}")
    private int bossGroupThreads;

    @Value("${netty.server.work threads:0}")
    private int workGroupThreads;

    @Value("${netty.server.type:nio}")
    private String serverType;

    @Value("${netty.server.host:127.0.0.1}")
    private String host;

    @Value("${netty.server.port:8001}")
    private int port;

    @Autowired
    private List<EventLoopGroupProvider> eventLoopGroupProviders;

    private EventLoopGroupProvider eventLoopGroupProvider;

    @Override
    public void afterPropertiesSet() throws Exception {
        eventLoopGroupProvider = selectProvider();
        eventLoopGroupProvider.initGroup(bossGroupThreads,workGroupThreads);
    }

    private EventLoopGroupProvider selectProvider() {
        Class<? extends EventLoopGroup> groupClass = EventLoopGroupEnum.getGroupByType(serverType);
        for (EventLoopGroupProvider provider : eventLoopGroupProviders) {
            if(provider.isEventLoopGroup(groupClass)){
                return provider;
            }
        }
        return null;
    }

    @Override
    public EventLoopGroupProvider eventLoopGroupProvider() {
        return eventLoopGroupProvider;
    }

    @Override
    public String host() {
        return host;
    }

    @Override
    public int port() {
        return port;
    }
}
