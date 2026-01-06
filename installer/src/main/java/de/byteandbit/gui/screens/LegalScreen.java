package de.byteandbit.gui.screens;

import de.byteandbit.gui.Gui;

import javax.swing.*;
import java.awt.*;

import static de.byteandbit.Util.uiText;

/**
 * Screen that prompts the user to accept the legal agreement.
 */
public class LegalScreen implements Screen{

    @Override
    public JPanel getScreen() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));

        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JTextPane textPane = new JTextPane() {

            @Override
            public Dimension getPreferredSize() {
                Container parent = getParent();
                return new Dimension(parent.getWidth(), super.getPreferredSize().height);
            }
        };
        textPane.setContentType("text/html");
        textPane.setText(uiText("INSTALLER_AGREEMENT_TEXT"));
        textPane.setEditable(false);

        JButton acceptButton = new JButton(uiText("ACCEPT_AND_CONTINUE"));
        acceptButton.addActionListener(e -> {
            Gui.getInstance().showScreen(new LicenseScreen());
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(acceptButton);

        JPanel contentPanel = new JPanel(new BorderLayout());
        
        contentPanel.add(textPane, BorderLayout.CENTER);
        contentPanel.add(buttonPanel, BorderLayout.SOUTH);

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        SwingUtilities.invokeLater(() -> scrollPane.getVerticalScrollBar().setValue(0));

        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }

    @Override
    public String identifier() {
        return "legal";
    }

    @Override
    public void onOpen() {

    }

    @Override
    public void onClose() {

    }
}
