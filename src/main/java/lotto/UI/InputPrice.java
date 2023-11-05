package lotto.UI;

import camp.nextstep.edu.missionutils.Console;

public class InputPrice {
    public int inputPrice() {
        int price = -1;
        while (price < 0) {
            System.out.println("구입금액을 입력해 주세요.");
            try {
                price = checkPrice(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return price;
    }
    private int checkPrice(String inputPrice) {
        int price = checkPriceToInt(inputPrice);
        checkPriceUnit(price);
        return price;
    }
    private int checkPriceToInt(String inputPrice) {
        try {
            return Integer.parseInt(inputPrice);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자로 입력해주세요.");
        }
    }
    private void checkPriceUnit(int inputPrice) {
        if (inputPrice % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력해주세요.");
        }
    }
}
