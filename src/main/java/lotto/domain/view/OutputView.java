package lotto.domain.view;

import lotto.domain.model.Lotto;
import lotto.domain.model.Receipt;

import java.util.List;

public class OutputView {
    public void printPriceLine() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printLottoLine(List<Lotto> lottos) {
        System.out.println("\n" + lottos.size() + "개를 구매했습니다.");
        lottos.forEach(System.out::println);
    }

    public void printNumbersLine() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public void printBonusNumberLine() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public void printResultLine(Receipt receipt) {
        List<Integer> counts = receipt.getCounts();
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + counts.get(0) + "개");
        System.out.println("4개 일치 (50,000원) - " + counts.get(1) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + counts.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + counts.get(3) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + counts.get(4) + "개");
        System.out.println("총 수익률은 " + receipt.getRate() + "%입니다.");
    }
}
