package lotto.Controller;

import lotto.Model.*;
import lotto.View.InputView;
import lotto.View.OutputView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoController {
    private static final int LOTTO_PRICE = 1000;

    private static UserLottoAmount userLottoAmount;
    private static List<Integer> lotto = new ArrayList<>();
    private static List<Lotto> lottoList;
    private static WinningResult winningResult;

    public void GameProgress() {
        int lottoPurchased = inputUserAmount();
        OutputView.OutputLottoPurchased(lottoPurchased);

        lottoList = makeLottoList(lottoPurchased);
        winningResult = inputBonusNum();

        lottoResult(lottoList, winningResult, lottoPurchased);
    }

    public int inputUserAmount() {
        userLottoAmount = new UserLottoAmount(InputView.InputBuyCost());
        return userLottoAmount.CalcLottoCount();
    }

    public WinningResult inputBonusNum() {
        Lotto lotto = new Lotto(InputView.InputLottoWinningNums());
        List<Integer> winningNumber = lotto.getNumbers();

        int ball = InputView.InputBonusNum();
        lotto.validateBonusNumber(winningNumber, ball);
        winningResult = new WinningResult(new Lotto(winningNumber), ball);

        return winningResult;
    }

    private static List<Lotto> makeLottoList(int lottoCount) {
        lottoList = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottoList.add(makeLotto());
        }
        return lottoList;
    }

    public static Lotto makeLotto() {
        LottoNums lottoNums = new LottoNums();
        lotto = new ArrayList<>();

        lotto = lottoNums.setRandomNums();
        System.out.println(lotto);

        return new Lotto(lotto);
    }

    private void lottoResult(List<Lotto> lottoList, WinningResult winningLotto, int amount) {
        Map<LottoRanking, Integer> result = setResult();
        LottoRanking rank;

        OutputView.OutputWinResult();
        for (Lotto value : lottoList) {
            rank = winningLotto.match(value);
            result.put(rank, result.get(rank) + 1);
        }
        printResult(result);
        printEarningRate(result, amount);
    }

    private void printResult(Map<LottoRanking, Integer> result) {
        for (int i = LottoRanking.values().length - 1; i >= 0; i--) {
            LottoRanking.values()[i].printMessage(result.get(LottoRanking.values()[i]));
        }
    }

    private void printEarningRate(Map<LottoRanking, Integer> result, int lottoAmount) {
        double EarningRate = 0;
        for (LottoRanking rank : result.keySet()) {
            EarningRate =
                    EarningRate + ((double) (rank.getWinningAmount())
                            / (lottoAmount * LOTTO_PRICE) * (result.get(rank)) * 100);
        }
        OutputView.OutputProfitRate(EarningRate);
    }


    private Map<LottoRanking, Integer> setResult() {
        Map<LottoRanking, Integer> result = new LinkedHashMap<>();

        for (LottoRanking rank : LottoRanking.values()) {
            result.put(rank, 0);
        }
        return result;
    }
}
