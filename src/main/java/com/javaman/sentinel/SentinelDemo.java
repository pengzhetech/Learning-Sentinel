package com.javaman.sentinel;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @author pengzhe
 * @date 2019-03-08 20:51
 * @description 执行命令:
 * java -Dahas.namespace=Test -DproppName -Dahas.license=f7b5ad59e7504d2b8ea7510716b3a79a -jar sentinel-1.0-SNAPSHOT.jar
 */

public class SentinelDemo {
    public static void main(String[] args) {
        // 不断进行资源调用.
        while (true) {
            Entry entry = null;
            try {
                entry = SphU.entry("HelloWorld");
                // 资源中的逻辑.
                System.out.println("hello world");
            } catch (BlockException e1) {
                System.out.println("blocked!");
            } finally {
                if (entry != null) {
                    entry.exit();
                }
            }
        }
    }
}
