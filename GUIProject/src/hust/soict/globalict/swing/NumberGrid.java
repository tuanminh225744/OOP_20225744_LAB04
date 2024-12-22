package hust.soict.globalict.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberGrid extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton[] btnNumbers = new JButton[10];
    private JButton btnDelete, btnReset;
    private JTextField tfDisplay;

    public NumberGrid() {
        tfDisplay = new JTextField();
        tfDisplay.setComponentOrientation(
            ComponentOrientation.RIGHT_TO_LEFT
        );
        tfDisplay.setEditable(false); // Không cho phép nhập trực tiếp

        JPanel panelButtons = new JPanel(new GridLayout(4, 3));
        addButtons(panelButtons);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(tfDisplay, BorderLayout.NORTH);
        cp.add(panelButtons, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Number Grid");
        setSize(300, 300);
        setVisible(true);
    }

    private void addButtons(JPanel panel) {
        // Thêm các nút số (0-9)
        for (int i = 1; i <= 9; i++) {
            btnNumbers[i] = new JButton(String.valueOf(i));
            panel.add(btnNumbers[i]);
            btnNumbers[i].addActionListener(new ButtonClickListener());
        }
        
        // Nút Delete
        btnDelete = new JButton("DEL");
        panel.add(btnDelete);
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = tfDisplay.getText();
                if (!text.isEmpty()) {
                    tfDisplay.setText(text.substring(0, text.length() - 1));
                }
            }
        });
        

        // Nút số 0
        btnNumbers[0] = new JButton("0");
        panel.add(btnNumbers[0]);
        btnNumbers[0].addActionListener(new ButtonClickListener());
        
        // Nút Reset
        btnReset = new JButton("C");
        panel.add(btnReset);
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfDisplay.setText(""); // Xóa toàn bộ nội dung
            }
        });
        
    }

    
    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            tfDisplay.setText(tfDisplay.getText() + command);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new NumberGrid());
    }
}
