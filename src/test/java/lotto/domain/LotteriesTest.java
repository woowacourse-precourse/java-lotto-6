package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import lotto.domain.argument.CalculateTotalRankCountArgumentsProvider;
import lotto.domain.argument.CalculateTotalWinningPriceArgumentsProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

class LotteriesTest {

    @ParameterizedTest(name = "사용자 로또 번호 : {0}, 보너스 번호 : {1}, 예상 결과 : {2}")
    @ArgumentsSource(CalculateTotalWinningPriceArgumentsProvider.class)
    @DisplayName("총 로또 당첨 금액을 구하는 기능 테스트")
    void calculateTotalWinningPrice(final List<Integer> numbers, final int bonusNumber, final BigDecimal expected) {
        // given
        Lotteries lotteries = Lotteries.from(List.of(
                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45))
        ));
        Lotto lotto = new Lotto(numbers);
        LottoNumber bonusLottoNumber = LottoNumber.valueOf(bonusNumber);
        UserLotto userLotto = UserLotto.from(lotto, bonusLottoNumber);

        // when
        BigDecimal actual = lotteries.calculateTotalWinningPrice(userLotto);

        // then
        assertEquals(expected, actual);
    }

    @ParameterizedTest(name = "사용자 로또 번호 : {0}, 보너스 번호 : {1}, 예상 결과 : {2}")
    @ArgumentsSource(CalculateTotalRankCountArgumentsProvider.class)
    @DisplayName("총 로또 당첨 등수 개수를 구하는 기능 테스트")
    void calculateTotalRankCount(final List<Integer> numbers, final int bonusNumber,
                                 final Map<Rank, Integer> expected) {
        // given
        Lotteries lotteries = Lotteries.from(List.of(
                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45))
        ));
        Lotto lotto = new Lotto(numbers);
        LottoNumber bonusLottoNumber = LottoNumber.valueOf(bonusNumber);
        UserLotto userLotto = UserLotto.from(lotto, bonusLottoNumber);

        // when
        Map<Rank, Integer> actual = lotteries.calculateTotalRankCount(userLotto);

        // then
        assertEquals(expected, actual);
    }
}