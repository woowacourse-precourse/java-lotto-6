package lotto.gameplayer;

import lotto.domain.Domain;
import lotto.domain.Rank;
import lotto.ioservice.InputService;
import lotto.ioservice.OutputService;
import lotto.lottomarket.Lotto;
import lotto.lottomarket.LottoMarketService;

import java.util.List;
import java.util.Map;

public class GamePlayer {
    private int paidMoney;
    private List<Integer> winningNumbers;
    private Integer bonus;
    private Domain domain ;
    public GamePlayer(Domain domain){
        this.domain = domain;
    }

    public List<Lotto> issueLottoes(){
        paidMoney = InputService.iterWhenException(InputService::howMuchMoney);
        LottoMarketService lottoMarketService = new LottoMarketService();
        int lottoCount = lottoMarketService.calculateLottoCount(paidMoney);
        return lottoMarketService.issueLottoes(lottoCount);
    }

    public Map<Rank,Integer> ranking(List<Lotto> lottoes){
        winningNumbers = InputService.iterWhenException(InputService::winningNumbers);
        bonus = InputService.iterWhenException(InputService::bonusNumber,winningNumbers);
        return domain.allRanking(winningNumbers,bonus,lottoes);
    }

    public double calculateRateOfReturn(Map<Rank,Integer> rankingResult){
        long profit = domain.calculateProfit(rankingResult);
        return domain.calculatePercent(paidMoney,profit);
    }

    public void run(){
        List<Lotto> lottos = issueLottoes();
        OutputService.printLottoCount(lottos.size());
        OutputService.printIssuedLotto(lottos);

        Map<Rank,Integer> rankingResult = ranking(lottos);
        OutputService.printAllWinRecord(rankingResult);

        double rateOfReturn = calculateRateOfReturn(rankingResult);
        OutputService.printReturnOfRate(rateOfReturn);
    }
}
