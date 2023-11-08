package lotto.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.constants.WinningResult;
import lotto.validator.UserInputValidator;
import lotto.view.OutputView;

public class LottoStore {
    private static List<Lotto> lottoList;
    private static int lottoCount;
    int purchaseAmount;

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    private WinLotto compareResult;


    public List<Lotto> buyLottos(String userInput) {
        purchaseAmount = getPurchaseAmount(userInput);
        lottoCount = calculateAttemptCount(purchaseAmount);
        lottoList = generateLottoList();
        return lottoList;
    }

    public static int getPurchaseAmount(String userInput) throws IllegalArgumentException {
        try {
            int amount = UserInputValidator.validatePurchaseAmount(userInput);
            return amount;
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    private static int calculateAttemptCount(int purchaseAmount) {
        return purchaseAmount / 1000;
    }

    private static List<Lotto> generateLottoList() {
        List<Lotto> lottoList = new ArrayList<Lotto>();
        for (int i = 0; i < lottoCount; i++) {
            lottoList.add(generateLotto());
        }
        return lottoList;
    }

    private static Lotto generateLotto() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        Lotto lotto = new Lotto(lottoGenerator.generateLotto());
        return lotto;
    }

    public void setCompareList(WinLotto compareResult) {
        this.compareResult = compareResult;
    }

    public Map<WinningResult, Integer> getLottoResult() {
        Map<WinningResult, Integer> result = setResult();
        WinningResult winningResult;

        OutputView.printSuccessResult();
        for (int i = 0; i < lottoList.size(); i++) {
            winningResult = compareResult.compareNumbers(lottoList.get(i));
            result.put(winningResult, result.get(winningResult) + 1);
        }

        return result;
    }

    private Map<WinningResult, Integer> setResult() {
        Map<WinningResult, Integer> result = new LinkedHashMap<>();

        for (WinningResult winningResult : WinningResult.values()) {
            result.put(winningResult, 0);
        }
        return result;
    }
}
