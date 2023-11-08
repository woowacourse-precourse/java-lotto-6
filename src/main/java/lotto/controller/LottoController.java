package lotto.controller;

import lotto.model.Judgement;
import lotto.model.Lotto;
import lotto.model.LottoRankRecorder;
import lotto.model.NumberGenerator;
import lotto.view.Input;
import lotto.view.Output;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoController {

    private Lotto winnerLotto;
    private List<Lotto> purchasedLotto;
    private Input inputController;
    private Output outputController;
    private int bonusNumber;
    private int totalPurchasePrice;

    private int numberOfLotto;
    private double totalProfitPercentage;

    private LottoRankRecorder recorder;

    public LottoController() {
        this.inputController = new Input();
        this.outputController = new Output();
        purchasedLotto = new ArrayList<>();
        recorder = new LottoRankRecorder();
    }

    public void initiatePurchase() {
        outputController.requestPurchase();
        try {
            String inputTotalPurchase = inputController.purchasePrice();
            this.totalPurchasePrice = Integer.parseInt(inputTotalPurchase);
            this.numberOfLotto = this.totalPurchasePrice / 1000;
            outputController.confirmPurchase(this.numberOfLotto);
            for (int purchase = 1; purchase <= this.numberOfLotto; purchase++) {
                Lotto newLotto = new Lotto(NumberGenerator.createRandomNumbers());
                purchasedLotto.add(newLotto);
            }
        } catch (NumberFormatException e) {
            outputController.printErrorMessage();
            initiatePurchase();
        }
    }


    public void allPurchasedLottoNumber() {
        for (Lotto lotto : purchasedLotto) {
            outputController.purchasedLottoNumbers(lotto);
        }
    }

    public void setWinnerNumbers() {
        outputController.requestWinningNumbers();
        this.winnerLotto = new Lotto(inputController.receiveWinningNumbers());
    }

    public void setBonusNumber() {
        outputController.requestBonusNumber();
        this.bonusNumber = inputController.receiveBonusNumber();
    }

    public void calculateResult() {
        for (Lotto lotto : purchasedLotto) {
            Judgement.countMatchingNumbers(winnerLotto, lotto, bonusNumber, recorder);
            lotto.calculateWinningPrize(winnerLotto, bonusNumber, recorder);
        }
    }

    public void showResult() {
        List<Integer> list = new ArrayList<>();
        Map<Judgement.Prize, Integer> rankRecord = recorder.getRankRecord();
        list.add(rankRecord.get(Judgement.Prize.FIRST));
        list.add(rankRecord.get(Judgement.Prize.SECOND));
        list.add(rankRecord.get(Judgement.Prize.THIRD));
        list.add(rankRecord.get(Judgement.Prize.FOURTH));
        list.add(rankRecord.get(Judgement.Prize.FIFTH));
        outputController.resultStatistics(list);
    }

   public void calculateTotalProfitPercentage() {
        totalProfitPercentage = 100 * (double) Lotto.profit / this.totalPurchasePrice;
    }

    public void showTotalProfitPercentage() {
        outputController.profitPercentage(totalProfitPercentage);
    }

    public void showResultStatistics() {

    }
}
