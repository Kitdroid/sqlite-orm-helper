package org.kitdroid.plugin.sqliteormhelper;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.kitdroid.plugin.sqliteormhelper.gui.RestApiGeneratorPanel;

import javax.swing.*;

/**
 * Created by 远航 on 2015/6/15.
 */
public class GeneratorAction extends AnAction {
	public void actionPerformed(AnActionEvent e) {
		showDialog();
	}

	private void showDialog() {

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		RestApiGeneratorPanel pane = new RestApiGeneratorPanel();
		frame.setContentPane(pane);
		frame.pack();
		frame.setVisible(true);
		frame.setMinimumSize(frame.getSize());
	}
}
