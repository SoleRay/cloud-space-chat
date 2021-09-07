package cloud.space.message.server.core.provider.impl;

import cloud.space.message.server.core.provider.AbstractEventLoopGroupProvider;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.ServerChannel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.stereotype.Component;

@Component
public class NioProvider extends AbstractEventLoopGroupProvider {

    @Override
    public Class<? extends EventLoopGroup> eventLoopGroupClass() {
        return NioEventLoopGroup.class;
    }

    @Override
    public Class<? extends ServerChannel> serverSocketChannelClass() {
        return NioServerSocketChannel.class;
    }

    @Override
    public void initGroup(int bossGroupThreads, int workGroupThreads) {
        bossGroup = new NioEventLoopGroup(bossGroupThreads);
        if(workGroupThreads > 0){
            workGroup = new NioEventLoopGroup(workGroupThreads);
        }else {
            workGroup = new NioEventLoopGroup();
        }
    }
}
