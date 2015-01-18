package imageviewer.control;

import imageviewer.ui.ImageViewer;

public class PreviousImage extends ImageCommand {

    public PreviousImage(ImageViewer viewer) {
        super(viewer);
    }
    
    @Override
    public void execute() {
        this.getViewer().showPrevImage();
    }
    
    

}
