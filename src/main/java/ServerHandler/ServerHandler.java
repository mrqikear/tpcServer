package ServerHandler;

import Config.NettyConfig;
import Util.HexEncode;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

public class ServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 客户端与服务端创建连接的时候调用
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端与服务端连接开始...");
        NettyConfig.group.add(ctx.channel());
    }

    /**
     * 客户端与服务端断开连接时调用
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端与服务端连接关闭...");
        NettyConfig.group.remove(ctx.channel());
    }

    /**
     * 服务端接收客户端发送过来的数据结束之后调用
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
        System.out.println("信息接收完毕...");
    }

    /**
     * 工程出现异常的时候调用
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }


    /**
     * 心跳检测
     */

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {

        IdleStateEvent event =(IdleStateEvent)evt;
        String eventType = null;
        switch (event.state()){
            case READER_IDLE:
                eventType = "读空闲";
                break;
            case WRITER_IDLE:
                eventType = "写空闲";
                break;
            case ALL_IDLE:
                eventType ="读写空闲";
                break;
        }

        System.out.println(ctx.channel().remoteAddress() + "超时事件：" +eventType);

        ctx.channel().close();
        super.userEventTriggered(ctx, evt);
    }

    /**
     * 服务端处理客户端websocket请求的核心方法，这里接收了客户端发来的信息
     */
    @Override
    public void channelRead(ChannelHandlerContext cxt, Object info) throws Exception {
        System.out.println("接收到了："+info);
        ByteBuf buf = (ByteBuf) info;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body=HexEncode.bytesToHexString(req);
        System.out.println("接收客户端数据:" + body);
        ByteBuf pingMessage = Unpooled.buffer();
        pingMessage.writeBytes(req);
        cxt.writeAndFlush(pingMessage);


        //服务端使用这个就能向 每个连接上来的客户端群发消息
        //NettyConfig.group.writeAndFlush(info);
//        Iterator<Channel> iterator = NettyConfig.group.iterator();
//        while(iterator.hasNext()){
//            //打印出所有客户端的远程地址
//            System.out.println((iterator.next()).remoteAddress());
//        }
    }


}