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
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos from(int quantity) {
        return new Lottos(
                IntStream.range(0, quantity)
                        .mapToObj(index -> Lotto.create())
                        .collect(Collectors.toList())
        );
    }

    public WinningResult getWinningResult(String inputWinningNumber, String inputBonusNumber) {
        List<Integer> winningNumbers = Arrays.stream(inputWinningNumber.split(","))
                .map(Integer::parseInt)
                .toList();

        WinningResult winningResult = WinningResult.create();

        validateBonusNumber(inputBonusNumber);

        int bonusNumber = Integer.parseInt(inputBonusNumber);

        validateNumberInLottoNumberRange(bonusNumber);

        lottos.forEach(lotto -> checkIfWin(
                lotto.compareTo(winningNumbers),
                winningResult,
                lotto.matchesBonusNumber(bonusNumber)
        ));
        return winningResult;
    }

    private void validateBonusNumber(String inputBonusNumber) {
        if (NUMBER_PATTERN.isNotMatching(inputBonusNumber)) {
            throw new IllegalArgumentException(CONTAINING_OTHER_THAN_NUMBER.getMessage());
        }
    }

    private void validateNumberInLottoNumberRange(int inputBonusNumber) {
        if (RANGE.notInclude(inputBonusNumber)) {
            throw new IllegalArgumentException(NOT_IN_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    private static void checkIfWin(int winningCount, WinningResult winningResult, boolean matchesBonusNumber) {
        if (winningCount == FIRST_PLACE.getCount()) {
            winningResult = winningResult.withIncreasedFirstPlaceCount();
        }
        if (winningCount == SECOND_AND_THIRD_PLACE.getCount() && matchesBonusNumber) {
            winningResult = winningResult.withIncreasedSecondPlaceCount();
        }
        if (winningCount == SECOND_AND_THIRD_PLACE.getCount()) {
            winningResult = winningResult.withIncreasedThirdPlaceCount();
        }
        if (winningCount == FOURTH_PLACE.getCount()) {
            winningResult = winningResult.withIncreasedFourthPlaceCount();
        }
        if (winningCount == FIFTH_PLACE.getCount()) {
            winningResult = winningResult.withIncreasedFifthPlaceCount();
        }
    }

    public List<Lotto> getLotto() {
        return lottos;
    }
}
