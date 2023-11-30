package lotto.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.constants.WinningResult;
import lotto.view.OutputView;

public class LottoStore {
    private static List<Lotto> lottoList = new ArrayList<Lotto>();
    private static int lottoCount;
    int purchaseAmount;

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    private WinLotto compareResult;


    public List<Lotto> buyLottos(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        lottoCount = calculateAttemptCount(purchaseAmount);
        lottoList = generateLottoList();
        return lottoList;
    }

    private static int calculateAttemptCount(int purchaseAmount) {
        return purchaseAmount / 1000;
    }

    private static List<Lotto> generateLottoList() {
        List<Lotto> tempLottoList = new ArrayList<Lotto>();
        for (int i = 0; i < lottoCount; i++) {
            tempLottoList.add(makeLotto());
        }
        return tempLottoList;
    }

    private static Lotto makeLotto() {
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
