package UI.Custom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class PlaceholderTextField extends JTextField implements FocusListener {
    private String placeholder;
    private boolean isEmpty = true;

    public PlaceholderTextField() {
        addFocusListener(this);
        setForeground(Color.GRAY);
        setText(placeholder);
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (isEmpty) {
            setText("");
            setForeground(Color.BLACK);
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (getText().isEmpty()) {
            setText(placeholder);
            setForeground(Color.GRAY);
            isEmpty = true;
        } else {
            isEmpty = false;
        }
    }
}
