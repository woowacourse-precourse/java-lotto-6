package lotto;

import camp.nextstep.edu.missionutils.Console;


public class Input {

    public int inputPrice() {
        int price = 0;
        boolean validPrice = false;

        do {
            try {
                price = inputprice();
                validPrice = true;
            } catch (IllegalArgumentException wrongPrice) {
                System.out.println("[ERROR] " + wrongPrice.getMessage());
            }
        } while (!validPrice);
        return price;
    }

    private int inputprice() {
        String rawPrice = Console.readLine();
        checkPrice(rawPrice);
        return Integer.parseInt(rawPrice);
    }

    private void checkPrice(String rawPrice) {
        int convertedPrice = Converter.parseToInt(rawPrice);

        if (!(convertedPrice % 1000 == 0 && convertedPrice > 0)) {
            throw new IllegalArgumentException("1000원 단위의 정수로 입력해주세요");
        }
    }
}
