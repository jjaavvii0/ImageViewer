package imageviewer.persistence;

import imageviewer.model.Image;
import java.util.List;

public abstract class ImageListLoader {
    
    public abstract List<Image> load();

}
