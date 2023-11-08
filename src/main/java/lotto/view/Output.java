package lotto.view;

import lotto.model.LottoTicket;

import java.util.List;

public class Output {

    public void printLottoTickets(List<List<Integer>> lottoTickets) {
        System.out.println(String.format("%d개를 구매했습니다.", lottoTickets.size()));
        for (List<Integer> lotto : lottoTickets) {
            System.out.println(lotto);
        }
    }

    public void printWinningStatistics(int[] lotteryResults, int matchFiveWithBonus) {
        System.out.println("당첨 통계");
        System.out.println("---");

        System.out.println(String.format("3개 일치 (5,000원) - %d개", lotteryResults[3]));
        System.out.println(String.format("4개 일치 (50,000원) - %d개", lotteryResults[4]));
        System.out.println(String.format("5개 일치 (1,500,000원) - %d개", lotteryResults[5]));
        System.out.println(String.format("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", matchFiveWithBonus));
        System.out.println(String.format("6개 일치 (2,000,000,000원) - %d개", lotteryResults[6]));

    }

}
