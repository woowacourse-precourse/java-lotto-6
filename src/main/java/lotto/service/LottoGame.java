package lotto.service;

import lotto.domain.*;
import lotto.util.WinnerRank;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private RandomNumber randomNumber = new RandomNumber();
    private WinResult winResult = new WinResult();
    public void game() {
        outputView.printMoneyInputGuideMessage();
        PurchasePrice purchasePrice = inputView.inputPrice();

        int lottoAmount = purchasePrice.getLottoAmount();
        outputView.printLottoAmount(lottoAmount);

        List<Lotto> lottos = new ArrayList<>();
        while (lottoAmount > 0) {
            List<Integer> randomNumbers = randomNumber.generateRandomNumbers();
            outputView.printUserLottos(randomNumbers);
            lottos.add(new Lotto(randomNumbers));
            lottoAmount--;
        }

        outputView.printWinLottoNumbersInputGuide();
        Lotto winLotto = inputView.inputWinLotto();
        WinningLotto winningLotto = new WinningLotto(winLotto);

        outputView.printBonusNumbersInputGuide();
        winningLotto.setBonusLottoNum(inputView.inputBonusNumber());

        for(Lotto userLotto : lottos) {
            int rankValue = winningLotto.matchSameNumberNum(userLotto);
            if(winResult.isOverTwo(rankValue)) {
                if(winResult.isFiveSame(rankValue)) {
                    if(winningLotto.isBonusNumContain(userLotto)) {
                        rankValue = 7;
                    }
                }
                winResult.increaseWinResultValue(rankValue);
            }
        }

        for(WinnerRank winnerRank : WinnerRank.values()){
            int key = winnerRank.getValue();
            outputView.printWinResult(winResult);
        }

        double profit = new Profit().calculateProfitRate(purchasePrice, winResult);
        outputView.printProfit(profit);
    }
}
