package lotto.view;

import lotto.domain.Prize;

import java.util.HashMap;
import java.util.List;

public class OutputMessage {
    private static final int ZERO =0;
    public static void purchaseComplete(int count) {
        System.out.printf("\n%d개를 구매했습니다.\n", count);
    }

    public static void lottoNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public static void winningStatics() {
        System.out.println("\n당첨 통계");
        System.out.println("---");
    }

    public static void printPrizeResults(HashMap<Prize, Integer> map) {
        for(Prize prize : Prize.values()){
            printSingleResult(map,prize);
        }
    }

    private static void printSingleResult(HashMap<Prize, Integer> map, Prize prize) {
        if(prize.getCount()==ZERO){
            return;
        }
        if(prize.equals(Prize.SECOND)){
            System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n",
                    prize.getCount(),prize.getNumericCharacters(), map.getOrDefault(prize,ZERO));
            return;
        }
        System.out.printf("%d개 일치 (%s원) - %d개\n",
                prize.getCount(), prize.getNumericCharacters(), map.getOrDefault(prize,ZERO));
    }

    public static void printEarningRate(double earningRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.", earningRate);
    }
}
