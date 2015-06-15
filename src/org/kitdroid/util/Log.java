package org.kitdroid.util;

/**
 * Created by huiyh on 15/1/21.
 */
public class Log {

    public static final boolean isDeveloping = true;

    public static final void i(String message) {
        if(isDeveloping){
            System.out.println(message);
        }
    }

}
