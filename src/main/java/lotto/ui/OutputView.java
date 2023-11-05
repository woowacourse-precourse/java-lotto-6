package lotto.ui;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {

    public void enterYourAmount() {
        System.out.println("\n구입금액을 입력해주세요.");
    }

    public void showLottosNumber(List<Lotto> lottos) {
        int issueCount = lottos.size();
        System.out.println(issueCount + "개 구매했습니다.");
        for (int i = 0; i < issueCount; i++) {
            System.out.println(lottos.get(i));
        }
    }

    public void showErrorReason(String message) {
        System.out.println(new StringBuilder("\n").append(message));
    }

    public void enterYourNumber() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public void enterYourBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }
}
