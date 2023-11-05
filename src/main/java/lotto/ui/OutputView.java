package lotto.ui;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {
    public void printInvalidateMoneyStatement() {
        System.out.println("[ERROR] 1,000원 단위로 입력해주세요.");
    }

    public void printInvalidNumbers() {
        System.out.println("[ERROR] ");
    }

    public void enterYourAmount() {
        System.out.println("구입금액을 입력해주세요.");
    }

    public void showLottosNumber(List<Lotto> lottos) {
        int issueCount = lottos.size();
        System.out.println(issueCount + "개 구매했습니다.");
        for (int i = 0; i < issueCount; i++) {
            System.out.println(lottos.get(i));
        }
        System.out.println();
    }
}
