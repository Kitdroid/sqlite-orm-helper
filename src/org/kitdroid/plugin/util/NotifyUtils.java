package org.kitdroid.plugin.util;

import com.intellij.openapi.ui.MessageType;
import com.intellij.openapi.ui.popup.Balloon.Position;
import com.intellij.openapi.ui.popup.JBPopupFactory;
import com.intellij.ui.awt.RelativePoint;

import javax.swing.*;

/**
 * Created by Ô¶º½ on 2015/4/1.
 */
public class NotifyUtils {

    public static void showErrorNotify(String msg, JTextField component) {
        JBPopupFactory.getInstance()
                .createHtmlTextBalloonBuilder(msg, MessageType.ERROR, null)
                .setFadeoutTime(7500)
                .createBalloon()
                .show(RelativePoint.getCenterOf(component), Position.above);
    }

}
