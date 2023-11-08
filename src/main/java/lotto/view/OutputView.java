package lotto.view;

import java.util.List;
import lotto.Lotto;
import lotto.Prize;

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
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public void printStatistics(Prize[] prizes, double profit) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (" + prizes[1].getPrice() + ") - " + prizes[1].getCount() + "개");
        System.out.println("4개 일치 (" + prizes[2].getPrice() + ") - " + prizes[2].getCount() + "개");
        System.out.println("5개 일치 (" + prizes[3].getPrice() + ") - " + prizes[3].getCount() + "개");
        System.out.print("5개 일치, 보너스 볼 일치 (");
        System.out.println(prizes[5].getPrice() + ") - " + prizes[5].getCount() + "개");
        System.out.println("6개 일치 (" + prizes[4].getPrice() + ") - " + prizes[4].getCount() + "개");
        System.out.println("총 수익률은 " + profit + "%입니다.");
    }
}