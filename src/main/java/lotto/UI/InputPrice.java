package lotto.UI;

import camp.nextstep.edu.missionutils.Console;

public class InputPrice {
    public int inputPrice() {
            System.out.println("구입금액을 입력해 주세요.");
            try {
                return checkPrice(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                inputPrice();
            }
            return 0;
    }
    private int checkPrice(String inputPrice) {
        int price = checkPriceToInt(inputPrice);
        checkPriceUnit(price);
        return price;
    }
    public static int checkPriceToInt(String inputPrice) {
        try {
            return Integer.parseInt(inputPrice);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자로 입력해주세요.");
        }
    }
    public static void checkPriceUnit(int inputPrice) {
        if (inputPrice % 1000 != 0 || inputPrice < 1000) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력해주세요.");
        }
    }
}
