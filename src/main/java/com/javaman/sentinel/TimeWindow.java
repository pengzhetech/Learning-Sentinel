package com.javaman.sentinel;

import java.util.concurrent.TimeUnit;

/**
 * @auther: pengzhe
 * @since: 2019/8/31 19:21
 * @description:
 */
public class TimeWindow {
    public static void main(String[] args) throws InterruptedException {
        int windowLength = 500;
        int arrayLength = 2;
        calculate(windowLength, arrayLength);

        TimeUnit.MILLISECONDS.sleep(100);
        calculate(windowLength, arrayLength);

        TimeUnit.MILLISECONDS.sleep(200);
        calculate(windowLength, arrayLength);

        TimeUnit.MILLISECONDS.sleep(200);
        calculate(windowLength, arrayLength);

        TimeUnit.MILLISECONDS.sleep(500);
        calculate(windowLength, arrayLength);

        TimeUnit.MILLISECONDS.sleep(500);
        calculate(windowLength, arrayLength);

        TimeUnit.MILLISECONDS.sleep(500);
        calculate(windowLength, arrayLength);
    }

    private static void calculate(int windowLength, int arrayLength) {


        long time = System.currentTimeMillis();
        long timeId = time / windowLength;
        long currentWindowStart = time - time % windowLength;
        int idx = (int) (timeId % arrayLength);
        System.out.println("time=" + time + ",currentWindowStart="
                + currentWindowStart + ",timeId=" + timeId + ",idx=" + idx);

    }

}
