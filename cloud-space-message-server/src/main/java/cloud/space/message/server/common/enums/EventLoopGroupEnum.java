package cloud.space.message.server.common.enums;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.kqueue.KQueueEventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;

public enum EventLoopGroupEnum {

    NIO("nio", NioEventLoopGroup.class),
    KQUEUE("kqueue", KQueueEventLoopGroup.class),
    EPOLL("epoll", EpollEventLoopGroup.class);

    private String type;

    private Class<? extends EventLoopGroup> group;

    EventLoopGroupEnum(String type, Class<? extends EventLoopGroup> group) {
        this.type = type;
        this.group = group;
    }

    public static Class<? extends EventLoopGroup> getGroupByType(String type){
        for (EventLoopGroupEnum value : EventLoopGroupEnum.values()) {
            if(value.type.equals(type)){
                return value.group;
            }
        }
        return NIO.group;
    }
}
