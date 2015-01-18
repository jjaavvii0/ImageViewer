package imageviewer.ui.swing;

import imageviewer.ui.ImageViewer;
import java.awt.BorderLayout;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AppFrame extends JFrame {
    
    private ImageViewer imageViewer;
    private ActionListenerFactory factory;
    
    public AppFrame(ActionListenerFactory factory) {
        super("Image Browser");
        this.factory = factory;
        this.setSize(1024, 768);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.createComponents();
    }

    public ImageViewer getImageViewer() {
        return imageViewer;
    }
    
    private void createComponents() {
        this.add(createToolbar(), BorderLayout.EAST);
        this.add(createImagePanel());
    }
    
    private JPanel createToolbar() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Controls"));
        panel.add(createButton("Prev"));
        panel.add(createButton("Next"));
        return panel;
    }

    private JButton createButton(String label) {
        JButton button = new JButton(label);
        button.addActionListener(factory.create(label));
        return button;
    }

    private JPanel createImagePanel() {
        ImagePanel panel = new ImagePanel();
        imageViewer = panel;
        return panel;
    }

}