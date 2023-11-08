package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {

    private static final String PROMPT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String PROMPT_PRINT_LOTTOS = "개를 구매했습니다.";
    private static final String PROMPT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String PROMPT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";


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
}
