package ServerManager;

import io.netty.channel.ChannelHandlerContext;

public class TcpClientObj {
    //连接对象
    public ChannelHandlerContext ctx;
    public boolean IsLogin =false;
    public String concentrator;

    public String getConcentrator() {
        return concentrator;
    }

    public void setConcentrator(String concentrator) {
        this.concentrator = concentrator;
    }

    public ChannelHandlerContext getCtx() {
        return ctx;
    }

    public void setCtx(ChannelHandlerContext ctx) {
        this.ctx = ctx;
    }

    public boolean isLogin() {
        return IsLogin;
    }

    public void setLogin(boolean login) {
        IsLogin = login;
    }


    @Override
    public String toString() {
        return "TcpClientObj{" +
                "ctx=" + ctx +
                ", IsLogin=" + IsLogin +
                ", concentrator='" + concentrator + '\'' +
                '}';
    }
}
