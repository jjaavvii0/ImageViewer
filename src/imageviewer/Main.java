package imageviewer;

import imageviewer.control.Command;
import imageviewer.control.NextImage;
import imageviewer.control.PreviousImage;
import imageviewer.ui.swing.AppFrame;
import imageviewer.model.Image;
import imageviewer.persistence.ImageListLoader;
import imageviewer.persistence.file.FileImageListLoader;
import imageviewer.ui.swing.ActionListenerFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        new Main().execute();
    }
    
    private static final String PATH = "C:\\Users\\Public\\Pictures\\Sample Pictures";
    private Map<String, Command> commandMap;
    private AppFrame frame;

    private void execute() {
        ImageListLoader loader = createImageListLoader(PATH);
        List<Image> list = loader.load();
        frame = new AppFrame(createActionListenerFactory());
        frame.getImageViewer().setImage(list.get(0));
        createCommands();
        frame.setVisible(true);
    }

    private void createCommands() {
        commandMap = new HashMap<>();
        commandMap.put("Next", new NextImage(frame.getImageViewer()));
        commandMap.put("Prev", new PreviousImage(frame.getImageViewer()));
    }

    private ImageListLoader createImageListLoader(String path) {
        return new FileImageListLoader(path);
    }

    private ActionListenerFactory createActionListenerFactory() {
        return new ActionListenerFactory() {

            @Override
            public ActionListener create(final String action) {
                return new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        Command command = commandMap.get(action);
                        if (command == null) return;
                        command.execute();
                    }
                };
            }
        };
    }

    
}
