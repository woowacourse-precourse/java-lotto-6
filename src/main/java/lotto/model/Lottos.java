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
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(final List<Lotto> lottos) {
        Objects.requireNonNull(lottos);
        this.lottos = lottos;
    }

    public static Lottos from(final List<Lotto> lottos) {
        return new Lottos(lottos);
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
        Objects.requireNonNull(inputWinningNumber);
        Objects.requireNonNull(inputBonusNumber);
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
        Objects.requireNonNull(inputBonusNumber);
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
            final int winningNumberCount,
            WinningResult winningResult,
            final boolean matchesBonusNumber
    ) {
        Objects.requireNonNull(winningResult);
        winningResult = increaseFirstPlace(winningNumberCount, winningResult);
        winningResult = increaseSecondPlace(winningNumberCount, winningResult, matchesBonusNumber);
        winningResult = increaseThirdPlace(winningNumberCount, winningResult);
        winningResult = increaseFourthPlace(winningNumberCount, winningResult);
        winningResult = increaseFifthPlace(winningNumberCount, winningResult);
        return winningResult;
    }

    private static WinningResult increaseFirstPlace(final int winningNumberCount, WinningResult winningResult) {
        if (winningNumberCount == FIRST_PLACE.getCount()) {
            winningResult = winningResult.withIncreasedPlaceCount(0);
        }
        return winningResult;
    }

    private static WinningResult increaseSecondPlace(final int winningNumberCount, WinningResult winningResult,
                                                     boolean matchesBonusNumber) {
        if (matchesBonusNumber && winningNumberCount == SECOND_AND_THIRD_PLACE.getCount()) {
            winningResult = winningResult.withIncreasedPlaceCount(1);
        }
        return winningResult;
    }

    private static WinningResult increaseThirdPlace(final int winningNumberCount, WinningResult winningResult) {
        if (winningNumberCount == SECOND_AND_THIRD_PLACE.getCount()) {
            winningResult = winningResult.withIncreasedPlaceCount(2);
        }
        return winningResult;
    }

    private static WinningResult increaseFourthPlace(final int winningNumberCount, WinningResult winningResult) {
        if (winningNumberCount == FOURTH_PLACE.getCount()) {
            winningResult = winningResult.withIncreasedPlaceCount(3);
        }
        return winningResult;
    }

    private static WinningResult increaseFifthPlace(final int winningNumberCount, WinningResult winningResult) {
        if (winningNumberCount == FIFTH_PLACE.getCount()) {
            winningResult = winningResult.withIncreasedPlaceCount(4);
        }
        return winningResult;
    }

    public List<Lotto> getLotto() {
        return lottos;
    }
}
