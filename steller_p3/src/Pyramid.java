public class Pyramid extends Shape3D
{
    public Pyramid(double length, double width, double height)
    {
        this.name = "pyramid";
        this.area = (length * width) +
                (length * Math.sqrt((width * width / 4) + (height * height))) +
                (width * Math.sqrt((length * length / 4) + (height * height)));
        this.volume = length * width * height / 3;
    }
}
