package lotto;

import java.util.List;

public class GameMessage {
    public GameMessage() {

    }

    public void priceInputRequestMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void lottoCountMessage(int lottoCount) {
        System.out.printf("%d개를 구매했습니다.\n", lottoCount);
    }

    public void lottoNumbersPrintMessage(List<List<Integer>> lottoNumbers) {
        for (int i = 0; i < lottoNumbers.size(); i++) {
            System.out.println(lottoNumbers.get(i));
        }
    }

    public void lottoNumbersInputMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void lottoBonusInputMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void statisticsPrintMessage(List<Integer> scores, float revenue) {
        System.out.println("당첨통계\n---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", scores.get(4));
        System.out.printf("4개 일치 (50,000원) - %d개\n", scores.get(3));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", scores.get(2));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", scores.get(1));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", scores.get(0));
        System.out.printf("총 수익률은 %f.2입니다.", revenue);
    }

}
