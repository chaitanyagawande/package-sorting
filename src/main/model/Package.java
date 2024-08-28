package model;

public class Package {
    private int width;
    private int height;
    private int length;
    private double mass;

    public Package(int width, int height, int length, double mass) {
        this.width = width;
        this.height = height;
        this.length = length;
        this.mass = mass;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }

    public double getMass() {
        return mass;
    }

    public int getVolume() {
        return width * height * length;
    }
}
