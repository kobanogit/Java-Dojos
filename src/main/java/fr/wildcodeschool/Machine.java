package fr.wildcodeschool;


/*
=> Pour determiner le type de café, on stocke dans un attribut le type de café courant
Il faudra alors un setter pour que toute personne qui appelle cette machine determine son type de café
 */

import java.util.HashMap;
import java.util.Map;

public class Machine implements CoffeeMachine {

    // private static int nbDeCafeVendus;

    private Map<String, Integer> coffeCounter = new HashMap<>();

    @Override
    public Coffee makeCoffee(CoffeeType coffeeType) {
        int newCount;
        if (coffeCounter.containsKey(coffeeType.getRepresentation())){
            // deja present => ajouter un
            newCount = coffeCounter.get(coffeeType.getRepresentation()) + 1;
        } else {
            // sera ajouté
            newCount = 1;

        }
        Coffee coffee = new Coffee();
        coffeCounter.put(coffeeType.getRepresentation(), newCount);
        return coffee;
    }
    //surcharge du constructeur pour setter le type de coffee

    // méthode de retourndu nb total de cafés vendus
    public int  getSoldCoffeeQty(){
        int qtyCoffee = 0;
        for(final Map.Entry<String, Integer> entry : coffeCounter.entrySet()) {
            final String key =  entry.getKey();
            final Integer value =  entry.getValue();

            // Traitement key-value
            qtyCoffee += value;
        }
        return qtyCoffee;
    }


    // %Méthode de retour du nb total de cafés par type
    public int  getSoldCoffeeQtyByType(CoffeeType coffeeType) {
        int qtyCoffee = 0;
        if (coffeCounter.containsKey(coffeeType.getRepresentation())) {
            qtyCoffee = coffeCounter.get(coffeeType.getRepresentation());
        }
        return qtyCoffee;
    }
}
