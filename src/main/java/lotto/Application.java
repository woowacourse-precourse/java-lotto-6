package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        startLotto();
    }

    public static void startLotto() {
        int price = inputPrice();
        System.out.println();
    }

    public static int inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int price = Integer.parseInt(input);

        try {
            Exception.priceValidate(price);
        } catch (IllegalArgumentException e) {
            Exception.printException(e.getMessage());
            inputPrice();
        }

        return price;
    }
}
