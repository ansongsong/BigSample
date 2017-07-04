package bigsimple.utils;

import java.net.InetAddress;
import java.util.UUID;

public class UUIDBuild {
	private String sep = "";

	private static final int IP;

	private static short counter = (short) 0;

	private static final int JVM = (int) (System.currentTimeMillis() >>> 8);

	private static UUIDBuild uuidgen = new UUIDBuild();

	static {

		int ipadd;
		try {
			ipadd = toInt(InetAddress.getLocalHost().getAddress());
		} catch (Exception e) {
			ipadd = 0;
		}
		IP = ipadd;
	}

	public static UUIDBuild getInstance() {
		return uuidgen;
	}
	public static void main(String[] args) {
		
	}
	/**
	 * 将二进制转换为int类型
	 * @param bytes
	 * @return
	 */
	public static int toInt(byte[] bytes) {
		int result = 0;
		for (int i = 0; i < 4; i++) {
			result = (result << 8) - Byte.MIN_VALUE + (int) bytes[i];
		}
		return result;
	}

	/**
	 * 将数字转换为16进制。之后保持  00000000 长度不变，后面追加16机制字符串
	 * @param intval
	 * @return
	 */
	protected static String format(int intval) {
		String formatted = Integer.toHexString(intval);
		StringBuffer buf = new StringBuffer("00000000");
		buf.replace(8 - formatted.length(), 8, formatted);
		return buf.toString();
	}

	
	/**
	 * 将数字转换为16进制。之后保持  0000 长度不变，后面追加16机制字符串
	 * @param shortval
	 * @return
	 */
	protected String format(short shortval) {
		String formatted = Integer.toHexString(shortval);
		StringBuffer buf = new StringBuffer("0000");
		buf.replace(4 - formatted.length(), 4, formatted);
		return buf.toString();
	}

	protected int getJVM() {
		return JVM;
	}

	protected synchronized short getCount() {
		if (counter < 0) {
			counter = 0;
		}
		return counter++;
	}

	protected int getIP() {
		return IP;
	}

	protected short getHiTime() {
		return (short) (System.currentTimeMillis() >>> 32);
	}

	protected int getLoTime() {
		return (int) System.currentTimeMillis();
	}
	
	public String generate() {
		return new StringBuffer(36).append(format(getIP())).append(sep).append(
				format(getJVM())).append(sep).append(format(getHiTime()))
				.append(sep).append(format(getLoTime())).append(sep).append(
						format(getCount())).toString();
	}

	

	// 得到一个序号
	public static String getUUID() {
		String s = UUID.randomUUID().toString(); //a1b3e540-f47b-42d9-bb4a-61a4a00b0518
		return s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18)
				+ s.substring(19, 23) + s.substring(24);
	}

	
	/**
	 * 一次得到多个序号
	 * 
	 * @param number
	 *            int 需要获得的序号数量
	 * @return String[] 序号数组
	 */
	public static String[] getUUID(int number) {
		if (number < 1) {
			return null;
		}
		String[] ss = new String[number];
		for (int i = 0; i < ss.length; i++) {
			ss[i] = getUUID();
		}
		return ss;
	}

}
