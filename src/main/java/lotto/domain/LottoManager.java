package lotto.domain;

import java.util.List;
import lotto.ui.ConsoleInput;
import lotto.ui.ConsoleOutput;
import lotto.ui.Input;
import lotto.ui.Output;
import lotto.util.GetNumber;
import lotto.util.PriceValidator;
import lotto.util.ReturnCalculator;
import lotto.util.Validator;

public class LottoManager {
    private Input input;
    private Output output;
    private LottoGenerator lottoGenerator;
    private WinningNumbersManager winningNumbersManager;

    public LottoManager() {
        this(new ConsoleInput(), new ConsoleOutput(), new LottoGenerator(), new WinningNumbersManager());
    }

    public LottoManager(Input input, Output output, LottoGenerator lottoGenerator,
                        WinningNumbersManager winningNumbersManager) {
        this.input = input;
        this.output = output;
        this.lottoGenerator = lottoGenerator;
        this.winningNumbersManager = winningNumbersManager;
    }

    public List<Lotto> buyLotto() {
        int price = getPrice();
        int numberOfLotto = getNumberOfLotto(price);
        List<Lotto> lottos = lottoGenerator.generateLottos(numberOfLotto);
        output.printPurchasedLotto(lottos);

        return lottos;
    }

    private int getNumberOfLotto(int price) {
        return price / 1000;
    }

    private int getPrice() {
        output.printLottoPriceRequest();
        Integer price = getNumberRepeatedly(
                () -> input.getPrice(),
                (input) -> PriceValidator.validatePrice(input)
        );

        return price;
    }

    private Integer getNumberRepeatedly(GetNumber getNumber, Validator validator) {
        while (true) {
            try {
                Integer inputNumber = getNumber.get();
                validator.validate(inputNumber);
                return inputNumber;
            } catch (IllegalArgumentException e) {
                output.printError(e.getMessage());
            }
        }
    }

    public void inputWinningNumbersAndBonusNumber() {
        getWinningNumbers();
        getBonusNumber();
    }

    private void getWinningNumbers() {
        output.printWinningNumbersRequest();
        getWinningNumbersRepeatedly();
    }

    private void getWinningNumbersRepeatedly() {
        while (true) {
            try {
                List<Integer> inputWinningNumbers = input.getWinningNumbers();
                winningNumbersManager.inputWinningNumbers(inputWinningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                output.printError(e.getMessage());
            }
        }
    }

    private void getBonusNumber() {
        output.printBonusNumberRequest();
        getNumberRepeatedly(
                () -> input.getBonusNumbers(),
                (input) -> winningNumbersManager.inputBonusNumber(input)
        );
    }

    public void getWinningStatus(List<Lotto> lottos) {
        WinningStatus winningStatus = winningNumbersManager.getWinningStatus(lottos);
        double rateOfReturn = ReturnCalculator.calculate(winningStatus, lottos.size());

        output.printWinningStatus(winningStatus);
        output.printRateOfReturn(rateOfReturn);
    }
}
