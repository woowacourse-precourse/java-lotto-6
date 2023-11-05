package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Coin {
    private static final String START_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INSERT_ERROR_COIN = "[ERROR] 돈을 1000원 이상으로 넣어주세요.";
    private static final String THOUSAND_CHECK = "[ERROR] 1000원 단위로 돈을 넣어주세요.";
    private static final String BLANK_ERROR_COIN = "[ERROR] 숫자로 제대로 입력해주세요,";

    private Integer inputCoin;
    private String insertCoin;

    public void inputCoin() {
        do {
            try {
                insertCoin();
                zeroMoreThanCoin(inputCoin);
                thousandCheck(inputCoin);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true);
    }

    public int getInputCoin() {
        return inputCoin;
    }

    public void insertCoin() {
        printNotice();
        insertCoin = Console.readLine().trim();
        if (insertCoin.isEmpty()) {
            throw new IllegalArgumentException(BLANK_ERROR_COIN);
        }
        try {
            inputCoin = Integer.parseInt(insertCoin);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BLANK_ERROR_COIN);
        }
    }

    public void printNotice() {
        System.out.println(START_MESSAGE);
    }

    private void zeroMoreThanCoin(Integer coin) {
        if (coin <= 0) {
            throw new IllegalArgumentException(INSERT_ERROR_COIN);
        }
    }

    private void thousandCheck(Integer coin) {
        if (coin % 1000 != 0) {
            throw new IllegalArgumentException(THOUSAND_CHECK);
        }
    }

}
