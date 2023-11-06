package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Inputter {

    private static final int MONEY_UNIT = 1000;
    private static Inputter inputter;

    private Inputter() {}

    public static Inputter getInputter() {
        if (inputter == null) {
            inputter = new Inputter();
        }
        return inputter;
    }

    public int purchase() {
        int won;

        System.out.println("구입금액을 입력해 주세요.");
        try {
            won = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 올바른 금액을 입력해주세요.");
        }
        validatePurchase(won);
        return won;
    }

    private void validatePurchase(int won) {
        if (won % MONEY_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] "+ MONEY_UNIT + "원 단위로 입력해주세요.");
        }
    }
}
