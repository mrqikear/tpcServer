package ServerManager;

import io.netty.channel.ChannelHandlerContext;

import java.util.HashMap;

public class TcpClientManager {

    public static HashMap<ChannelHandlerContext,TcpClientObj> TcpClientMap;
    /*
     * 注册登录对象到map中
     * @param ctx
     * @param tcpClientObj
     * @return
     */
    public static boolean addObj(ChannelHandlerContext ctx , TcpClientObj tcpClientObj){
        if(ctx == null || tcpClientObj ==null) return false;
        TcpClientMap.put(ctx,tcpClientObj);
        return true;
    }
}
