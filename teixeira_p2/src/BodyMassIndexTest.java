import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BodyMassIndexTest {

    @Test
    void testBmiScore24dot506() {
        BodyMassIndex b = new BodyMassIndex(62, 134);
        assertEquals(24.5, b.getUserbmi());
    }
    @Test
    void testBmiScore3dot515() {
        BodyMassIndex b = new BodyMassIndex(100, 50);
        assertEquals(3.5, b.getUserbmi());
    }
    @Test
    void testBmiScore87dot875() {
        BodyMassIndex b = new BodyMassIndex(60, 450);
        assertEquals(87.9, b.getUserbmi());
    }
    @Test
    void testBmiCategoryUnderweight() {
        BodyMassIndex b = new BodyMassIndex(100, 50);
        assertEquals("Underweight", b.getUsercategory());
    }
    @Test
    void testBmiCategoryNormalweight() {
        BodyMassIndex b = new BodyMassIndex(62, 134);
        assertEquals("Normal weight", b.getUsercategory());
    }
    @Test
    void testBmiCategoryOverweight() {
        BodyMassIndex b = new BodyMassIndex(70, 180);
        assertEquals("Overweight", b.getUsercategory());
    }
    @Test
    void testBmiCategoryObesity() {
        BodyMassIndex b = new BodyMassIndex(60, 450);
        assertEquals("Obesity", b.getUsercategory());
    }
}