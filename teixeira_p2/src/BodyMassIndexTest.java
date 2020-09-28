import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BodyMassIndexTest {

    @Test
    void testcalculateBmiScore24dot5() {
        assertEquals(24.5, BodyMassIndex.calculateBmiScore(62, 134));
    }

    @Test
    void testcalculateBmiScore3dot5() {
        assertEquals(3.5, BodyMassIndex.calculateBmiScore(100, 50));
    }

    @Test
    void testcalculateBmiCategoryUnderweight() {
        assertEquals("Underweight", BodyMassIndex.calculateBmiCategory(10));
    }
    @Test
    void testcalculateBmiCategoryNormalweight() {
        assertEquals("Normal weight", BodyMassIndex.calculateBmiCategory(24));
    }
    @Test
    void testcalculateBmiCategoryOverweight() {
        assertEquals("Overweight", BodyMassIndex.calculateBmiCategory(28));
    }
    @Test
    void testcalculateBmiCategoryObesity() {
        assertEquals("Obesity", BodyMassIndex.calculateBmiCategory(40));
    }

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