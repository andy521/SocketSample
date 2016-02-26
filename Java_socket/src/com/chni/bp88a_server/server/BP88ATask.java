package com.chni.bp88a_server.server;

import java.net.InetSocketAddress;

import org.apache.log4j.Logger;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

public class BP88ATask {
	private static final Logger log = Logger.getLogger(BP88ATask.class);

	public static void main(String[] args) {
		try {
			NioSocketAcceptor acceptor = new NioSocketAcceptor();
			acceptor.setHandler(new TcpServer());
			// 设置配置
			acceptor.getSessionConfig().setReadBufferSize(2048);
			acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
//			acceptor.getSessionConfig().setKeepAlive(true);
			acceptor.bind(new InetSocketAddress(TcpServer.PORT));
			log.info("TCP服务启动，端口：" + TcpServer.PORT);
		} catch (Exception e) {
			log.error("服务器启动异常", e);
		}
	}
}
