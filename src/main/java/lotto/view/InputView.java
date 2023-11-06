package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String NOTICE_INPUT_PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    private static final int ONE_LOTTO_PRICE = 1000;
    private static final String ERROR_NOT_DIVIDED_BY_LOTTO_PRICE = "[ERROR] 로또 구입 가격은 로또 하나의 가격인 1000원으로 나누어 떨어져야 합니다.";

    public void inputPurchasePrice() {
        System.out.println(NOTICE_INPUT_PURCHASE_PRICE);
        String input = Console.readLine();
        int purchasePrice = stringToInt(input);
        try {
            validateDividedByLottoPrice(purchasePrice);
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
            inputPurchasePrice();
        }
    }

    private void validateDividedByLottoPrice(int price) {
        if (isNotDividedByLottoPrice(price)) {
            throw new IllegalArgumentException(ERROR_NOT_DIVIDED_BY_LOTTO_PRICE);
        }
    }

    private boolean isNotDividedByLottoPrice(int price) {
        return price % ONE_LOTTO_PRICE != 0;
    }

    private int stringToInt(String before) {
        return Integer.parseInt(before);
    }
}
