package fr.wildcodeschool;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MachineTest {
    Machine machine;

    @BeforeEach
    void setup(){
        machine = new Machine();
    }

    @Test
    public void makeCoffeTest () {
        assertNotNull(machine.makeCoffee(CoffeeType.ARABICA));

    }

    @Test
    public void getGoodCoffeeCount () {
        machine.makeCoffee(CoffeeType.ARABICA);
        machine.makeCoffee(CoffeeType.ARABICA);
        machine.makeCoffee(CoffeeType.EXPRESSO);

        assertEquals(3, machine.getSoldCoffeeQty());

    }

    @Test
    public void getGoodCoffeeCountByType () {
        machine.makeCoffee(CoffeeType.ARABICA);
        machine.makeCoffee(CoffeeType.ARABICA);
        machine.makeCoffee(CoffeeType.EXPRESSO);

        assertEquals(2, machine.getSoldCoffeeQtyByType(CoffeeType.ARABICA));

    }

    @Test
    public void getGoodCoffeeCountByTypeNotUsed () {
        machine.makeCoffee(CoffeeType.ARABICA);
        machine.makeCoffee(CoffeeType.ARABICA);
        machine.makeCoffee(CoffeeType.ARABICA);

        assertEquals(0, machine.getSoldCoffeeQtyByType(CoffeeType.EXPRESSO));

    }
}
