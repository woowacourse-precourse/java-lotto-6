package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputValue {

    public static int getPurchasePrice() {

        String input = readLine();

        emptyValueCheck(input);

        int price = numberCheck(input);

        priceUnitCheck(price);

        return price;
    }

    private static void emptyValueCheck(String input) {
        if (input.length() == 0) throw new IllegalArgumentException();
    }

    private static int numberCheck(String input) {

        if (!input.matches("\\d*")) throw new IllegalArgumentException();

        return Integer.parseInt(input);
    }

    private static void priceUnitCheck(int price) {
        if (price % 1000 != 0) throw new IllegalArgumentException();
    }

}
