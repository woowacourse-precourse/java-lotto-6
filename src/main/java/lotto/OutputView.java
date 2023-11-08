package lotto;

import java.util.List;

public class OutputView {

    void printPurchasedLottoQuantity(int count){
        System.out.println(String.format("%d개를 구매했습니다.",count));
    }

    void printLottoNumbers(List<List<Integer>> lottoNumbers){
        for(List<Integer> numbers: lottoNumbers){
            System.out.println(numbers);
        }
    }

    void printWinningStatistics(List<Integer> counts, float profitRate){
        System.out.println("당첨 통계");
        System.out.println("---");
        printCountOfWonLotto(counts);
        printProfitRate(profitRate);
    }

    void printCountOfWonLotto(List<Integer> counts){
        System.out.println(String.format("3개 일치 (5,000원) - %d개", counts.get(0)));
        System.out.println(String.format("4개 일치 (50,000원) - %d개", counts.get(1)));
        System.out.println(String.format("5개 일치 (1,500,000원) - %d개", counts.get(2)));
        System.out.println(String.format("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", counts.get(3)));
        System.out.println(String.format("6개 일치 (2,000,000,000원) - %d개", counts.get(4)));
    }

    void printProfitRate(float profitRate){
        System.out.println(String.format("총 수익률은 %.1f%%입니다.",profitRate));
    }
}