package imageviewer.control;
import imageviewer.ui.ImageViewer;
public class NextImage extends ImageCommand {
    
public NextImage(ImageViewer viewer) {
    super(viewer);
}
@Override
public void execute() {
    this.getViewer().showNextImage();
}
}