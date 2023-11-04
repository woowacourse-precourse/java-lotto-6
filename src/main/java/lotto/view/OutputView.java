package lotto.view;

import lotto.domain.Enum.Rank;

import java.util.Map;

public class OutputView {
    public void amountMessage() {
        System.out.println("구입 금액을 입력해 주세요.");
    }

    public void countMessage(int count) {
        System.out.println("\n" + count + "개를 구매했습니다.");
    }

    public void lottoNumberMessage(String lottoNumber) {
        System.out.println(lottoNumber);
    }

    public void winningNumberMessage() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public void bonusNumberMessage() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public void matchingMessage(Map<Rank, Integer> ranks, double rateOfReturn) {
        System.out.println("\n당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + ranks.get(Rank.FIFTH) + "개");
        System.out.println("4개 일치 (50,000원) - " + ranks.get(Rank.FORTH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + ranks.get(Rank.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + ranks.get(Rank.SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + ranks.get(Rank.FIRST) + "개");

        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }
}
