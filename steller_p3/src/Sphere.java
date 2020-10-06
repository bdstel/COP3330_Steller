public class Sphere extends Shape3D
{
    public Sphere(double radius)
    {
        this.name = "sphere";
        this.area = 4 * Math.PI * radius * radius;
        this.volume = (4.0 / 3.0) * Math.PI * radius * radius * radius;
    }
}
