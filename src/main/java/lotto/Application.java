package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.controller.LottoGameController;
import lotto.domain.BonusNumber;
import lotto.domain.Lotties;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;
import lotto.service.LottoGameService;
import lotto.util.LottoGameUtil;
import lotto.util.RandomNumberGenerator;
import lotto.view.InputView;

public class Application {
    static InputView inputView = new InputView();
    public static void main(String[] args) {
        String input = inputView.inputPurchaseAmount();
        PurchaseAmount purchaseAmount = convertPurchaseAmount(input);

        Lotties lotties = setLotties(purchaseAmount.getLottoCount());

        String[] inputNumbers = inputView.inputWinningNumbers();
        WinningNumbers winningNumbers = convertWinningNumbers(inputNumbers);

        input = inputView.inputBonusNumber();
        BonusNumber bonusNumber = convertBonusNumber(input);

        LottoGameController controller = new LottoGameController(new LottoGameService());
        controller.run(purchaseAmount, winningNumbers, bonusNumber, lotties);
    }

    private static PurchaseAmount convertPurchaseAmount(String input) {
        int number = LottoGameUtil.StringToInt(input);

        return new PurchaseAmount(number);
    }

    private static BonusNumber convertBonusNumber(String input) {
        int number = LottoGameUtil.StringToInt(input);

        return new BonusNumber(number);
    }

    private static WinningNumbers convertWinningNumbers(String[] inputNumbers) {
        List<Integer> numbers = LottoGameUtil.StringArrayToList(inputNumbers);

        return new WinningNumbers(numbers);
    }

    private static Lotties setLotties(int count) {
        List<Lotto> lottoSaver = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> randomNumbers = RandomNumberGenerator.generateRandomNumbers();
            Collections.sort(randomNumbers);
            lottoSaver.add(new Lotto(randomNumbers));
        }

        return new Lotties(lottoSaver);
    }
}
