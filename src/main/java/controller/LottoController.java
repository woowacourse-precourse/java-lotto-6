package controller;

import model.Lotto;
import model.LottoRank;
import model.WinningLotto;
import service.LottoMachine;
import view.InputView;
import view.ResultView;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoController {
    private InputView inputView;
    private ResultView resultView;
    private LottoMachine lottoMachine;

    public LottoController(InputView inputview, ResultView resultView, LottoMachine lottoMachine){
        this.inputView = inputview;
        this.resultView = resultView;
        this.lottoMachine = lottoMachine;
    }

    public void play(){
        int purchaseAmount = inputView.inputPurchaseAmount();
        List<Lotto> lottos = lottoMachine.purchaseLottos(purchaseAmount);

        resultView.displayLottos(lottos);

        Lotto winningNumbers = inputView.inputWinningLotto();
        int bonusNumber = inputView.inputBonusNumber();
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        Map<LottoRank, Long> ranks = calculateResult(lottos, winningLotto);
        double profitRate = calculateProfitRate(ranks, purchaseAmount);
        resultView.displayResults(ranks, profitRate);
    }

    public Map<LottoRank, Long> calculateResult(List<Lotto> lottos, WinningLotto winningLotto){
        return lottos.stream()
                .map(lotto -> winningLotto.match(lotto))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public double calculateProfitRate(Map<LottoRank, Long> statistics, int purchaseAmount){
        long totalPrize = statistics.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        return ((double) totalPrize/purchaseAmount * 100);
    }
}
