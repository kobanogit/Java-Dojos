package fr.wildcodeschool;

public enum CoffeeType {
    EXPRESSO("expresso"),
    ARABICA("arabica");



    private String representation;

    CoffeeType(String representation){
        this.representation = representation;
    }
    public String getRepresentation() {
        return representation;
    }
}
