package lotto.view;

import java.util.List;
import lotto.dto.LottoDto;
import lotto.dto.StatisticDto;
import lotto.exception.WinningNumberContainsBonusNumberException;
import lotto.model.Lotto;
import lotto.util.Converter;
import lotto.validation.InputValidator;
import lotto.vo.BonusNumber;
import lotto.vo.BuyAmount;

public class View {

    private final InputView inputView;
    private final OutputView outputView;

    public View(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public BuyAmount getBuyAmount() {
        outputView.printRequestInputBuyAmountMessage();
        while (true) {
            try {
                String amount = inputView.inputBuyAmount();
                InputValidator.validateBuyAmount(amount);
                Integer buyAmount = Integer.valueOf(amount);
                return new BuyAmount(buyAmount);
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
    }

    public Lotto getWinningLotto() {
        outputView.printRequestInputWinningNumberMessage();
        while (true) {
            try {
                String numbers = inputView.inputWinningNumbers();
                InputValidator.validateWinningNumbers(numbers);
                List<Integer> winningNumbers = Converter.convertToLottoNumbers(numbers);
                return Lotto.createWinningLotto(winningNumbers);
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
    }

    public BonusNumber getBonusNumber(final List<Integer> winningNumbers) {
        outputView.printRequestInputBonusNumberMessage();
        while (true) {
            try {
                String bonusNumber = inputView.inputBonusNumbers();
                InputValidator.validateBonusNumber(bonusNumber);
                Integer number = Integer.valueOf(bonusNumber);
                validateBonusNumberContainsWinningNumber(winningNumbers, number);
                return new BonusNumber(number);
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
    }

    public void showTicketCount(final Integer count) {
        outputView.printTicketCountMessage(count);
    }

    public void showLotteriesNumber(final List<LottoDto> lotteries) {
        outputView.printLotteriesNumber(lotteries);
    }

    public void showStatistics(final StatisticDto statisticDto) {
        outputView.printStatistics(statisticDto);
    }

    public void showProfitRate(final Double profitRate) {
        outputView.printProfitRate(profitRate);
    }

    private void validateBonusNumberContainsWinningNumber(final List<Integer> winningNumbers,
                                                          final Integer bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new WinningNumberContainsBonusNumberException();
        }
    }
}
