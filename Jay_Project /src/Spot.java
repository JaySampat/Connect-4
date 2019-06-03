import org.newdawn.slick.Image;

public class Spot {
    int x;
    int y;
    Image image;
    float scale;
    public Spot (int x,int y){
        this.x = x;
        this.y = y;
        image = null;
        scale = 0.016f;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }
}
