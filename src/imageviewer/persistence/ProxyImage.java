package imageviewer.persistence;

import imageviewer.model.Bitmap;
import imageviewer.model.Image;

public class ProxyImage extends Image {
    
    private final ImageLoader loader;
    private Image realImage;

    public ProxyImage(ImageLoader loader) {
        this.loader = loader;
    }
    
    @Override
    public Bitmap getBitmap() {
        checkImageLoaded();
        return realImage.getBitmap();
    }

    private void checkImageLoaded() {
        if (realImage != null) return;
        realImage = loader.load();
    }



}
