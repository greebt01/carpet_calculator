package Greene;

public class Room {
    private float area;
    public Room(int length, int width) {
        this.area=length*width;

    }

    public float getArea() {
        return area;
    }
}
