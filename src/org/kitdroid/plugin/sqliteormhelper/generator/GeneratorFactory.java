package org.kitdroid.plugin.sqliteormhelper.generator;


import org.kitdroid.plugin.sqliteormhelper.Style;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ô¶º½ on 2015/3/11.
 */
public class GeneratorFactory {
    private static final Map<Style,Generator> styles;
    static {
        styles = new HashMap<Style, Generator>();
        styles.put(Style.ActiveAndroid, new ActiveAndroidGenerator());
        styles.put(Style.Ormlite, new OrmliteGenerator());
    }
    public static Generator create(Style style){
        if(!styles.containsKey(style)){
            throw new IllegalStateException();
        }
        return styles.get(style);
    }
}
