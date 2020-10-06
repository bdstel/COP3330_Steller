public class Cube extends Shape3D
{
    public Cube(double sideLength)
    {
        this.name = "cube";
        this.area = sideLength * sideLength * 6;
        this.volume = sideLength * sideLength * sideLength;
    }
}
