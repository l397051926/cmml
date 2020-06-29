
package com.lj.cmml.common.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * http utils
 */
public class IpUtils {

  private static final Logger logger = LoggerFactory.getLogger(IpUtils.class);
  public static final String DOT = ".";

  /**
   * ip str to long <p>
   *
   * @param ipStr ip string
   * @return ip to long
   */
  public static Long ipToLong(String ipStr) {
    String[] ipSet = ipStr.split("\\" + DOT);

    return Long.parseLong(ipSet[0]) << 24 | Long.parseLong(ipSet[1]) << 16 | Long.parseLong(ipSet[2]) << 8 | Long.parseLong(ipSet[3]);
  }

  /**
   * long to ip
   * @param ipLong the long number converted from IP
   * @return String
   */
  public static String longToIp(long ipLong) {
    long[] ipNumbers = new long[4];
    long tmp = 0xFF;
    ipNumbers[0] = ipLong >> 24 & tmp;
    ipNumbers[1] = ipLong >> 16 & tmp;
    ipNumbers[2] = ipLong >> 8 & tmp;
    ipNumbers[3] = ipLong & tmp;

    StringBuilder sb = new StringBuilder(16);
    sb.append(ipNumbers[0]).append(DOT)
            .append(ipNumbers[1]).append(DOT)
            .append(ipNumbers[2]).append(DOT)
            .append(ipNumbers[3]);
    return sb.toString();
  }

}
