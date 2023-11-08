package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputConsole {

    public static int inputPrice() {
        String inputPrice = Console.readLine();
        validateInputPrice(inputPrice);
        return Integer.parseInt(inputPrice);
    }

    private static void validateInputPrice(String inputPrice) {
        for (int i = 0; i < inputPrice.length(); i++) {
            if (inputPrice.charAt(i) < '0' || inputPrice.charAt(i) > '9') {
                throw new IllegalArgumentException();
            }
        }
    }

}
