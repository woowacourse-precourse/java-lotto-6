package lotto;

import java.util.List;
import java.util.Map;

public class GamePlayer {
    private int paidMoney;
    private List<Integer> winningNumbers;
    private Integer bonus;

    public List<Lotto> issueLottoes(){
        paidMoney = InputService.iterWhenException(InputService::howMuchMoney);
        LottoMarketService lottoMarketService = new LottoMarketService();
        int lottoCount = lottoMarketService.calculateLottoCount(paidMoney);
        return lottoMarketService.issueLottoes(lottoCount);
    }

    public Map<Rank,Integer> ranking(List<Lotto> lottoes){
        winningNumbers = InputService.iterWhenException(InputService::winningNumbers);
        bonus = InputService.iterWhenException(InputService::bonusNumber,winningNumbers);
        Domain domain = new Domain();
        return domain.allRanking(winningNumbers,bonus,lottoes);
    }

    public double calculateRateOfReturn(Map<Rank,Integer> rankingResult){
        Domain domain = new Domain();
        long profit = domain.calculateProfit(rankingResult);
        return domain.calculatePercent(paidMoney,profit);
    }

    public void run(){
        OutputService outputService = new OutputService();
        List<Lotto> lottos = issueLottoes();
        outputService.printLottoCount(lottos.size());
        outputService.printIssuedLotto(lottos);

        Map<Rank,Integer> rankingResult = ranking(lottos);
        outputService.printAllWinRecord(rankingResult);

        double rateOfReturn = calculateRateOfReturn(rankingResult);
        outputService.printReturnOfRate(rateOfReturn);
    }
}
