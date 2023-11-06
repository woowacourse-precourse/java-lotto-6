package lotto.collaboration.lottos;

import static java.util.stream.Collectors.groupingBy;

import java.util.List;
import java.util.Map;
import lotto.collaboration.enums.Prize;
import lotto.collaboration.lottos.dto.PlayerLotto;

public class WinningLotto {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> winningNumbers, int bonusNumber) {
        occurExceptionIfDuplicatedBoth(winningNumbers, bonusNumber);
    }

    private static void occurExceptionIfDuplicatedBoth(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호와 보너스 번호는 중복될 수 없습니다.");
        }
    }

    public Map<Prize, List<PlayerLotto>> matchNumbers(List<PlayerLotto> buyLottos) {
        Map<Prize, List<PlayerLotto>> result = buyLottos.stream()
                .collect(groupingBy(lotto ->
                        Prize.matchPrize(this.matchNumbers(lotto), matchBonusNumber(lotto))));

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
