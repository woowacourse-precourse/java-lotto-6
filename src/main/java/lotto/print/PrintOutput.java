package lotto.print;

import lotto.Lotto;

import java.util.List;

public class PrintOutput {
    public void printMoneyQuestion() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printPurchasedLottoNumber(int money) {
        System.out.println((int)(money/1000) + "개를 구매했습니다.");
    }

    public void printRandomLottosNumbers(List<Lotto> lottos) {
        for (int i = 0; i < lottos.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int j = 0; j < 5; j++) {
                sb.append(lottos.get(i).getNumbers().get(j)).append(", ");
            }
            sb.append(lottos.get(i).getNumbers().get(5)).append("]");
            System.out.println(sb);
        }
    }
    public void printLottoNumberQuestion(){
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printBonusNumberQuestion(){
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printStats(int[] stats, double percent){
        System.out.println("당첨 통계\n" + "---");
        System.out.printf("3개 일치 (5,000원) - %d개\n",stats[0]);
        System.out.printf("4개 일치 (50,000원) - %d개\n", stats[1]);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", stats[2]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", stats[3]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", stats[4]);
        System.out.printf("총 수익률은 %.1f%입니다.\n", percent);
    }
}
