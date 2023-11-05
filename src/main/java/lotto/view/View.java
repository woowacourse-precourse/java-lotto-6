package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.dto.LottoDto;
import lotto.exception.WinningNumberContainsBonusNumberException;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.util.Converter;
import lotto.vo.BonusNumber;
import lotto.vo.BuyAmount;
import lotto.vo.TicketCount;

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
                Integer amount = inputView.inputBuyAmount();
                return new BuyAmount(amount);
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
    }

    public Lotto getWinningLotto() {
        outputView.printRequestInputWinningNumberMessage();
        while (true) {
            try {
                String winningNumbers = inputView.inputWinningNumbers();
                List<Integer> numbers = Converter.convertToLottoNumbers(winningNumbers);
                return new Lotto(numbers);
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
    }

    public BonusNumber getBonusNumber(final List<Integer> numbers) {
        outputView.printRequestInputBonusNumberMessage();
        while (true) {
            try {
                Integer number = inputView.inputBonusNumbers();
                validateBonusNumberContainsWinningNumber(numbers, number);
                return new BonusNumber(number);
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
    }

    public void printTicketCountMessage(final Integer count) {
        outputView.printTicketCountMessage(count);
    }

    public void showLotteriesNumber(final List<LottoDto> lotteries) {
        outputView.printLotteriesNumber(lotteries);
    }

    public void showStatistics(final Map<LottoRank, Integer> result) {
        outputView.printStatistics(result);
    }

    public void showRateOfProfit(final Map<LottoRank, Integer> result, final TicketCount ticketCount) {
        outputView.printRateOfProfit(result, ticketCount);
    }

    private void validateBonusNumberContainsWinningNumber(final List<Integer> winningNumbers,
                                                          final Integer bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new WinningNumberContainsBonusNumberException();
        }
    }
}
