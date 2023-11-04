package view;

import domain.Lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputPrice {
    private static final String LOTTO_PRICE = "구입금액을 입력해 주세요.";
    private static final int BASIC_PRICE = 1000;
    public static int enterPurchaseAmount() {
        System.out.println(LOTTO_PRICE);
        int price = Lotto.checkInteger(readLine());
        validatePrice(price);
        checkPositivePrice(price);
        return price;
    }

    private static void validatePrice(int price){
        if (price % BASIC_PRICE != 0){
            ExceptionMessage.priceException();
            throw new IllegalArgumentException();
        }
    }

    private static void checkPositivePrice(int price){
        if (price <= 0){
            ExceptionMessage.positiveException();
            throw new IllegalArgumentException();
        }
    }
}
