package GUI;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Font;

public class DirectorView extends JPanel {

    public DirectorView() {
        

		JFileChooser j = new JFileChooser("Select the course list");
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 10, 200, 200);
		textArea.setText("TEst text");
		textArea.setEditable(false);
		// //made the font momospace to look nicer
		textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        this.add(textArea);
		this.setVisible(true);

    }

}
