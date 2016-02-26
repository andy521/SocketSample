package com.chni.bp88a_server.utils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public final class IOUtil {
	private IOUtil() {
	}

	public static DataInputStream getDIS(Socket socket) throws IOException {
		return new DataInputStream(socket.getInputStream());
	}

	public static DataOutputStream getDOS(Socket socket) throws IOException {
		return new DataOutputStream(socket.getOutputStream());
	}

	public static PrintWriter getWriter(File file) throws IOException {
		return new PrintWriter(new OutputStreamWriter(new FileOutputStream(
				file, true), "utf-8"), true);
	}
}
