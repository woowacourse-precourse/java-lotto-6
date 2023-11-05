package lotto.domain;

import java.util.List;
import java.util.Map;
import lotto.ui.ConsoleInput;
import lotto.ui.ConsoleOutput;
import lotto.ui.Input;
import lotto.ui.Output;
import lotto.util.PriceValidator;
import lotto.util.ReturnCalculator;

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
        Integer price = getPriceRepeatedly();

        return price;
    }

    private Integer getPriceRepeatedly() {
        while (true) {
            try {
                Integer inputPrice = input.getPrice();
                PriceValidator.validatePrice(inputPrice);
                return inputPrice;
            } catch (IllegalArgumentException e) {
                output.printError(e.getMessage());
            }
        }
    }

    public void inputWinningNumbers() {
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
        getBonusNumberRepeatedly();
    }

    private void getBonusNumberRepeatedly() {
        while (true) {
            try {
                Integer inputBonusNumber = input.getBonusNumbers();
                winningNumbersManager.inputBonusNumber(inputBonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                output.printError(e.getMessage());
            }
        }
    }

    public void getWinningStatus(List<Lotto> lottos) {
        Map<WinningStatus, Integer> winningStatus = winningNumbersManager.getWinningStatus(lottos);
        double rateOfReturn = ReturnCalculator.calculate(winningStatus, lottos.size());

        output.printWinningStatus(winningStatus);
        output.printRateOfReturn(rateOfReturn);
    }
}
