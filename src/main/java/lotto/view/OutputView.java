package lotto.view;


import static lotto.constants.MessageConstants.ERROR_HEADER;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.domain.Result;

public class OutputView {

    private final static String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private final static String LOTTO_COUNT = "개를 구매했습니다.";
    private final static String INPUT_LOTTO_NUMBER = "당첨 번호를 입력해 주세요.";
    private final static String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    private final static String WINNING_MESSAGE = "당첨 통계\n---";
    private final static String BONUS_MATCH_MESSAGE = ", 보너스 볼 일치";
    private final static String TOTAL_RATE_MESSAGE = "총 수익률은 ";
    private final static String PERCENTAGE_MESSAGE = "%입니다.";

    public void printMoneyInput() {
        System.out.println(INPUT_MONEY);
    }

    public void printPurchase(int number) {
        System.out.println("\n" + number + LOTTO_COUNT);
    }

    public void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto);
        }
    }

    public void printWinningInput() {
        System.out.println("\n" + INPUT_LOTTO_NUMBER);
    }

    public void printBonusInput() {
        System.out.println("\n" + INPUT_BONUS_NUMBER);
    }

    public void printResults(Result result) {
        System.out.println(WINNING_MESSAGE);
        for (Rank rank : Rank.values()) {
            if (rank.getCorrectNumbers() > 0) {
                String isBonus = "";
                if (rank == Rank.SECOND) {
                    isBonus = BONUS_MATCH_MESSAGE;
                }
                System.out.printf("%d개 일치%s (%,d원) - %d개\n",
                        rank.getCorrectNumbers(), isBonus, rank.getWinnings(),
                        result.getResult().getOrDefault(rank, 0));
            }
        }
    }

    public void printRate(Result result, Money inputMoney) {
        System.out.println(TOTAL_RATE_MESSAGE + result.calculateRate(inputMoney) + PERCENTAGE_MESSAGE);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_HEADER + errorMessage);
    }
}

