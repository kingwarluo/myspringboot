package com.kingwarluo.myspringboot.util;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * @description:随机生成一个Date，指定范围为1960.1.1-2000.1.1
 *
 * @author jianhua.luo
 * @date 2019/6/15
 */
public class RandomDateUtil {

    private static final int min = 1960;

    private static final int max = 2000;

    public static Date getRandomDate(){
        int randomYear = min + new Random().nextInt(40);
        int randomMonth = new Random().nextInt(12);
        int randomDay;
        if(randomMonth == 1 || randomMonth == 3 || randomMonth == 5 ||
                randomMonth == 7 || randomMonth == 8 || randomMonth == 10 || randomMonth == 12) {
            randomDay = new Random().nextInt(31);
        } else if(randomMonth == 2) {
            randomDay = new Random().nextInt(28);
        } else {
            randomDay = new Random().nextInt(30);
        }
        int randomHour = new Random().nextInt(24);
        int randomMinute = new Random().nextInt(60);
        int randomSecond = new Random().nextInt(60);
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, randomYear);
        c.set(Calendar.MONTH, randomMonth);
        c.set(Calendar.DAY_OF_MONTH, randomDay);
        c.set(Calendar.HOUR, randomHour);
        c.set(Calendar.MINUTE, randomMinute);
        c.set(Calendar.SECOND, randomSecond);
        return c.getTime();
    }

    public static void main(String[] args) {
        System.out.println(new Random().nextInt(40));

    }

}
