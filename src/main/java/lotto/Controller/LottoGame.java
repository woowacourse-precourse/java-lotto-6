package lotto.Controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.Domain.BonusNumber;
import lotto.Domain.CompareResult;
import lotto.Domain.LottoPurchaseAmount;
import lotto.Domain.Lotto;
import lotto.Domain.LottoGenerator;
import lotto.Domain.WinningResult;
import lotto.View.InputView;
import lotto.View.OutputView;

public class LottoGame {

    public LottoGame() {
    }

    private static LottoPurchaseAmount lottoPurchaseAmount;
    private static BonusNumber bonusNumber;
    private static Lotto lotto;
    private static List<Lotto> lottoList;
    private static List<Integer> winningLottoNumbers;
    private static int winningBonusNumber;
    private static CompareResult compareResult;

    public void LottoGameRun() {

        int lottoPurchaseCount = inputPurchaseAmount();
        lottoList = makeLottoList(lottoPurchaseCount);

        OutputView.printLottoAmount(lottoPurchaseCount);
        OutputView.printPurchasedLottoList(lottoList);

        compareResult = validateBonusNumber();

        lottoResult(lottoList, compareResult, lottoPurchaseCount);
    }

    public int inputPurchaseAmount() {
        try {
            lottoPurchaseAmount = new LottoPurchaseAmount(InputView.inputLottoPurchaseAmount());
            return lottoPurchaseAmount.calculatePurchaseLottoCount();
        } catch (IllegalArgumentException e) {
            return inputPurchaseAmount();
        }
    }

    private List<Integer> inputLottoNumbers() {
        try {
            lotto = new Lotto(InputView.inputLottoNumbers());
            return lotto.getLottoNumbers();
        } catch (IllegalArgumentException e) {
            return inputLottoNumbers();
        }
    }

    private static int inputBonusNumber() {
        try {
            bonusNumber = new BonusNumber(InputView.inputBonusNumber());
            return bonusNumber.conveyBonusNumber();
        } catch (IllegalArgumentException e) {
            return inputBonusNumber();
        }
    }

    private static List<Lotto> makeLottoList(int purchaseAmount) {
        lottoList = new ArrayList<>();

        for (int i = 0; i < purchaseAmount; i++) {
            lottoList.add(makeLotto());
        }
        return lottoList;
    }

    private static Lotto makeLotto() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Integer> lottoNumbers = lottoGenerator.generateLottoNumbers();

        return new Lotto(lottoNumbers);
    }


    public CompareResult validateBonusNumber() {
        Lotto lotto = new Lotto(InputView.inputLottoNumbers());
        List<Integer> compareNumber = lotto.getLottoNumbers();
        compareResult = new CompareResult(new Lotto(compareNumber), inputBonusNumber());

        return compareResult;
    }

    private void lottoResult(List<Lotto> lottoList, CompareResult winningLotto, int amount) {
        Map<WinningResult, Integer> result = setResult();
        WinningResult winningResult;

        OutputView.printSuccessResult();
        for (int i = 0; i < lottoList.size(); i++) {
            winningResult = winningLotto.compareNumbers(lottoList.get(i));
            result.put(winningResult, result.get(winningResult) + 1);
        }
        printResult(result);
        printEarningRate(result, amount);
    }

    private void printResult(Map<WinningResult, Integer> result) {
        for (int i = WinningResult.values().length - 1; i >= 0; i--) {
            WinningResult.values()[i].printMessage(result.get(WinningResult.values()[i]));
        }
    }

    private void printEarningRate(Map<WinningResult, Integer> result, int lottoAmount) {
        double profitRate = 0;
        for (WinningResult winningResult : result.keySet()) {
            profitRate =
                    profitRate + ((double) (winningResult.getTotalPrizeAmount()) / (lottoAmount * 1000) * (result.get(
                            winningResult)) * (100));

        }
        OutputView.printProfitRate(profitRate);
    }

    private Map<WinningResult, Integer> setResult() {
        Map<WinningResult, Integer> result = new LinkedHashMap<>();

        for (WinningResult winningResult : WinningResult.values()) {
            result.put(winningResult, 0);
        }
        return result;
    }

}

