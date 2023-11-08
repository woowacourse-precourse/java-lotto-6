package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Amount;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Ranking;
import lotto.domain.WinningNumber;
import lotto.domain.WinningStatistics;
import lotto.service.LottoComparison;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    LottoComparison lottoComparison = new LottoComparison();
    List<Lotto> lottoes = new ArrayList<>();
    WinningNumber winningNumber;
    BonusNumber bonusNumber;
    WinningStatistics winningStatistics = new WinningStatistics();
    int purchaseCount;


    public void startLotto(){
        outputView.printAmountInputMessage();
        Amount amount = inputView.inputAmount();
        purchaseCount = amount.getCountLotto();
        outputView.printBuyLottoMessage(purchaseCount);
        lottoAutomaticCompletion();
    }

    public void lottoAutomaticCompletion() {
        while (lottoes.size() != purchaseCount) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);
            lottoes.add(lotto);
            outputView.printLottoNumber(numbers);
        }
        lottoDraw();
    }

    public void lottoDraw(){
        outputView.printWinningNumberInputMessage();
        winningNumber = inputView.inputWinningNumber();
        outputView.printBonusNumberInputMessage();
        bonusNumber = inputView.inputBonusNumber(winningNumber);

        checkDraw();
    }

    public void checkDraw(){
        for(Lotto lotto : lottoes){
            long matchCount = lottoComparison.compareLottoNumbers(lotto.getNumbers(), winningNumber.getWinningNumbers());
            boolean isBonus = lottoComparison.compareBonusNumber(lotto.getNumbers(), bonusNumber.getBonusNumber());
            Ranking ranking = lottoComparison.determineRanking(matchCount, isBonus);
            winningStatistics.addRanking(ranking);

        }
        outputResult();
    }

    public void outputResult(){
        int first = winningStatistics.getRankingCount(Ranking.FIRST);
        int second = winningStatistics.getRankingCount(Ranking.SECOND);
        int third = winningStatistics.getRankingCount(Ranking.THIRD);
        int fourth =  winningStatistics.getRankingCount(Ranking.FOURTH);
        int fifth = winningStatistics.getRankingCount(Ranking.FIFTH);
        double yield = winningStatistics.calculateYield(purchaseCount*1000);
        outputView.printWinningStatisticsMessage(first,second,third,fourth,fifth,yield);
    }
}
