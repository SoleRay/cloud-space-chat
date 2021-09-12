package cloud.space.message.resource;

import cloud.space.message.server.provider.EventLoopGroupProvider;

public interface ClientResources {

    EventLoopGroupProvider eventLoopGroupProvider();

    String host();

    int port();
}
