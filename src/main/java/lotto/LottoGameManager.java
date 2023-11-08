package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.util.CommaSeparatedStringParser;
import lotto.util.RandomSortedLottoNumberGenerator;
import lotto.validation.BonusNumberInputValidator;
import lotto.validation.PriceInputValidator;
import lotto.validation.WinningNumbersInputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameManger {
    private static final int PRICE_PER_TICKET = 1000;
    private String totalPrice;
    private int lottoQauntity;
    private List<Lotto> lottos;
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private List<Integer> winningCounts;
    private double rateOfReturn;

    private final LottoService lottoService;
    public LottoGameManger(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        inputPrice();
        generateLottos();
        inputWinningNumber();
        inputBonusLottoNumber();
        calculatePrizes();
        calculateRateOfReturn();
    }

    private void inputPrice() {
        boolean validInput = false;
        while (!validInput) {
            try {
                totalPrice = InputView.inputPurchasePrice();
                PriceInputValidator.validate(totalPrice);
                lottoQauntity = Integer.parseInt(totalPrice) / PRICE_PER_TICKET;
                validInput = true;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void generateLottos() {
        for (int i = 0; i < lottoQauntity; i++) {
            Lotto lotto = new Lotto(RandomSortedLottoNumberGenerator.generateSortedLotto());
            lottoService.recordLotto(lotto);
        }
        lottos = lottoService.getAllLottoRecord();
        OutputView.printGeneratedLotto(lottos);
    }

    private void inputWinningNumber() {
        boolean validInput = false;
        while (!validInput) {
            try {
                String winningNumbersInput = InputView.inputWinningNumbers();
                WinningNumbersInputValidator.validate(winningNumbersInput);
                winningNumbers = CommaSeparatedStringParser.parse(winningNumbersInput);
                validInput = true;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void inputBonusLottoNumber() {
        boolean validInput = false;
        while (!validInput) {
            try {
                String bonusNumberInput = InputView.inputBonusNumber();
                BonusNumberInputValidator.validate(bonusNumberInput);
                bonusNumber = Integer.parseInt(bonusNumberInput);
                validInput = true;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void calculatePrizes() {
        // 당첨 계산 서비스(). start(randomLottos, 당첨로또)
        //                     RandomLotto Repository에 있는 애들과 당첨로또 비교해서
        //                     당첨 카운트 저장하고
        // List<Integer> winningCounts = 당첨 계산 서비스().getWinningCount()
        OutputView.printWinningStatistics(winningCounts);
    }

    private void calculateRateOfReturn() {
        // double rateOfReturn =수익률 계산 서비스().calculate()
        OutputView.printRateOfReturn(rateOfReturn);
    }
}
