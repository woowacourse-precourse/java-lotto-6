package lotto.view;

import java.util.List;
import lotto.Lotto;

public class OutputView {
    public void displayPriceQuestion() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void displayWinNumberQuestion() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void displayBonusNumberQuestion() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printLotto(List<Lotto> lottos) {
        System.out.println(lottos.size()+"개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }
}