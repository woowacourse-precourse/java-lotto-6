package lotto;

import lotto.lottoMaker.Lotto;

import java.util.List;

public class Output {
    private List<Lotto> lottoTicket;
    private List<Integer> winningNumber;
    private long numOfTicket;
    private long threeMatch;
    private long fourMatch;
    private long fiveMatch;
    private long fiveMatchBonus;
    private long sixMatch;

    public Output(List<Lotto> lottoTicket, List<Integer> winningNumber) {
        this.lottoTicket = lottoTicket;
        this.winningNumber = winningNumber;
        this.numOfTicket = lottoTicket.size();
    }

    public void printOutput(int bonusNumber) {


        for (int i = 0; i < numOfTicket; i++) {
            int count = 0;
            List<Integer> numbers = lottoTicket.get(i).getNumbers();

            for (int j = 0; j < winningNumber.size(); j++) {
                if (numbers.contains(winningNumber.get(j))) {
                    count++;
                }
            }
            if (count < 3) ;
            else if (count == 3) threeMatch++;
            else if (count == 4) fourMatch++;
            else if (count == 5) {
                if (lottoTicket.get(i).getNumbers().contains(bonusNumber)) fiveMatchBonus++;
                else fiveMatch++;
            } else if (count == 6) sixMatch++;
            //System.out.println("current count is " + count + " is bonus checked " + lottoTicket.get(i).getNumbers().contains(bonusNumber));
        }

        System.out.println("당첨통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + threeMatch + "개");
        System.out.println("4개 일치 (50,000원) - " + fourMatch + "개");
        System.out.println("5개 일치 (1,500,000원) - " + fiveMatch + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + fiveMatchBonus + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + sixMatch + "개");
        int investment = lottoTicket.size() * 1000;
        long profit = (threeMatch * 5000 + fourMatch * 50000 + fiveMatch * 1500000 + fiveMatchBonus * 30000000 + sixMatch * 2000000000);
        double profitRate = profit / (double)investment * 100;
        double roundedProfitRate = Math.round(profitRate*100.0)/100.0;
        //System.out.println("총 수익금은 " + profit + "입니다.");
        //System.out.println("총 수익률은 " + profitRate + "%입니다.");
        System.out.println("총 수익률은 " + roundedProfitRate + "%입니다.");
    }
}
