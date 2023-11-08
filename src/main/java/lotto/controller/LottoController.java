package lotto.controller;

import static lotto.Constants.LOTTO_PRICE;
import static lotto.util.parser.Parser.parseStringToInt;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Map;
import lotto.exception.ExceptionPrinter;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Prize;
import lotto.model.WinningLotto;
import lotto.util.LottoUtil;
import lotto.util.Validator;
import lotto.util.parser.Parser;
import lotto.view.input.LottoInputView;
import lotto.view.input.PurchaseInputView;
import lotto.view.output.LottoOutputView;
import lotto.view.output.PrizeOutputView;
import lotto.view.output.PurchaseOutputView;

public class LottoController {
    private final LottoInputView lottoInputView = new LottoInputView();
    private final LottoOutputView lottoOutputView = new LottoOutputView();
    private final PurchaseInputView purchaseInputView = new PurchaseInputView();
    private final PurchaseOutputView purchaseOutputView = new PurchaseOutputView();
    private final PrizeOutputView prizeOutputView = new PrizeOutputView();
    private Lottos purchasedLottos;

    public void run() {
        int purchaseAmount = inputPurchaseAmount();
        int lottoCount = purchaseAmount / LOTTO_PRICE;

        printLottoCount(lottoCount);
        generateLottos(lottoCount);
        printPurchasedLottos();

        WinningLotto winningLotto = inputWinningLotto();
        displayWinningStatistics(winningLotto, purchaseAmount);
    }

    /**
     * Description: 구입 금액을 입력받아 반환한다.
     */
    private int inputPurchaseAmount() {
        purchaseInputView.printInputMoney();
        try {
            int amount = parseStringToInt(Console.readLine());
            Validator.validatePurchaseAmount(amount);
            return amount;
        } catch (IllegalArgumentException e) {
            ExceptionPrinter.printExceptionMessage(e);
            return inputPurchaseAmount();
        }
    }

    /**
     * Description: 구입한 로또의 개수를 출력한다.
     */
    private void printLottoCount(int lottoCount) {
        purchaseOutputView.printLottoCount(lottoCount);
    }

    /**
     * Description: 구입한 로또들을 생성한다.
     */
    private void generateLottos(int lottoCount) {
        try {
            purchasedLottos = new Lottos(LottoUtil.generateLottos(lottoCount));
        } catch (Exception e) {
            ExceptionPrinter.printExceptionMessage(e);
            generateLottos(lottoCount);
        }
    }

    /**
     * Description: 구입한 로또들을 출력한다.
     */
    private void printPurchasedLottos() {
        try {
            purchasedLottos.lottos()
                    .forEach(lotto -> lottoOutputView.printLotto(lotto.getSortedLottoNumbers().toString()));
        } catch (Exception e) {
            ExceptionPrinter.printExceptionMessage(e);
            printPurchasedLottos();
        }
    }

    /**
     * Description: 당첨 번호와 보너스 번호를 입력받아 WinningLotto를 반환한다.
     */
    private WinningLotto inputWinningLotto() {
        List<Integer> winningNumbers = inputWinningNumbers();
        int bonusNumber = inputBonusNumber();
        return new WinningLotto(new Lotto(winningNumbers), bonusNumber);
    }

    /**
     * Description: 당첨 번호를 입력받아 반환한다.
     */
    private List<Integer> inputWinningNumbers() {
        lottoInputView.printInputWinningLotto();
        try {
            String winningNumber = Console.readLine();
            List<Integer> numbers = Parser.parseCommaStringToIntList(winningNumber);
            Validator.validateLottoNumbers(numbers);
            return numbers;
        } catch (Exception e) {
            ExceptionPrinter.printExceptionMessage(e);
            return inputWinningNumbers();
        }
    }

    /**
     * Description: 보너스 번호를 입력받아 반환한다.
     */
    private int inputBonusNumber() {
        lottoInputView.printInputBonusNumber();
        try {
            return parseStringToInt(Console.readLine());
        } catch (Exception e) {
            ExceptionPrinter.printExceptionMessage(e);
            return inputBonusNumber();
        }
    }

    /**
     * Description: 당첨 통계와 수익률을 출력한다.
     */
    private void displayWinningStatistics(WinningLotto winningLotto, int purchaseAmount) {
        try {
            Map<Prize, Integer> statistics = LottoUtil.calculatePrizeCounts(purchasedLottos.lottos(), winningLotto);
            double totalPrizeAmount = LottoUtil.calculateTotalPrizeAmount(statistics);

            lottoOutputView.printStatisticsHeader();
            displayPrizeCounts(statistics);
            double yield = LottoUtil.calculateProfitPercentage(totalPrizeAmount, purchaseAmount);
            lottoOutputView.printTotalYield(yield);
        } catch (Exception e) {
            ExceptionPrinter.printExceptionMessage(e);
            displayWinningStatistics(winningLotto, purchaseAmount);
        }
    }

    /**
     * Description: 당첨 통계를 출력한다.
     */
    private void displayPrizeCounts(Map<Prize, Integer> prizeCounts) {
        try {
            prizeCounts.keySet().forEach(prize -> prizeOutputView.printPrize(prize, prizeCounts.get(prize)));
        } catch (Exception e) {
            ExceptionPrinter.printExceptionMessage(e);
            displayPrizeCounts(prizeCounts);
        }
    }
}

