package lotto.domain;

import lotto.constant.LottoRank;
import lotto.util.FakeNumberGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

@DisplayName("LottoPack 테스트")
class LottoPackTest {


    @DisplayName("size 테스트")
    @Nested
    class size {

        @DisplayName("생성 시 넣은 숫자만큼의 숫자를 반환한다.")
        @Test
        void sizeReturnsGivenNumbers() {
            LottoPack lottoPack = LottoPack.createLottoPack(10);
            Assertions.assertEquals(lottoPack.size(), 10);
        }

    }

    @DisplayName("toString 테스트")
    @Nested
    class toString {

        @DisplayName("출력 문자열을 확인한다.")
        @Test
        void toStringConventionCheck() {

            LottoPack lottoPack = new LottoPack(
                    1, new FakeNumberGenerator(List.of(1, 2, 3, 4, 5, 6))
            );

            org.assertj.core.api.Assertions.assertThat(lottoPack.toString())
                    .contains("[1, 2, 3, 4, 5, 6]");

        }

    }

    @DisplayName("calculate 테스트")
    @Nested
    class calculate {

        @DisplayName("등수를 잘 검사하는지 확인")
        @ParameterizedTest
        @MethodSource("provideLottoAndResult")
        void checkTHREE(Result result, Lotto lotto, LottoRank lottoRank) {
            Assertions.assertEquals(lotto.calculate(result), lottoRank);
        }

        private static Stream<Arguments> provideLottoAndResult() {
            Result result = getResult();
            return Stream.of(
                    Arguments.of(result, new Lotto(List.of(40, 41, 42, 43, 44, 45)), LottoRank.NOTHING),
                    Arguments.of(result, new Lotto(List.of(1, 2, 3, 43, 44, 45)), LottoRank.THREE),
                    Arguments.of(result, new Lotto(List.of(1, 2, 3, 4, 44, 45)), LottoRank.FOUR),
                    Arguments.of(result, new Lotto(List.of(1, 2, 3, 4, 5, 45)), LottoRank.FIVE),
                    Arguments.of(result, new Lotto(List.of(1, 2, 3, 4, 5, 7)), LottoRank.FIVE_BONUS),
                    Arguments.of(result, new Lotto(List.of(1, 2, 3, 4, 5, 6)), LottoRank.SIX)
            );
        }

        private static Result getResult() {
            WinningNumbers winningNumbers = WinningNumbers.createWinningNumbers(List.of(1, 2, 3, 4, 5, 6));
            BonusNumber bonusNumber = new BonusNumber(7);
            return new Result(winningNumbers, bonusNumber);
        }

    }

}