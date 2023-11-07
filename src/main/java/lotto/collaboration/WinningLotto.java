package lotto.collaboration;

import static java.util.stream.Collectors.groupingBy;
import static lotto.collaboration.enums.WinningLottoMessage.EXCEPTION_DUPLICATED;

import java.util.List;
import java.util.Map;
import lotto.collaboration.dto.PlayerLotto;
import lotto.collaboration.enums.Prize;

public class WinningLotto {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningLotto(final List<Integer> winningNumbers, final int bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> winningNumbers, int bonusNumber) {
        occurExceptionIfDuplicatedBoth(winningNumbers, bonusNumber);
    }

    private static void occurExceptionIfDuplicatedBoth(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(EXCEPTION_DUPLICATED.get());
        }
    }

    public Map<Prize, List<PlayerLotto>> matchNumbers(final List<PlayerLotto> buyLottos) {
        Map<Prize, List<PlayerLotto>> result = buyLottos.stream()
                .collect(groupingBy(lotto ->
                        Prize.matchPrize(matchNumbers(lotto), matchBonusNumber(lotto))));

        return result;
    }

    private int matchNumbers(PlayerLotto lotto) {
        return (int) lotto.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private boolean matchBonusNumber(PlayerLotto lotto) {
        return lotto.stream().anyMatch(number -> bonusNumber == number);
    }

}
