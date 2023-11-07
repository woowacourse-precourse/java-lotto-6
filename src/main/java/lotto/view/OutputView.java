package lotto.view;

import java.util.List;

public class OutputView {
    public static final String TICKET_COUNT = "개를 구매했습니다.";

    public static void printTicketCount(int count) {
        System.out.println(count + TICKET_COUNT);
    }

    public static void PrintLottoNumbers(List<Integer> lotto) {
        System.out.println(lotto);
    }

    public static void result(int[] lottoPrize, float rate) {
        System.out.println("당첨 동계 ");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", lottoPrize[3]);
        System.out.printf("4개 일치 (50,000원) - %d개\n", lottoPrize[4]);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", lottoPrize[5]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n",
                lottoPrize[7]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", lottoPrize[6]);
        System.out.printf("총 수익률은 %.1f", rate);
        System.out.print("%입니다.");
    }


}
