package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final String PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_LOTTERY_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    private Input() {
    }

    public String readPurchaseMoney() {
        System.out.println(PURCHASE_MESSAGE);
        return Console.readLine();
    }

    public String readWinningLotteryNumbers() {
        System.out.println(WINNING_LOTTERY_NUMBERS_MESSAGE);
        return Console.readLine();
    }

    public String readBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        return Console.readLine();
    }
}
