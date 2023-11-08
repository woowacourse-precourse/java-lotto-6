package lotto.model;

import static lotto.constant.ErrorMessage.CONTAINING_OTHER_THAN_NUMBER;
import static lotto.constant.ErrorMessage.NOT_IN_LOTTO_NUMBER_RANGE;
import static lotto.constant.LottoNumber.RANGE;
import static lotto.constant.MatchCriteria.FIFTH_PLACE;
import static lotto.constant.MatchCriteria.FIRST_PLACE;
import static lotto.constant.MatchCriteria.FOURTH_PLACE;
import static lotto.constant.MatchCriteria.SECOND_AND_THIRD_PLACE;
import static lotto.constant.StringPattern.NUMBER_PATTERN;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos from(final int quantity) {
        return new Lottos(
                IntStream.range(0, quantity)
                        .mapToObj(index -> Lotto.create())
                        .collect(Collectors.toList())
        );
    }

    public WinningResult getWinningResult(
            final String inputWinningNumber,
            final String inputBonusNumber
    ) {
        List<Integer> winningNumbers = Arrays.stream(inputWinningNumber.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();

        AtomicReference<WinningResult> winningResult = new AtomicReference<>(WinningResult.create());

        validateBonusNumber(inputBonusNumber);

        int bonusNumber = Integer.parseInt(inputBonusNumber);

        validateNumberInLottoNumberRange(bonusNumber);

        lottos.forEach(lotto ->
                winningResult.set(checkIfWin(
                        lotto.compareTo(winningNumbers),
                        winningResult.get(),
                        lotto.matchesBonusNumber(bonusNumber))
                ));
        return winningResult.get();
    }

    private void validateBonusNumber(final String inputBonusNumber) {
        if (NUMBER_PATTERN.isNotMatching(inputBonusNumber)) {
            throw new IllegalArgumentException(CONTAINING_OTHER_THAN_NUMBER.getMessage());
        }
    }

    private void validateNumberInLottoNumberRange(final int inputBonusNumber) {
        if (RANGE.notInclude(inputBonusNumber)) {
            throw new IllegalArgumentException(NOT_IN_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    private WinningResult checkIfWin(
            final int winningCount,
            WinningResult winningResult,
            final boolean matchesBonusNumber
    ) {
        if (winningCount == FIRST_PLACE.getCount()) {
            winningResult = winningResult.withIncreasedPlaceCount(0);
        }
        if (matchesBonusNumber && winningCount == SECOND_AND_THIRD_PLACE.getCount()) {
            winningResult = winningResult.withIncreasedPlaceCount(1);
        }
        if (winningCount == SECOND_AND_THIRD_PLACE.getCount()) {
            winningResult = winningResult.withIncreasedPlaceCount(2);
        }
        if (winningCount == FOURTH_PLACE.getCount()) {
            winningResult = winningResult.withIncreasedPlaceCount(3);
        }
        if (winningCount == FIFTH_PLACE.getCount()) {
            winningResult = winningResult.withIncreasedPlaceCount(4);
        }
        return winningResult;
    }

    public List<Lotto> getLotto() {
        return lottos;
    }
}
