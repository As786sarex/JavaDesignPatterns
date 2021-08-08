package creational.builder;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CakeBuilderTest {

    @Test
    public void shouldBuildAppropriateCakeObjectWithAllFields(){
        Cake cake=CakeBuilder.builder()
                .withEgg(false)
                .withFlavour(CakeFlavour.CHOCOLATE)
                .withPrice(100)
                .build();
        assertEquals(CakeFlavour.CHOCOLATE,cake.getFlavour());
        assertEquals(100,cake.getPrice());
        assertFalse(cake.isWithEgg());
    }
}