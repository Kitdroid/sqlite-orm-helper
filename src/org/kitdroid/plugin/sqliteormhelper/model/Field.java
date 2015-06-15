package org.kitdroid.plugin.sqliteormhelper.model;

/**
 * Created by Ô¶º½ on 2015/3/11.
 */
public class Field {
    private String name;
    private String typeName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getValue(){
        StringBuilder builder = new StringBuilder(typeName);
        builder.append(" ");
        builder.append(name);
        return builder.toString();
    }
}
