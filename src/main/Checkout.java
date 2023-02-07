import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class Checkout {
    private static Map<Character, Integer> prices = new HashMap<>();
    private static Map<Character, int[]> offers = new HashMap<>();
    private static Map<Character, Integer> uniqueProducts = new HashMap<>();

    static {
        prices.put('A', 50);
        prices.put('B', 30);
        prices.put('C', 20);
        prices.put('D', 10);

        offers.put('A', new int[] { 3, 130 });
        offers.put('B', new int[] { 2, 37 });
    }

    // this method validates whether the user input is valid (i.e no whitespaces, no lowercase letters)
    private static void validateInput(String userInput){
        if(userInput.contains(" ")){
            throw new IllegalArgumentException("Whitespaces are not allowed in the input.");
        }

        if(!userInput.toUpperCase().equals(userInput)){
            throw new IllegalArgumentException("The input must be in capital letters.");
        }
    }

    // this method calculates the total price of the string of items.
    public static int checkout(String items) throws Exception {
        validateInput(items);

        int total = 0;

        for (char item : items.toCharArray()) {
            if (!prices.containsKey(item)) {
                throw new IllegalArgumentException("The item " + item + " does not exist in the supermarket.");
            }

            // calculate how many entries of each product are in the user input.
            if (!uniqueProducts.containsKey(item)) {
                int numOfItems = items.length() - items.replace(String.valueOf(item), "").length();
                uniqueProducts.put(item, numOfItems);
            }
        }

        for (Map.Entry<Character, Integer> uniqueProduct : uniqueProducts.entrySet()) {
            // if the item is eligible for the offer, find how many 'offer sets' are applicable
            // for this item and how many of the unique items are remaining. Then add their
            // prices to the total
            char uniqueProductName = uniqueProduct.getKey();
            if (offers.containsKey(uniqueProductName)) {
                int numOfItemSetsEligibleForOffer = uniqueProducts.get(uniqueProductName) / offers.get(uniqueProductName)[0];
                total += numOfItemSetsEligibleForOffer * offers.get(uniqueProductName)[1];
                total += (uniqueProducts.get(uniqueProductName) - numOfItemSetsEligibleForOffer * offers.get(uniqueProductName)[0]) * prices.get(uniqueProductName);
            } else {
                // add the prices of items which are not eligible for the offer to the total price
                total += uniqueProducts.get(uniqueProductName) * prices.get(uniqueProductName);
            }
        }

        return total;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Enter a string of items:");
        Scanner sc = new Scanner(System.in);
        String inputItems = sc.nextLine();
        System.out.println(checkout(inputItems));
    }
}