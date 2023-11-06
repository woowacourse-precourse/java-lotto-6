package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static lotto.Constant.*;
import static lotto.Message.*;

public class LottoGame {
    private Integer purchaseAmount;
    private Integer lottoCount;
    private final ArrayList<Lotto> lotteries = new ArrayList<>();
    private final List<Integer> winningNums = new ArrayList<>();
    private Integer bonusNum;
    private Double profitPercentage;
    private Long profit = 0L;
    private final ArrayList<Integer> prizes = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0));


    public void play() {
        getPurchaseInput();
        showPurchasedLottoCount();

        issueLotteries();
        printLotteries();

    }

    private void getPurchaseInput() {
        System.out.println(PURCHASE_INPUT_PROMPT);
        String input = Console.readLine();
        try {
            validateMoney(input);
            purchaseAmount = Integer.parseInt(input);
            System.out.println();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getPurchaseInput();
        }
    }

    private void showPurchasedLottoCount() {
        lottoCount = purchaseAmount / PRICE;
        System.out.println(lottoCount + PURCHASE_CONFIRMATION_MESSAGE);
    }

    private void issueLotteries() {
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = new ArrayList<>(
                    Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_COUNT)
            );
            try {
                Collections.sort(numbers);
                Lotto lotto = new Lotto(numbers);
                lotteries.add(lotto);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                issueLotteries();
            }
        }
    }

    private void printLotteries() {
        for (Lotto lotto : lotteries) {
            lotto.printNumbers();
        }
        System.out.println();
    }

    private void validateMoney(String input) {
        if (!input.matches(regExp)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "구입 금액은 양의 정수로 입력 가능합니다.");
        }
        Integer inputPrice = Integer.parseInt(input);
        if (input.length() > 9 || inputPrice > MAX_MONEY) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "구입 금액은 " + MAX_MONEY + "원을 초과할 수 없습니다.");
        }
        if (inputPrice % PRICE != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "구입 금액은 " + PRICE + "원 단위여야 합니다.");
        }
    }
}
