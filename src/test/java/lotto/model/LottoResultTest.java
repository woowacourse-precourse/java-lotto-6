package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoResultTest {

    Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
    LottoStorage lottoStorage = LottoStorage.from(List.of(lotto, lotto));

    static Stream<Arguments> generateData1() {
        return Stream.of(
                // 당첨번호, 보너스번호, 상금
                Arguments.of(Arrays.asList(1, 2, 3, 41, 42, 43), 45, 10000),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 42, 43), 45, 100000),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 43), 45, 3000000),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 43), 6, 60000000));
    }

    static Stream<Arguments> generateData2() {
        return Stream.of(
                // 당첨번호, 보너스번호, 등수
                Arguments.of(Arrays.asList(1, 2, 3, 41, 42, 43), 45, LottoRank.FIFTH),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 42, 43), 45, LottoRank.FOURTH),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 43), 45, LottoRank.THIRD),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 43), 6, LottoRank.SECOND));
    }

    @ParameterizedTest
    @MethodSource("generateData1")
    void calculatePriceSumTest(List<Integer> input, Integer bonusNumber, long price) {
        WinningNumbers winningNumbers = WinningNumbers.of(Lotto.from(input), bonusNumber);
        LottoResult lottoResult = LottoResult.of(lottoStorage, winningNumbers);
        Assertions.assertThat(lottoResult.calculatePriceSum()).isEqualTo(price);
    }

    @ParameterizedTest
    @MethodSource("generateData2")
    @DisplayName("몇 등을 몇 번 했는지 반환해야한다.")
    void getRankCountTest(List<Integer> input, Integer bonusNumber, LottoRank rank) {
        WinningNumbers winningNumbers = WinningNumbers.of(Lotto.from(input), bonusNumber);
        LottoResult lottoResult = LottoResult.of(lottoStorage, winningNumbers);
        Assertions.assertThat(lottoResult.getRankCount(rank)).isEqualTo(2);
    }
}