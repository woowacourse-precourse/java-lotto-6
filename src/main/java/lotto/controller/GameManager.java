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

public class GameManger {
    InputView inputView = new InputView();
    LottoMaker lottoMaker = new LottoMaker();
    public List<Lotto> lottos = new ArrayList<>();
    HashMap<String, Integer> lottoResult = new HashMap<>();
    OutputView outputView = new OutputView();
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


    public void initializeGame() { // 게임 초기화
        lottoBudgetCount = inputView.inputBudget();
        for (int count = Constant.ZERO; count < lottoBudgetCount; count++) {
            lottos.add(new Lotto(lottoMaker.getLotto()));
        }

        outputView.printBuyLotto(lottos.size(), lottos);
        winningLotto = inputView.inputWinningNumber();
        bonusNumber = inputView.inputBonusNumber(winningLotto);
        initializeResult();
        updateWinningStatus();
        outputView.printWinningStatics(lottoResult);
    }

    private void initializeResult() {
        for (int index = Constant.LOTTO_MIN_NUMBER; index <= 5; index++) {
            lottoResult.put(String.format("%d등",index), Constant.ZERO);
        }
    }

    public void updateWinningStatus() {
        for (Lotto lotto : lottos) {
            int count = Constant.LOTTO_MIN_NUMBER;
            String result = lotto.winningStatus(winningLotto, bonusNumber);
            if (lottoResult.containsKey(result)) {
                count = lottoResult.get(result) + Constant.LOTTO_MIN_NUMBER;
            }
            lottoResult.put(result, count);
        }
    }

    public double calculateLottoResult() { // 메소드 리팩토링
        double winningAmount = 0;
        for (String result : lottoResult.keySet()) {

             winningAmount += getPrizeByRank(result);
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
        double numerator = (winningAmount - lottoBudgetCount * Constant.LOTTO_PRICE);
        double denominator = (lottoBudgetCount * Constant.LOTTO_PRICE);
        return  (numerator / denominator) * Constant.ONE_HUNIT;
    }
}
