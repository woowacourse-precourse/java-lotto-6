package lotto.domain;

import java.util.List;
import java.util.Map;
import lotto.ui.ConsoleInput;
import lotto.ui.ConsoleOutput;
import lotto.ui.Input;
import lotto.ui.Output;

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
                PriceManager.validatePrice(inputPrice);
                return inputPrice;
            } catch (IllegalArgumentException e) {
                output.printError(e.getMessage());
            }
        }
    }

    public void inputWinningNumbers() {
        List<Integer> winningNumbers = getWinningNumbers();
        winningNumbersManager.inputWinningNumbers(winningNumbers);

        Integer bonusNumber = getBonusNumber();
        winningNumbersManager.inputBonusNumber(bonusNumber);
    }

    private List<Integer> getWinningNumbers() {
        output.printWinningNumbersRequest();
        List<Integer> winningNumbers = getWinningNumbersRepeatedly();

        return winningNumbers;
    }

    private List<Integer> getWinningNumbersRepeatedly() {
        while (true) {
            try {
                List<Integer> inputWinningNumbers = input.getWinningNumbers();
                winningNumbersManager.validateWinningNumbers(inputWinningNumbers);
                return inputWinningNumbers;
            } catch (IllegalArgumentException e) {
                output.printError(e.getMessage());
            }
        }
    }

    private Integer getBonusNumber() {
        output.printBonusNumberRequest();
        Integer bonusNumber = getBonusNumberRepeatedly();

        return bonusNumber;
    }

    private Integer getBonusNumberRepeatedly() {
        while (true) {
            try {
                Integer inputBonusNumber = input.getBonusNumbers();
                winningNumbersManager.validateBonusNumber(inputBonusNumber);
                return inputBonusNumber;
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
