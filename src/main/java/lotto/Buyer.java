package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Buyer {
    private int amount;
    private int lottoTicketCount;
    private int winningAmount;
    private List<Lotto> lottoTickets = new ArrayList<>();
    private Map<WinningCondition,Integer> winningStatistic = new HashMap<>();

    public Buyer(String amountInput) {
        this.amount = Integer.parseInt(amountInput);
        this.lottoTicketCount = amount / 1000;
        purchaseLottoTicket(amount);
        for (WinningCondition winningCondition : WinningCondition.values()){
            winningStatistic.put(winningCondition,0);
        }
    }

    public int getAmount() {
        return amount;
    }


    // 구매한 금액만큼 로또 발행
    public void purchaseLottoTicket(int amount) {

        for (int i = 0; i < lottoTicketCount; i++) {
            Lotto lotto = new Lotto(LottoGenerator.generateLottoNumber());
            lottoTickets.add(lotto);
        }
    }

    public void printBuyerLottoTickets() {
        System.out.println(lottoTicketCount + "개를 구매했습니다.");
        for (Lotto lotto : lottoTickets) {
            List<Integer> lottoNumber = lotto.getNumbers();
            Collections.sort(lottoNumber);
            System.out.println(lottoNumber);
        }

    }

    public void getLottoResult(List<Integer> winningNumber, int bonusNumber){
        for (Lotto lotto : lottoTickets){
            WinningCondition winningCondition = getWinningResult(lotto,winningNumber,bonusNumber);
            setWinningStatistic(winningCondition);
            setWinningAmount(winningCondition.getWinningAmount());
        }
    }



    private WinningCondition getWinningResult(Lotto lotto, List<Integer> winningNumber, int bonusNumber){
        int matchCount = getMatchCount(winningNumber, lotto.getNumbers());
        int bonusNumberCount = getBonusNumberCount(bonusNumber, lotto.getNumbers());
        return WinningCondition.valueOfLottoNumbers(matchCount,bonusNumberCount);
    }

    public static int getMatchCount(List<Integer> winningNumber, List<Integer> buyerNumber) {

        int matchCount = (int) winningNumber.stream().filter(buyerNumber::contains).count();
        return matchCount;


    }



    public static int getBonusNumberCount(int bonusNumber, List<Integer> buyerNumber){
        if (buyerNumber.contains(bonusNumber)){
            return 1;
        }
        return 0;
    }



    public float getProfitRate(){
        System.out.println(winningAmount);
        System.out.println(amount);
        System.out.println((winningAmount/ (float) amount) * 100);
        return (winningAmount/ (float) amount) ;
    }

    public Map<WinningCondition,Integer> getWinningStatistic(){
        return winningStatistic;
    }

    public void setWinningAmount(int winningAmount){
        this.winningAmount += winningAmount;
    }

    public void setWinningStatistic(WinningCondition winningCondition){
        int value = winningStatistic.get(winningCondition);
        winningStatistic.put(winningCondition, value+1);
    }

}
