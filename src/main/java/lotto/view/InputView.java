package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Constants;

public class InputView {
    public Integer getPrice() {
        while (true) {
            System.out.println(Constants.GET_PRICE_MESSAGE);
            String price = Console.readLine();

            try {
                validatePriceInput(price);
                return Integer.parseInt(price);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validatePriceInput(String price) {
        try {
            int convertPrice = Integer.parseInt(price);
            if (convertPrice % Constants.PRICE_UNIT != 0) {
                throw new IllegalArgumentException(Constants.NOT_UNIT_PRICE_ERROR);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Constants.NOT_INT_PRICE_ERROR);
        }
    }
}
