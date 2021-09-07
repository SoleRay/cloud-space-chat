package cloud.space.message.server.resource;

import cloud.space.message.server.core.provider.EventLoopGroupProvider;

public interface ClientResources {

    EventLoopGroupProvider eventLoopGroupProvider();

    String host();

    int port();
}
