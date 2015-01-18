package imageviewer.model;

public abstract class Image {
    
    private Image nextImage;
    private Image prevImage;
    
    public abstract Bitmap getBitmap();

    public Image getNextImage() {
        return nextImage;
    }

    public void setNextImage(Image nextImage) {
        this.nextImage = nextImage;
    }

    public Image getPrevImage() {
        return prevImage;
    }

    public void setPrevImage(Image prevImage) {
        this.prevImage = prevImage;
    }

    public Image getNext() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Image getPrev() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
