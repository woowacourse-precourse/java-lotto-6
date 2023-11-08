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

    /**
     * 로또 구매 금액 입력
     * @return 사용자가 입력한 로또 구매 금액
     */
    public Integer inputPurchasePrice(){
        lottoView.showRequestMessageOfPrice();
        Optional<String> inputPurchaseMoney = lottoView.inputPurchaseMoney();
        System.out.println();
        boolean isEffectiveInputFormat = inputJudgement.judgeInputPurchaseMoneyFormat(inputPurchaseMoney);
        if(!isEffectiveInputFormat){
            return inputPurchasePrice();
        }

        return inputJudgement.parseIntegerInputPurchaseMoneyOrBonusNumber(inputPurchaseMoney);
    }

    /**
     * 로또 구매
     * @param inputPurchasePrice 로또 구매 금액
     */
    public void buyLotto(Integer inputPurchasePrice) {
        purchaser = new Purchaser(inputPurchasePrice);
        List<Lotto> purchasedLotto = purchaser.buy();
        lottoView.showAlertMessageOfNumberOfLotto(purchaser.getNumberOfLotto());
        lottoView.showAlertMessageOfLottoNumber(purchasedLotto);
    }

    /**
     * 로또 당첨 번호 입력
     * @return 로또 당첨 번호
     */
    public List<Integer> inputWinningNumber() {
        lottoView.showRequestMessageOfWinningNumber();
        Optional<String> inputWinningNumber = lottoView.inputWinningNumber();
        boolean isEffectiveWinningNumberFormat = inputJudgement.judgeInputWinningNumberFormat(inputWinningNumber);
        if(!isEffectiveWinningNumberFormat){
            return inputWinningNumber();
        }

        return inputJudgement.parseIntegerInputWinningNumbers(inputWinningNumber);
    }

    /**
     * 보너스 번호 입력
     * @param winningNumbers 로또 당첨 번호
     * @return 보너스 번호
     */
    public Integer inputBonusNumber(List<Integer> winningNumbers) {
        lottoView.showRequestMessageOfBonusNumber();
        Optional<String> inputBonusNumber = lottoView.inputBonusNumber();
        boolean isEffectiveBonusNumberFormat = inputJudgement.judgeInputBonusNumberFormat(inputBonusNumber, winningNumbers);
        if(!isEffectiveBonusNumberFormat){
            return inputBonusNumber(winningNumbers);
        }

        return inputJudgement.parseIntegerInputPurchaseMoneyOrBonusNumber(inputBonusNumber);
    }

    /**
     * 당첨 통계 출력
     * @param winningNumbers 로또 당첨 번호
     * @param bonusNumber 보너스 번호
     */
    public void requestWinningStatistics(List<Integer> winningNumbers, Integer bonusNumber) {
        lottoView.showWinningStatisticsStartMessage();
        Map<WinningPrice, List<Lotto>> winningPrices = purchaser.checkWinningResult(winningNumbers, bonusNumber);
        lottoView.showWinningStaticsDetailMessage(winningPrices);
        Double earningsRate = purchaser.calculateEarningsRate();
        lottoView.showEarningsRate(earningsRate);
    }
}
