package fr.wildcodeschool;

public class Coffee {
private CoffeeType coffeeType;

    public final String getType() {
        String type = coffeeType.getRepresentation();
        return type;
    }
}
