public class Square extends Shape2D
{
    public Square(double sideLength)
    {
        this.name = "square";
        this.area = sideLength * sideLength;
    }
}