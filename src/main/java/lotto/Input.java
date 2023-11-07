package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {

    public int price() {
        int price = 0;
        boolean validPrice = false;

        do {
            try {
                price = inputprice();
                validPrice = true;
            } catch (IllegalArgumentException wrongPrice) {
                System.out.println("[ERROR] 1000원 단위의 정수로 입력해주세요");
            }
        } while (!validPrice);
        return price;
    }

    private int inputprice() {
        String rawPrice = Console.readLine();
        checkPrice(rawPrice);
        int convertPrice = Integer.parseInt(rawPrice);

        return convertPrice;
    }

    private void checkPrice(String rawPrice) {
        int convertedPrice = Converter.parseToInt(rawPrice);

        if (!(convertedPrice % 1000 == 0 && convertedPrice > 0)) {
            throw new IllegalArgumentException("1000원 단위의 정수로 입력해주세요");
        }
    }

}
