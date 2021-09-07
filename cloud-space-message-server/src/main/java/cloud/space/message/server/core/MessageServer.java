package cloud.space.message.server.core;

import cloud.space.message.server.core.handler.MessageHandler;
import cloud.space.message.server.core.handler.protobuf.ProtobufEncoder;
import cloud.space.message.server.core.handler.protobuf.ProtobufVarint32FrameDecoder;
import cloud.space.message.server.core.handler.protobuf.ProtobufVarint32LengthFieldPrepender;
import cloud.space.message.server.core.provider.EventLoopGroupProvider;
import cloud.space.message.server.resource.ClientResources;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.socket.SocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class MessageServer {

    @Autowired
    private ClientResources clientResources;

    public void start(){
        ServerBootstrap serverBootstrap = buildServer();
        serverBootstrap.bind(clientResources.host(), clientResources.port())
                .syncUninterruptibly();
        log.info("Message Server started on port(s): {}", clientResources.port());
    }

    private ServerBootstrap buildServer() {
        EventLoopGroupProvider provider = clientResources.eventLoopGroupProvider();
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.option(ChannelOption.SO_BACKLOG, 128)
                .group(provider.bossGroup(),provider.workerGroup())
                .channel(provider.serverSocketChannelClass())
                .childHandler(getChannelInitializer());
        return serverBootstrap;
    }

    private ChannelInitializer<SocketChannel> getChannelInitializer() {
        return new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline()
                        .addLast(new ProtobufVarint32FrameDecoder())
//                        .addLast(new ProtobufDecoder(MyMessage.getDefaultInstance()))
                        .addLast(new ProtobufVarint32LengthFieldPrepender())
                        .addLast(new ProtobufEncoder())
                        .addLast(new MessageHandler());
            }
        };
    }

    public void shutdown() {
        clientResources.eventLoopGroupProvider().shutdown();
    }


}
