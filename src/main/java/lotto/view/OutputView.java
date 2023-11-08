package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.constant.ResultMessage;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class OutputView {

    private static final String PROMPT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String PROMPT_PRINT_LOTTOS = "개를 구매했습니다.";
    private static final String PROMPT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String PROMPT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String PROMPT_RESULT_STATICS = "\n당첨 통계\n---";
    private static final String PROMPT_EARNING_RATE = "총 수익률은 %.1f%%입니다.\n";


    public void printEnterPurchaseAmount() {
        System.out.println(PROMPT_PURCHASE_AMOUNT);
    }

    public void printEnterWinningNumber() {
        System.out.println();
        System.out.println(PROMPT_WINNING_NUMBER);
    }

    public void printEnterBonusNumber() {
        System.out.println();
        System.out.println(PROMPT_BONUS_NUMBER);
    }

    public void printLottos(List<Lotto> lottos) {
        System.out.println();
        System.out.println(lottos.size() + PROMPT_PRINT_LOTTOS);
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void printResult(Map<Rank, Integer> result, double earningRate) {
        System.out.println(PROMPT_RESULT_STATICS);
        for (ResultMessage resultMessage : ResultMessage.values()) {
            String rankName = resultMessage.name();
            int countOfRank = result.get(Rank.valueOf(rankName));
            System.out.println(resultMessage.getMessage(countOfRank));
        }
        System.out.printf(PROMPT_EARNING_RATE, earningRate);
    }
}
