
package cloud.space.message.server.core.provider.impl;

import cloud.space.message.server.core.provider.AbstractEventLoopGroupProvider;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.ServerChannel;
import io.netty.channel.epoll.*;
import org.springframework.stereotype.Component;

@Component
public class EpollProvider extends AbstractEventLoopGroupProvider {

    @Override
    public Class<? extends ServerChannel> serverSocketChannelClass() {
        return EpollServerSocketChannel.class;
    }

    @Override
    public Class<? extends EventLoopGroup> eventLoopGroupClass() {
        return EpollEventLoopGroup.class;
    }

    @Override
    public void initGroup(int bossGroupThreads, int workGroupThreads) {
        bossGroup = new EpollEventLoopGroup(bossGroupThreads);
        if(workGroupThreads > 0){
            workGroup = new EpollEventLoopGroup(workGroupThreads);
        }else {
            workGroup = new EpollEventLoopGroup();
        }
    }
}
