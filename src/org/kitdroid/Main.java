package org.kitdroid;

import org.kitdroid.plugin.sqliteormhelper.gui.RestApiGeneratorPanel;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("RestApiGenerator");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                RestApiGeneratorPanel pane = new RestApiGeneratorPanel();
                frame.setContentPane(pane);
                frame.pack();
                frame.setVisible(true);
                frame.setMinimumSize(frame.getSize());
            }
        });
    }
}
