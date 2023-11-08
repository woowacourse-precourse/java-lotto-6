package lotto.controller;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import lotto.model.Lotto;
import lotto.model.LottoMaker;
import lotto.util.Constant;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.util.Message.LottoMessage;

public class GameManager {
    InputView inputView;
    LottoMaker lottoMaker;
    public List<Lotto> lottos;
    HashMap<String, Integer> lottoResult;
    OutputView outputView;
    private int lottoBudgetCount;
    ArrayList<Integer> winningLotto;
    private int bonusNumber;

    public GameManager() {
        inputView = new InputView();
        outputView = new OutputView();
        lottoMaker = new LottoMaker();
        lottos = new ArrayList<>();
        lottoResult = new HashMap<>();
    }


    public void startGame() { // 게임 초기화
        lottoBudgetCount = inputView.inputBudget();
        makeLotto();
        outputView.printBuyLotto(lottos);
        winningLotto = inputView.inputWinningNumber();
        bonusNumber = inputView.inputBonusNumber(winningLotto);
        initializeResult();
        updateWinningStatistics();
        outputView.printWinningStatistics(lottoResult);
        outputView.printProfit(calculateLottoResult());
    }

    private void makeLotto() {
        for (int count = Constant.LOTTO_MIN_NUMBER; count <= lottoBudgetCount; count++) {
            lottos.add(new Lotto(lottoMaker.getLotto()));
        }
    }

    private void initializeResult() {
        for (LottoMessage rankPlace : LottoMessage.values()) {
            lottoResult.put(rankPlace.getRank(), Constant.ZERO);
        }
    }

    public void updateWinningStatistics() {
        for (Lotto lotto : lottos) {
            int count = Constant.LOTTO_MIN_NUMBER;
            String result = lotto.winningStatus(winningLotto, bonusNumber);
            if (lottoResult.containsKey(result)) {
                count = lottoResult.get(result) + Constant.LOTTO_MIN_NUMBER;
            }
            lottoResult.put(result, count);
        }
    }

    public double calculateLottoResult() {
        double winningAmount = Constant.ZERO;
        for (String result : lottoResult.keySet()) {
            winningAmount += getPrizeByRank(result) * lottoResult.get(result);
        }
        return calculateProfit(winningAmount);
    }

    private int getPrizeByRank(String rank) {
        for (LottoMessage value : LottoMessage.values()) {
            if (value.getRank().equals(rank)) {
                return value.getCurrentPrize(rank);
            }
        }
        return Constant.ZERO;
    }

    private double calculateProfit(double winningAmount) {
        double denominator = lottoBudgetCount * Constant.LOTTO_PRICE;
        return (winningAmount / denominator) * Constant.ONE_HUNIT;
    }
}
