package org.kitdroid.plugin.sqliteormhelper.generator;

import org.kitdroid.plugin.sqliteormhelper.model.Field;

import java.util.List;

/**
 * Created by Ô¶º½ on 2015/3/11.
 */
public class ActiveAndroidGenerator extends BaseGenerator {

    @Override
    public String generate(String packageName, String className, List<Field> fields) {
        return "OrmliteGenerator";
    }
}
