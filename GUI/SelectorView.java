package GUI;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class SelectorView extends JPanel {
    JFileChooser j;
    public SelectorView() {
        j = new JFileChooser();
        j.showSaveDialog(null);
    }
}
