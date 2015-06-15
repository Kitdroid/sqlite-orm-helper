package org.kitdroid.plugin.sqliteormhelper;

/**
 * Created by Ô¶º½ on 2015/3/11.
 */
public enum Style {
    ActiveAndroid, Ormlite;

    public static String[] names(){
        Style[] values = values();
        String[] names = new String[values.length];
        for(int i = 0; i < values.length; i++){
            names[i] = values[i].name();
        }
        return names;
    }
}
