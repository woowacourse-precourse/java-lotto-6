package lotto.app.game.views;

import static lotto.app.game.views.enums.WinningLottoViewMessage.ANNOUNCE_WINNING_STATISTICS;
import static lotto.app.game.views.enums.WinningLottoViewMessage.ASK_BONUS_NUMBER;
import static lotto.app.game.views.enums.WinningLottoViewMessage.ASK_WINNING_NUMBERS;
import static lotto.app.game.views.enums.WinningLottoViewMessage.COUNT_OF_NUMBERS;
import static lotto.app.game.views.enums.WinningLottoViewMessage.DELIMITER_NUMBERS;
import static lotto.app.game.views.enums.WinningLottoViewMessage.EXCEPTION_DUPLICATED;
import static lotto.app.game.views.enums.WinningLottoViewMessage.EXCEPTION_NOT_SIX;
import static lotto.app.game.views.enums.WinningLottoViewMessage.EXCEPTION_OUT_OF_RANGE;
import static lotto.app.game.views.enums.WinningLottoViewMessage.MAX_NUMBER_RANGE;
import static lotto.app.game.views.enums.WinningLottoViewMessage.MIN_NUMBER_RANGE;
import static lotto.app.game.views.enums.WinningLottoViewMessage.calculationProfit;

import java.util.List;
import lotto.app.collaboration.dto.PrizeLottos;
import lotto.app.collaboration.enums.Prize;
import lotto.app.game.io.Input;
import lotto.app.game.io.InteractionRepeatable;
import lotto.app.game.io.Output;

public class WinningLottoView implements InteractionRepeatable {

    public final Input input;
    public final Output output;

    public WinningLottoView(final Input input, final Output output) {
        this.input = input;
        this.output = output;
    }

    public List<Integer> askWinningNumbers() {
        return supplyInteraction(() -> {
            output.println(ASK_WINNING_NUMBERS.get());
            List<Integer> winningNumbers = input.numbers(DELIMITER_NUMBERS.get());
            validate(winningNumbers);
            return winningNumbers;
        });
    }

    private void validate(List<Integer> winningNumbers) {
        winningNumbers.forEach(this::occurExceptionIfOutOfRange);
        occurExceptionIfNotSix(winningNumbers);
        occurExceptionIfDuplicated(winningNumbers);
    }

    private void occurExceptionIfOutOfRange(int bonusNumber) {
        if (bonusNumber < MIN_NUMBER_RANGE || MAX_NUMBER_RANGE < bonusNumber) {
            throw new IllegalArgumentException(EXCEPTION_OUT_OF_RANGE.get());
        }
    }

    private void occurExceptionIfNotSix(List<Integer> winningNumbers) {
        if (winningNumbers.size() != COUNT_OF_NUMBERS) {
            throw new IllegalArgumentException(EXCEPTION_NOT_SIX.get());
        }
    }

    private void occurExceptionIfDuplicated(List<Integer> winningNumbers) {
        if (winningNumbers.size() != winningNumbers.stream().distinct().count()) {
            throw new IllegalArgumentException(EXCEPTION_DUPLICATED.get());
        }
    }

    public int askBonusNumber() {
        return supplyInteraction(() -> {
            output.println(ASK_BONUS_NUMBER.get());
            int bonusNumber = input.number();
            occurExceptionIfOutOfRange(bonusNumber);
            return bonusNumber;
        });
    }

    public void announceWinningStatistics(final int purchaseAmount,
                                          final PrizeLottos prizeLottos) {
        output.println(ANNOUNCE_WINNING_STATISTICS.get());

        Prize.prizeByRank().forEach(prize ->
                output.println(prizeLottos.getMessageCountOfPrizeLottosBy(prize)));

        output.println(calculationProfit(
                prizeLottos.calculateTotalPrizeMoney(),
                purchaseAmount));
    }

}
