public class Circle extends Shape2D
{
    public Circle(double radius)
    {
        this.name = "circle";
        this.area = Math.PI * radius * radius;
    }
}
