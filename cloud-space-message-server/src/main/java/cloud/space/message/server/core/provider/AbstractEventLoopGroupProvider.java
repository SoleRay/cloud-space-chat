package cloud.space.message.server.core.provider;

import io.netty.channel.EventLoopGroup;

public abstract class AbstractEventLoopGroupProvider implements EventLoopGroupProvider {

    protected EventLoopGroup bossGroup;

    protected EventLoopGroup workGroup;

    @Override
    public EventLoopGroup bossGroup() {
        return bossGroup;
    }

    @Override
    public EventLoopGroup workerGroup() {
        return workGroup;
    }

    @Override
    public void shutdown() {
        bossGroup.shutdownGracefully();
        workGroup.shutdownGracefully();
    }
}
