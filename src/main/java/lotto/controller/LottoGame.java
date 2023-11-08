package lotto.controller;


import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.LottoGameResult;
import lotto.domain.LottoPurchase;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.enums.ConstantsMessage;
import lotto.enums.LottoPrize;
import lotto.services.EarningRateCalculator;
import lotto.services.LottoNumberComparator;
import lotto.services.LottoNumberGenerator;
import lotto.utils.LottoValidator;
import lotto.utils.Parser;
import lotto.utils.RandomNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoFactory lottoFactory;
    private final LottoValidator validator;
    private Lottos lottos;

    public LottoGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoFactory = new LottoFactory(new LottoNumberGenerator(new RandomNumberGenerator()));
        this.validator = new LottoValidator();
    }

    public void play() {
        LottoPurchase lottoPurchase = calculateLottoCount();
        int purchaseCount = lottoPurchase.calculateLottoCount();
        outputView.print(String.format(ConstantsMessage.CONFIRM_PURCHASE_COUNT.message, purchaseCount));

        this.lottos = new Lottos(purchaseLottos(purchaseCount));
        outputView.printLottoNumbers(lottos.getPurchaseLottos());

        WinningLotto winningLotto = generateWinningNumbers();
        EnumMap<LottoPrize, Integer> prizes = calculatePrizes(winningLotto);

        printLottoGameResult(prizes, lottoPurchase.getMoney());
    }

    private LottoPurchase calculateLottoCount() {
        try {
            outputView.printMessage(ConstantsMessage.INPUT_PURCHASE_AMOUNT);
            String moneyInput = inputView.inputPurchaseAmount();
            return new LottoPurchase(moneyInput);
        } catch (IllegalArgumentException e) {
            outputView.print(e.getMessage());
            return calculateLottoCount();
        }
    }

    public List<Lotto> purchaseLottos(int purchaseCount) {
        try {
            return lottoFactory.purchaseLottos(purchaseCount);
        } catch (IllegalArgumentException e) {
            outputView.print(e.getMessage());
            return purchaseLottos(purchaseCount);
        }
    }

    private Lotto getWinningNumbers() {
        try {
            outputView.printMessage(ConstantsMessage.INPUT_WINNING_NUMBERS);
            String winningNumbersInput = inputView.inputWinningNumbers();
            Parser parser = new Parser(validator);

            List<Integer> winningNumbers = parser.parseNumbers(winningNumbersInput);
            return new Lotto(winningNumbers);
        } catch (IllegalArgumentException e) {
            outputView.print(e.getMessage());
            return getWinningNumbers();
        }
    }

    private int getBonusNumber(Lotto winningLotto) {
        try {
            outputView.printMessage(ConstantsMessage.INPUT_BONUS_NUMBER);
            int bonusNumber = validator.validateNonNumeric(inputView.inputBonusNumber());
            validator.validateNumberRange(bonusNumber);
            validator.validateDuplicateBounus(winningLotto, bonusNumber);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            outputView.print(e.getMessage());
            return getBonusNumber(winningLotto);
        }
    }

    private WinningLotto generateWinningNumbers() {
        try {
            Lotto winningLotto = getWinningNumbers();
            int bonus = getBonusNumber(winningLotto);
            return new WinningLotto(winningLotto, bonus);
        } catch (IllegalArgumentException e) {
            outputView.print(e.getMessage());
            return generateWinningNumbers();
        }
    }

    public EnumMap<LottoPrize, Integer> calculatePrizes(WinningLotto winningLotto) {
        LottoNumberComparator comparator = new LottoNumberComparator(lottos.getPurchaseLottos(), winningLotto);
        comparator.calculatePrizes();
        return comparator.getPrizeCount();
    }

    private void printLottoGameResult(EnumMap<LottoPrize, Integer> prizes, int purchaseCount) {
        BigDecimal earningRate = EarningRateCalculator.calculate(prizes, purchaseCount);
        String result = LottoGameResult.generatePrizeResults(prizes);
        outputView.printPrizeResult(result);
        outputView.print(
                String.format(ConstantsMessage.PROFIT_RATE_MESSAGE.message,
                        Parser.formatProfitCurrency(earningRate)));
    }
}
