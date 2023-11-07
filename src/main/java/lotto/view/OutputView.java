package lotto.view;

import camp.nextstep.edu.missionutils.Randoms;

public class OutputView {

    private static final String OUTPUT_PURCHASE_MESSAGE = "개를 구매했습니다.";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LUCKY_NUMBER_COUNT = 6;
    private static final int LOTTO_AMOUNT = 1000;


    public static void printAmountLottoNumbers(int amountCount) {
        System.out.println((amountCount / LOTTO_AMOUNT) + OUTPUT_PURCHASE_MESSAGE);

        for (int i = 0; i < amountCount / LOTTO_AMOUNT; i++) {
            System.out.println(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LUCKY_NUMBER_COUNT));
        }
    }
}
