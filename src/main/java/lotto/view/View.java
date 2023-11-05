package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.constant.LottoRank;
import lotto.dto.LottoDto;
import lotto.exception.WinningNumberContainsBonusNumberException;
import lotto.model.Lotto;
import lotto.util.Converter;
import lotto.vo.BonusNumber;
import lotto.vo.TicketQuantity;

public class View {

    private final InputView inputView;
    private final OutputView outputView;

    public View(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public TicketQuantity getTicketQuantity() {
        outputView.printRequestInputBuyAmountMessage();
        while (true) {
            try {
                Integer amount = inputView.inputBuyAmount();
                TicketQuantity ticketQuantity = Converter.convertToTicketCount(amount);
                outputView.printTicketQuantityMessage(ticketQuantity.quantity());
                return ticketQuantity;
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
                BonusNumber bonusNumber = Converter.convertToBonusNumber(number);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
    }

    public void showPlayerNumbers(final List<LottoDto> playerLotteries) {
        outputView.printPlayerNumbers(playerLotteries);
    }

    public void showStatistics(final Map<LottoRank, Integer> result) {
        outputView.printStatistics(result);
    }

    public void showRateOfProfit(final Map<LottoRank, Integer> result, final TicketQuantity ticketQuantity) {
        outputView.printRateOfProfit(result, ticketQuantity);
    }

    private void validateBonusNumberContainsWinningNumber(final List<Integer> winningNumbers,
                                                          final Integer bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new WinningNumberContainsBonusNumberException();
        }
    }
}
