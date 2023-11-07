package lotto.game.views;

import static lotto.game.views.enums.WinningLottoViewMessage.ANNOUNCE_WINNING_STATISTICS;
import static lotto.game.views.enums.WinningLottoViewMessage.ASK_BONUS_NUMBER;
import static lotto.game.views.enums.WinningLottoViewMessage.ASK_WINNING_NUMBERS;
import static lotto.game.views.enums.WinningLottoViewMessage.COUNT_OF_NUMBERS;
import static lotto.game.views.enums.WinningLottoViewMessage.DELIMITER_NUMBERS;
import static lotto.game.views.enums.WinningLottoViewMessage.EXCEPTION_DUPLICATED;
import static lotto.game.views.enums.WinningLottoViewMessage.EXCEPTION_NOT_SIX;
import static lotto.game.views.enums.WinningLottoViewMessage.EXCEPTION_OUT_OF_RANGE;
import static lotto.game.views.enums.WinningLottoViewMessage.MAX_NUMBER_RANGE;
import static lotto.game.views.enums.WinningLottoViewMessage.MIN_NUMBER_RANGE;

import java.util.List;
import java.util.Map;
import lotto.collaboration.lottostore.dto.PlayerLotto;
import lotto.collaboration.lottostore.enums.Prize;
import lotto.game.io.Input;
import lotto.game.io.InteractionRepeatable;
import lotto.game.io.Output;
import lotto.game.views.enums.WinningLottoViewMessage;

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

    public void announceWinningStatistics(final int purchaseAmount, final Map<Prize, List<PlayerLotto>> prizeListMap) {
        output.println(ANNOUNCE_WINNING_STATISTICS.get());
        long totalPrizeMoney = 0L;
        for (Prize prize : Prize.valuesByRank()) {
            if (prize == Prize.LOST) {
                continue;
            }
            List<PlayerLotto> prizeLottos = prizeListMap.getOrDefault(prize, List.of());
            output.println(prize.makeCountOfPrizeLottos(prizeLottos.size()));
            totalPrizeMoney += prize.money() * prizeLottos.size();
        }

        output.println(WinningLottoViewMessage.calculationProfit(totalPrizeMoney, purchaseAmount));
    }

}
