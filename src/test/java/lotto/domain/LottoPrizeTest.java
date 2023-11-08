package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPrizeTest {
    @DisplayName("일치 숫자 개수를 반환한다.")
    @ParameterizedTest
    @CsvSource({"PRIZE_1ST, 6", "PRIZE_2ND, 5", "PRIZE_3RD, 5", "PRIZE_4TH, 4", "PRIZE_5TH, 3", "NOTHING, 0"})
    void getMatchingCountTest(LottoPrize lottoPrize, int matchingCount){
        assertThat(lottoPrize.getMatchingCount()).isEqualTo(matchingCount);
    }

    @DisplayName("등수에 따라 상금을 반환한다.")
    @ParameterizedTest
    @CsvSource({"PRIZE_1ST, 2000000000", "PRIZE_2ND,30000000", "PRIZE_3RD, 1500000", "PRIZE_4TH, 50000", "PRIZE_5TH, 5000"})
    void getPrizeTest(LottoPrize lottoPrize, int prize){
        assertThat(lottoPrize.getPrize().getMoney()).isEqualTo(prize);
    }

    @DisplayName("일치한 숫자 개수에 따라 당첨 상금이 결정된다.")
    @ParameterizedTest
    @MethodSource("matchingCountInfo")
    void determinePrizeByMatchingCountTest(int matchingCount, LottoPrize lottoPrize) {
        assertThat(LottoPrize.determinePrize(matchingCount)).isEqualTo(lottoPrize);
    }

    static List<Arguments> matchingCountInfo() {
        return Arrays.asList(
                Arguments.of(6, LottoPrize.PRIZE_1ST),
                Arguments.of(4, LottoPrize.PRIZE_4TH),
                Arguments.of(3, LottoPrize.PRIZE_5TH),
                Arguments.of(2, LottoPrize.NOTHING),
                Arguments.of(1, LottoPrize.NOTHING),
                Arguments.of(0, LottoPrize.NOTHING)
        );
    }

    @DisplayName("일치 숫자 개수가 5개일 때 보너스 숫자 포함 여부에 따라 등수를 결정한다.")
    @ParameterizedTest
    @MethodSource("_2ndOr3rdMatchingCountInfo")
    void determinePrize2ndOr3rdByMatchingCountTest(List<Integer> lottoNumbers, int bonusNumber, LottoPrize lottoPrize) {
        assertThat(LottoPrize.determine2ndOr3rdPrize(lottoNumbers, bonusNumber)).isEqualTo(lottoPrize);
    }

    static List<Arguments> _2ndOr3rdMatchingCountInfo() {
        return Arrays.asList(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 2, LottoPrize.PRIZE_2ND),
                Arguments.of(List.of(3, 6, 9, 12, 15, 18), 2, LottoPrize.PRIZE_3RD),
                Arguments.of(List.of(10, 16, 22, 28, 34, 40), 22, LottoPrize.PRIZE_2ND),
                Arguments.of(List.of(18, 24, 30, 36, 42, 45), 22, LottoPrize.PRIZE_3RD)
        );
    }
}