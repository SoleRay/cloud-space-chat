
package cloud.space.message.server.core.provider.impl;

import cloud.space.message.server.core.provider.AbstractEventLoopGroupProvider;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.ServerChannel;
import io.netty.channel.kqueue.KQueueEventLoopGroup;
import io.netty.channel.kqueue.KQueueServerSocketChannel;
import org.springframework.stereotype.Component;

@Component
public class KqueueProvider extends AbstractEventLoopGroupProvider {

    @Override
    public Class<? extends EventLoopGroup> eventLoopGroupClass() {
        return KQueueEventLoopGroup.class;
    }

    @Override
    public Class<? extends ServerChannel> serverSocketChannelClass() {
        return KQueueServerSocketChannel.class;
    }

    @Override
    public void initGroup(int bossGroupThreads, int workGroupThreads) {
        bossGroup = new KQueueEventLoopGroup(bossGroupThreads);
        if(workGroupThreads > 0){
            workGroup = new KQueueEventLoopGroup(workGroupThreads);
        }else {
            workGroup = new KQueueEventLoopGroup();
        }
    }
}


