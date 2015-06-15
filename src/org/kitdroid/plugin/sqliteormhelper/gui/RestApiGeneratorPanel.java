package org.kitdroid.plugin.sqliteormhelper.gui;

import org.kitdroid.plugin.common.UiUtils;
import org.kitdroid.plugin.gui.LineNumberView;
import org.kitdroid.plugin.sqliteormhelper.Style;
import org.kitdroid.plugin.sqliteormhelper.builder.JavaClassBuilder;
import org.kitdroid.util.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by 远航 on 2015/3/11.
 */
public class RestApiGeneratorPanel extends JPanel{

    public static final int FONT_SIZE = 16;
    private final Font mFont;
    private final JTextArea mDataTypeArea;
    private final JTextArea mColumnsArea;
    private JTextField mPackageField;
    private JTextField mTableField;
    private JComboBox mStyleBox;
//    private JComboBox mRequestBox;
    private JTextArea mCommentArea;

    public RestApiGeneratorPanel() {

        mFont = new Font(Font.MONOSPACED, Font.PLAIN, FONT_SIZE);

        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;

        JPanel infoPanel = initInfoPane();
        add(infoPanel);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.weighty = 1;
        layout.addLayoutComponent(infoPanel, constraints);

        mDataTypeArea = new JTextArea();
        JScrollPane dataTypePane = getjScrollPane("Data type", mFont, mDataTypeArea);
        add(dataTypePane);
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.weightx = 2;
        constraints.weighty = 1;
        layout.addLayoutComponent(dataTypePane, constraints);

        mColumnsArea = new JTextArea();
        JScrollPane parametersPane = getjScrollPane("Column names", mFont, mColumnsArea);
        add(parametersPane);
        constraints.gridx = 3;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.weightx = 2;
        constraints.weighty = 1;
        layout.addLayoutComponent(parametersPane, constraints);

    }

    private JScrollPane getjScrollPane(String title, Font font, JTextArea textArea) {
        textArea.setRows(16);
        textArea.setColumns(20);
        textArea.setFont(font);
        JScrollPane parametersPane = new JScrollPane(textArea);
        parametersPane.setBorder(BorderFactory.createTitledBorder(title));
        parametersPane.setRowHeaderView(new LineNumberView(FONT_SIZE));
        return parametersPane;
    }

    private JPanel initInfoPane() {
        JPanel infoPanel = new JPanel();
        infoPanel.setBorder(BorderFactory.createTitledBorder("Entity information"));
        GridBagLayout layout = new GridBagLayout();
        infoPanel.setLayout(layout);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        JLabel styleLabel = addLabel(infoPanel, "* Code Style：");
        JLabel tableLabel = addLabel(infoPanel, "* Table Name：");
        JLabel packageLabel = addLabel(infoPanel, "  Package Name：");
        JLabel commentLabel = addLabel(infoPanel, "  Comment：");

        mStyleBox = new JComboBox(Style.names());
        mStyleBox.setFont(mFont);
        infoPanel.add(mStyleBox);

//        mRequestBox = new JComboBox(RequestType.names());
//        mRequestBox.setFont(mFont);
//        infoPanel.add(mRequestBox);

        mCommentArea = new JTextArea(3,20);
        mCommentArea.setFont(mFont);
        infoPanel.add(mCommentArea);


        mPackageField = addField(infoPanel, 20);
        mTableField = addField(infoPanel, 20);

        JButton cleanButton = addButton(infoPanel, "Clean");
        JButton createButton = addButton(infoPanel, "Create");

        JPanel gapPanel = new JPanel();
        infoPanel.add(gapPanel);

        JPanel vPanel = new JPanel();
        infoPanel.add(vPanel);

        constraints.gridx = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 0;
        constraints.weighty = 0;

        constraints.gridy = 0;
        layout.setConstraints(styleLabel,constraints);
        constraints.gridy = 1;
        layout.setConstraints(tableLabel,constraints);

        constraints.gridy = 2;
        layout.setConstraints(packageLabel,constraints);
        constraints.gridy = 3;
        layout.setConstraints(commentLabel,constraints);


        // 第二列 输入框等
        constraints.gridx = 1;
        constraints.gridwidth = 3;
        constraints.weighty = 1;

        constraints.gridy = 0;
        layout.setConstraints(mStyleBox,constraints);

        constraints.gridy = 1;
        layout.setConstraints(mTableField,constraints);

        constraints.gridy = 2;
        layout.setConstraints(mPackageField,constraints);

        constraints.gridy = 3;
        constraints.weightx = 3;
        layout.setConstraints(mCommentArea,constraints);

        constraints.gridy = 5;
        constraints.gridwidth = 1;
        constraints.weightx = 1;
        layout.setConstraints(cleanButton,constraints);
        constraints.gridx = 2;
        layout.setConstraints(gapPanel,constraints);
        constraints.gridx = 3;
        layout.setConstraints(createButton,constraints);

        constraints.gridx = 0;
        constraints.gridy = 6;
        constraints.gridwidth = 5;
        constraints.weightx = 5;
        constraints.weighty = 5;
        layout.setConstraints(vPanel,constraints);

        cleanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doClean();
            }
        });

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doGenerate();
            }
        });

//        mPackageField.setText("getHost()");
//        mTableField.setText("user/login");
        return infoPanel;
    }

    private void doGenerate() {
        Style style = Style.values()[mStyleBox.getSelectedIndex()];

//        RequestType requestType = RequestType.values()[mRequestBox.getSelectedIndex()];
        String commentText = mCommentArea.getText();
        String packageText = mPackageField.getText();
        String tableText = mTableField.getText();
        String dataTypeLines = mDataTypeArea.getText();
        String columnsLines = mColumnsArea.getText();

        if(StringUtils.isEmpty(tableText)){
            // TODO
            UiUtils.showAlert("Table name can't be null !");
            return;
        }

//        ApiBuilder builder = JavaClassBuilder.getBuilder(style);
//        builder.setRequestType(requestType);
//        builder.setComment(commentText);
//        builder.setUrl(hostText, pathText);
//        builder.setParameters(dataTypeLines,parameterLines);
//        String apiStr = builder.getResult();
//
//        Generator generator = GeneratorFactory.create(style);
//        String codeString = generator.generate(requestType,commentText,hostText,pathText, dataTypeLines, parameterLines);
//        // TODO 处理生成的代码
//        Log.i(codeString);
    }

    private void doClean() {
        mCommentArea.setText("");
        mPackageField.setText("");
        mTableField.setText("");
        mDataTypeArea.setText("");
        mColumnsArea.setText("");
    }

    private JButton addButton(JPanel infoPanel, String text) {
        JButton cleanButton = new JButton(text);
        infoPanel.add(cleanButton);
        return cleanButton;
    }

    private JTextField addField(JPanel parent, int columns) {
        JTextField hostField = new JTextField(columns);
        hostField.setFont(mFont);
        parent.add(hostField);
        return hostField;
    }

    private JLabel addLabel(JPanel parent, String text) {
        JLabel commentLabel = new JLabel(text);
        commentLabel.setFont(mFont);
        parent.add(commentLabel);
        return commentLabel;
    }
}
