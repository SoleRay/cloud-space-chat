package cloud.space.message.server.core.provider;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.ServerChannel;
import io.netty.util.concurrent.EventExecutorGroup;

public interface EventLoopGroupProvider {

    default boolean isEventLoopGroup(Class<? extends EventExecutorGroup> type){
        return type.equals(eventLoopGroupClass());
    }

    void initGroup(int bossGroupThreads, int workGroupThreads);

    EventLoopGroup bossGroup();

    EventLoopGroup workerGroup();

    Class<? extends ServerChannel> serverSocketChannelClass();

    Class<? extends EventLoopGroup> eventLoopGroupClass();

    void shutdown();
}
