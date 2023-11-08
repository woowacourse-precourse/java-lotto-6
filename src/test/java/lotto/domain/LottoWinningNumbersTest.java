package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.dto.LottoTickets;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoWinningNumbersTest {
    @Test
    @DisplayName("로또 당첨 번호의 개수가 6개를 넘지 못 하면 예외가 발생한다.")
    void createLottoWinningNumbersByLessSize() {
        assertThrows(IllegalArgumentException.class,
                () -> LottoWinningNumbers.createWinningNumbers(
                        WinningNumbers.createWinningNumbers(List.of(1, 2, 3, 4, 5)), BonusNumber.createBonusNumber(7)));
    }

    @Test
    @DisplayName("로또 당첨 번호의 개수가 6개를 넘으면 예외가 발생한다.")
    void createLottoWinningNumbersByOverSize() {
        assertThrows(IllegalArgumentException.class,
                () -> LottoWinningNumbers.createWinningNumbers(
                        WinningNumbers.createWinningNumbers(List.of(1, 2, 3, 4, 5, 6, 7)),
                        BonusNumber.createBonusNumber(8)));
    }

    @Test
    @DisplayName("중복된 로또 당첨 번호가 있다면 예외가 발생한다.")
    void createLottoWinningNumbersByDuplicateNumber() {
        assertThrows(IllegalArgumentException.class,
                () -> LottoWinningNumbers.createWinningNumbers(
                        WinningNumbers.createWinningNumbers(List.of(1, 2, 3, 4, 5, 5)),
                        BonusNumber.createBonusNumber(7)));
    }

    @ParameterizedTest
    @DisplayName("범위를 넘은 로또 당첨 번호가 있다면 예외가 발생한다.")
    @ValueSource(ints = {-1, 0, 46})
    void createLottoWinningNumbersByOutOfRange(int outOfRangeNumber) {
        assertThrows(IllegalArgumentException.class,
                () -> LottoWinningNumbers.createWinningNumbers(
                        WinningNumbers.createWinningNumbers(List.of(1, 2, 3, 4, 5, outOfRangeNumber)),
                        BonusNumber.createBonusNumber(7)));
    }

    @Test
    @DisplayName("보너스 번호가 로또 당첨 번호와 중복된다면 예외가 발생한다.")
    void createLottoWinningNumbersByDuplicateBonusNumber() {
        assertThrows(IllegalArgumentException.class,
                () -> LottoWinningNumbers.createWinningNumbers(
                        WinningNumbers.createWinningNumbers(List.of(1, 2, 3, 4, 5, 6)),
                        BonusNumber.createBonusNumber(6)));
    }

    @ParameterizedTest
    @DisplayName("보너스 번호가 범위를 벗어났다면 예외가 발생한다.")
    @ValueSource(ints = {-1, 0, 46})
    void createLottoWinningNumbersByOutOfRangeBonusNumber(int outOfRangeNumber) {
        assertThrows(IllegalArgumentException.class,
                () -> LottoWinningNumbers.createWinningNumbers(
                        WinningNumbers.createWinningNumbers(List.of(1, 2, 3, 4, 5, 6)),
                        BonusNumber.createBonusNumber(outOfRangeNumber)));
    }

    @Test
    @DisplayName("로또 당첨 번호 생성")
    void createLottoWinningNumbers() {
        assertDoesNotThrow(
                () -> LottoWinningNumbers.createWinningNumbers(
                        WinningNumbers.createWinningNumbers(List.of(1, 2, 3, 4, 5, 6)),
                        BonusNumber.createBonusNumber(7)));
    }

    @Test
    @DisplayName("로또가 3개 미만으로 일치한 경우 당첨 정보는 비어있다.")
    void winningMatchResultIsEmptyIfAllLottoTicketsFail() {
        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.createWinningNumbers(
                WinningNumbers.createWinningNumbers(List.of(31, 32, 33, 34, 35, 36)),
                BonusNumber.createBonusNumber(37));

        LottoTickets lottoTickets = new LottoTickets(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(31, 2, 3, 4, 5, 6)),
                new Lotto(List.of(31, 32, 3, 4, 5, 6))
        ));

        assertThat(lottoWinningNumbers.calculateWinningStatistics(lottoTickets))
                .isEmpty();
    }

    @ParameterizedTest
    @DisplayName("로또가 3개 이상 일치한 경우 당첨 정보는 생성된다.")
    @MethodSource("lottoAndExpectWinningTier")
    void winningMatchResult(Lotto lotto, LottoWinningTier expectWinningTier) {
        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.createWinningNumbers(
                WinningNumbers.createWinningNumbers(List.of(31, 32, 33, 34, 35, 36)),
                BonusNumber.createBonusNumber(37));

        LottoTickets lottoTickets = new LottoTickets(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(31, 2, 3, 4, 5, 6)),
                new Lotto(List.of(31, 32, 3, 4, 5, 6)),
                lotto
        ));

        assertThat(lottoWinningNumbers.calculateWinningStatistics(lottoTickets))
                .isEqualTo(List.of(expectWinningTier));
    }

    public static Stream<Arguments> lottoAndExpectWinningTier() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(31, 32, 33, 4, 5, 6)),
                        LottoWinningTier.FIFTH_TIER),
                Arguments.of(new Lotto(List.of(31, 32, 33, 34, 5, 6)),
                        LottoWinningTier.FOURTH_TIER),
                Arguments.of(new Lotto(List.of(31, 32, 33, 34, 35, 6)),
                        LottoWinningTier.THIRD_TIER),
                Arguments.of(new Lotto(List.of(31, 32, 33, 34, 35, 37)),
                        LottoWinningTier.SECOND_TIER),
                Arguments.of(new Lotto(List.of(31, 32, 33, 34, 35, 36)),
                        LottoWinningTier.FIRST_TIER)
        );
    }
}
