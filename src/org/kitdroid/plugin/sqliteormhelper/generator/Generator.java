package org.kitdroid.plugin.sqliteormhelper.generator;

/**
 * Created by Զ�� on 2015/6/15.
 */
public interface Generator {
    public String generate(String packageName, String tableName, String columnTypeLines, String columnLines);
}
