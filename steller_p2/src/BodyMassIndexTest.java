import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BodyMassIndexTest
{
    @Test
    public void testScore()
    {
        BodyMassIndex bmi = new BodyMassIndex(72, 180);

        assertEquals(24.4, bmi.score);
    }

    @Test
    public void testCategory()
    {
        BodyMassIndex bmi = new BodyMassIndex(72, 180);

        assertEquals("Normal weight", bmi.category);
    }

    @Test
    public void testBMIUnderweight()
    {
        BodyMassIndex bmi = new BodyMassIndex(69, 120);
        assertEquals(17.7, bmi.score);
        assertEquals("Underweight", bmi.category);
    }

    @Test
    public void testBMINormalWeight()
    {
        BodyMassIndex bmi = new BodyMassIndex(72, 160);
        assertEquals(21.7, bmi.score);
        assertEquals("Normal weight", bmi.category);
    }

    @Test
    public void testBMIOverweight()
    {
        BodyMassIndex bmi = new BodyMassIndex(70, 200);
        assertEquals(28.7, bmi.score);
        assertEquals("Overweight", bmi.category);
    }

    @Test
    public void testBMIObesity()
    {
        BodyMassIndex bmi = new BodyMassIndex(67, 200);
        assertEquals(31.3, bmi.score);
        assertEquals("Obesity", bmi.category);
    }
}
