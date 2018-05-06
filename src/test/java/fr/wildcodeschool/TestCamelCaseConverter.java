package fr.wildcodeschool;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCamelCaseConverter {
    @Test
    public void testSingleWordConversionLC() {
        CamelCaseConverter camelCaseConverter = new CamelCaseConverter();
        assertEquals("the", camelCaseConverter.toCamelCase("the"));
    }

    @Test
    public void testSingleWordConversionUC() {
        CamelCaseConverter camelCaseConverter = new CamelCaseConverter();
        assertEquals("The", camelCaseConverter.toCamelCase("The"));
    }
    @Test
    public void testExample1() {
        CamelCaseConverter camelCaseConverter = new CamelCaseConverter();
        assertEquals("theStealthWarrior", camelCaseConverter.toCamelCase("the-stealth-warrior"));
    }
    @Test
    public void testExample1bis() {
        CamelCaseConverter camelCaseConverter = new CamelCaseConverter();
        assertEquals("TheStealthWarrior", camelCaseConverter.toCamelCase("The_Stealth_Warrior"));
    }

    @Test
    public void testAllUppercaseWord(){
        CamelCaseConverter camelCaseConverter = new CamelCaseConverter();
        assertEquals("TexAvery", camelCaseConverter.toCamelCase("TEX_AVERY"));
    }


}
