package lotto.service;

import lotto.model.Lotto;
import lotto.utils.PrizeType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class LottoReaderTest {
    private static Stream<Arguments> normalLottoMatchArguments() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 7;

        return Stream.of(
                Arguments.arguments("1등 당첨", winningNumbers, bonusNumber, new Lotto(List.of(1, 2, 3, 4, 5, 6)), PrizeType.FIFTH_PLACE),
                Arguments.arguments("2등 당첨", winningNumbers, bonusNumber, new Lotto(List.of(1, 2, 3, 4, 5, 7)), PrizeType.SECOND_PLACE),
                Arguments.arguments("3등 당첨", winningNumbers, bonusNumber, new Lotto(List.of(1, 2, 3, 4, 5, 8)), PrizeType.THIRD_PLACE),
                Arguments.arguments("3등 당첨(보너스 번호를 포함)", winningNumbers, bonusNumber, new Lotto(List.of(1, 2, 3, 4, 7, 8)), PrizeType.THIRD_PLACE),
                Arguments.arguments("4등 당첨", winningNumbers, bonusNumber, new Lotto(List.of(1, 2, 3, 4, 10, 11)), PrizeType.FOURTH_PLACE),
                Arguments.arguments("4등 당첨(보너스 번호를 포함)", winningNumbers, bonusNumber, new Lotto(List.of(1, 2, 3, 4, 7, 11)), PrizeType.FOURTH_PLACE),
                Arguments.arguments("5등 당첨", winningNumbers, bonusNumber, new Lotto(List.of(1, 2, 3, 23, 24, 25)), PrizeType.FIFTH_PLACE),
                Arguments.arguments("5등 당첨(보너스 번호를 포함)", winningNumbers, bonusNumber, new Lotto(List.of(1, 2, 7, 23, 24, 25)), PrizeType.FIFTH_PLACE)
        );
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("normalLottoMatchArguments")
    @DisplayName("정상적인 로또 비교 테스트")
    void normalLottoMatchTest(
            String testName,
            List<Integer> winningNumbers,
            Integer bonusNumber,
            Lotto lotto
    ) {
        Assertions.assertDoesNotThrow(
                () -> LottoReader.match(winningNumbers, bonusNumber, lotto)
        );
    }
}
