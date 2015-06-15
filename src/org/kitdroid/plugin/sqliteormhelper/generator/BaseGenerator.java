package org.kitdroid.plugin.sqliteormhelper.generator;

import com.sun.istack.internal.NotNull;
import org.kitdroid.plugin.sqliteormhelper.model.Field;
import org.kitdroid.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ô¶º½ on 2015/3/11.
 */
public abstract class BaseGenerator implements Generator {

    public abstract String generate(String packageName, String className, List<Field> fields);

    public String generate(String packageName, String tableName, String columnTypeLines, String columnLines) {
        List<Field> fields = formatField(columnTypeLines, columnLines);
        return generate(packageName, tableName, fields);
    }

    protected String formatDocComment(String comment) {
        String[] commentLines = comment.split("\n");
        StringBuilder builder = new StringBuilder("/**\n");
        for (String line : commentLines) {
            builder.append("* ");
            builder.append(line);
            builder.append("\n");
        }
        builder.append("*/");
        return builder.toString();
    }

    protected String formatUrl(@NotNull String host, String path) {
        StringBuilder builder = new StringBuilder(host);
        if (!StringUtils.isEmpty(path)) {
            builder.append(" + \"");
            builder.append(path.replace(" ", ""));
            builder.append("\"");
        }
        return builder.toString();
    }

    protected String formatMethodName(@NotNull String path) {
        String methodName = splitLineToCamel(path, "/");
        methodName = splitLineToCamel(methodName, "=");
        methodName = splitLineToCamel(methodName, "&");
        methodName = splitLineToCamel(methodName, "\\?");
        methodName = splitLineToCamel(methodName, "\\.");
        return methodName.replace(" ", "");
    }

    protected List<Field> formatField(String columnTypeLines, String columnLines) {
        String[] types = columnTypeLines.replace(" ", "\n").split("\n");
        String[] names = columnLines.replace(" ", "\n").split("\n");
        ArrayList<Field> parameters = new ArrayList<Field>();
        int length = names.length;
        for (int i = 0; i < length; i++) {
            String name = names[i];
            if (StringUtils.isEmpty(name)) {
                continue;
            }
            Field field = new Field();
            field.setName(name);
            String type = i < types.length ? types[i] : "String";
            field.setTypeName(StringUtils.isEmpty(type) ? "String" : type);
            parameters.add(field);
        }

        return parameters;
    }

    protected String splitLineToCamel(String param, String taget) {
        String paramTrim = param.trim();
        String tagetTrim = taget.trim();
        if (StringUtils.isEmpty(paramTrim)) {
            return "";
        }
        if (StringUtils.isEmpty(tagetTrim)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(paramTrim);
        Matcher mc = Pattern.compile(taget).matcher(paramTrim);
        int i = 0;
        while (mc.find()) {
            int position = mc.end() - (i++);
            //String.valueOf(Character.toUpperCase(sb.charAt(position)));
            sb.replace(position - 1, position + 1, sb.substring(position, position + 1).toUpperCase());
        }
        return sb.toString();
    }

}
