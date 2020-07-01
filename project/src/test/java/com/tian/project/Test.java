package com.tian.project;

import lombok.extern.slf4j.Slf4j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class Test {
    public static void main(String[] args) {

        String strMac = "1918FC09FFFA";
        long macInt  = Long.parseLong(strMac, 16);
        System.out.println(macInt );
        String mac = Long.toHexString(macInt ).toUpperCase();
        System.out.println(mac);
        boolean mac12 = isMac12(strMac);
        if (mac12) {
            log.info("Mac格式正确");
        } else {
            log.info("Mac格式错误");
        }

    }

    public static boolean isMac12(String input) {
        boolean result = false;
        if (input == null) {
            return result;
        }
        if (input.equals("")) {
            return result;
        }
        if (input.length() == 12) {
            Pattern p = Pattern.compile("[A-Fa-f0-9]{12}");
            Matcher m = p.matcher(input);
            result = m.matches();
        }
        return result;
    }


}
