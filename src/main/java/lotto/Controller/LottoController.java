package lotto.Controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.LottoNumbers;
import lotto.model.LottoPurchase;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private static int lottoCount;
    private static List<List<Integer>> lottoNumbers;

    public static void start() {

    }

    private static void purchaseLotto() {
        OutputView.printPurchasePrice();
        LottoPurchase lottoPurchase = new LottoPurchase(InputView.readLine());
        lottoCount = lottoPurchase.getLottoCount();
        OutputView.printPurchaseMessage(lottoCount);
    }

    private static void printAllLottoNumbers() {
        LottoNumbers allLottoNumbers = new LottoNumbers(lottoCount);
        lottoNumbers = new ArrayList<>(allLottoNumbers.getLottoNumbers());
        OutputView.printLottoNumbers(lottoNumbers);
    }
}
