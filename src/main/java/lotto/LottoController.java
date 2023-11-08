package lotto;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class LottoController {
    private final LottoView lottoView;
    private final InputJudgement inputJudgement;
    private Purchaser purchaser;

    public LottoController(LottoView lottoView, InputJudgement inputJudgement) {
        this.lottoView = lottoView;
        this.inputJudgement = inputJudgement;
    }

    public Integer inputPurchasePrice(){
        lottoView.showRequestMessageOfPrice();
        Optional<String> inputPurchaseMoney = lottoView.inputPurchaseMoney();
        System.out.println();
        boolean isEffectiveInputFormat = inputJudgement.judgeInputPurchaseMoneyFormat(inputPurchaseMoney);
        if(!isEffectiveInputFormat){
            return inputPurchasePrice();
        }

        return inputJudgement.parseInteger(inputPurchaseMoney);
    }

    public void buyLotto(Integer inputPurchasePrice) {
        purchaser = new Purchaser(inputPurchasePrice);
        List<Lotto> purchasedLotto = purchaser.buy();
        lottoView.showAlertMessageOfNumberOfLotto(purchaser.getNumberOfLotto());
        lottoView.showAlertMessageOfLottoNumber(purchasedLotto);
    }

    public List<Integer> inputWinningNumber() {
        lottoView.showRequestMessageOfWinningNumber();
        Optional<String> inputWinningNumber = lottoView.inputWinningNumber();
        boolean isEffectiveWinningNumberFormat = inputJudgement.judgeInputWinningNumberFormat(inputWinningNumber);
        if(!isEffectiveWinningNumberFormat){
            return inputWinningNumber();
        }

        return inputJudgement.parseIntegers(inputWinningNumber);
    }

    public Integer inputBonusNumber(List<Integer> winningNumbers) {
        lottoView.showRequestMessageOfBonusNumber();
        Optional<String> inputBonusNumber = lottoView.inputBonusNumber();
        boolean isEffectiveBonusNumberFormat = inputJudgement.judgeInputBonusNumberFormat(inputBonusNumber, winningNumbers);
        if(!isEffectiveBonusNumberFormat){
            return inputBonusNumber(winningNumbers);
        }

        return inputJudgement.parseInteger(inputBonusNumber);
    }

    public void requestWinningStatistics(List<Integer> winningNumbers, Integer bonusNumber) {
        lottoView.showWinningStatisticsStartMessage();
        Map<WinningPrice, List<Lotto>> winningPrices = purchaser.checkWinningResult(winningNumbers, bonusNumber);
        lottoView.showWinningStaticsDetailMessage(winningPrices);
        Double earningsRate = purchaser.calculateEarningsRate();
        lottoView.showEarningsRate(earningsRate);
    }
}
