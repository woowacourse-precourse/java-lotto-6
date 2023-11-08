package lotto.service;

import java.util.List;
import lotto.domain.lottery.Lotto;
import lotto.domain.lottery.LottoNumber;
import lotto.domain.lottery.PlayerLotto;
import lotto.domain.lottery.WinningInformation;
import lotto.dto.WinningStatisticsDto;
import lotto.service.numbergenerator.SixUniqueNumberGenerator;
import lotto.utils.message.LottoExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class LottoGameServiceTest {

    LottoGameService lottoGameService;

    @Nested
    @DisplayName("사용자 로또 생성 요청 테스트")
    class CreatePlayerLottoTest {
        @Test
        @DisplayName("[Exception] 로또 숫자 최솟값 1 미만인 경우")
        void lowerBound() {
            lottoGameService = new LottoGameService(() -> List.of(0, 7, 13, 19, 25, 31),
                    new YieldCalculator());

            Assertions.assertThatThrownBy(() -> lottoGameService.createPlayerLotto(1))
                    .hasMessage(LottoExceptionMessage.NOT_SATISFY_LOTTO_NUMBER_RANGE.getError());
        }

        @Test
        @DisplayName("[Exception] 로또 숫자 최댓값 45 초과인 경우")
        void upperBound() {
            lottoGameService = new LottoGameService(() -> List.of(1, 2, 3, 4, 5, 46),
                    new YieldCalculator());

            Assertions.assertThatThrownBy(() -> lottoGameService.createPlayerLotto(1))
                    .hasMessage(LottoExceptionMessage.NOT_SATISFY_LOTTO_NUMBER_RANGE.getError());
        }

        @ParameterizedTest
        @MethodSource("lotto.helper.TestHelper#createInvalidCountNumbers")
        @DisplayName("[Exception] 로또 숫자가 6개가 아닌 경우")
        void invalidCounts(List<Integer> invalidCountNumbersInput) {
            lottoGameService = new LottoGameService(() -> invalidCountNumbersInput, new YieldCalculator());

            Assertions.assertThatThrownBy(() -> lottoGameService.createPlayerLotto(1))
                    .hasMessage(LottoExceptionMessage.NOT_SATISFY_REQUIRED_COUNT.getError());
        }

        @ParameterizedTest
        @MethodSource("lotto.helper.TestHelper#createDuplicateNumbers")
        @DisplayName("[Exception] 중복된 숫자 존재")
        void duplicateExists(List<Integer> duplicateNumbersInput) {

            lottoGameService = new LottoGameService(() -> duplicateNumbersInput, new YieldCalculator());

            Assertions.assertThatThrownBy(() -> lottoGameService.createPlayerLotto(1))
                    .hasMessage(LottoExceptionMessage.NOT_SATISFY_LOTTO_NUMBER_UNIQUE.getError());
        }

        @ParameterizedTest
        @MethodSource("lotto.helper.TestHelper#createValidNumbers")
        @DisplayName("[Success] 1~45 범위의 서로 다른 6개의 수")
        void validNumbers(List<Integer> validNumbersInput) {

            lottoGameService = new LottoGameService(() -> validNumbersInput, new YieldCalculator());

            Assertions.assertThatCode(() -> lottoGameService.createPlayerLotto(1))
                    .doesNotThrowAnyException();
        }
    }

    @Nested
    @DisplayName("사용자 최종 성적을 요청하여 당첨 통계를 반환하는 기능 테스트")
    class CalculateWinningStatistics {
        @ParameterizedTest
        @MethodSource("lotto.helper.TestHelper#createPlayerLotto")
        @DisplayName("5개 구매하고 5등 1번, 4등 3번했을 때의 수익률은 3100.0% 이다.")
        void randomWinningStatisticsTestOne(PlayerLotto playerLotto) {
            // given
            LottoGameService lottoGameService = new LottoGameService(new SixUniqueNumberGenerator(),
                    new YieldCalculator());
            Lotto winningNumber = new Lotto(List.of(1, 4, 7, 2, 29, 30));
            LottoNumber lottoNumber = new LottoNumber(8);
            WinningInformation winningInformation = new WinningInformation(winningNumber, lottoNumber);
            // when
            WinningStatisticsDto winningStatisticsDto = lottoGameService.calculateWinningStatistics(playerLotto,
                    winningInformation);
            // then
            Assertions.assertThat(winningStatisticsDto.getYieldRate().toString()).isEqualTo("3100.0");
        }

        @ParameterizedTest
        @MethodSource("lotto.helper.TestHelper#createPlayerLotto")
        @DisplayName("5개 구매하고 1등 1번, 5등 3번했을 때의 수익률은 40000300.0% 이다.")
        void randomWinningStatisticsTestTwo(PlayerLotto playerLotto) {
            // given
            LottoGameService lottoGameService = new LottoGameService(new SixUniqueNumberGenerator(),
                    new YieldCalculator());
            Lotto winningNumber = new Lotto(List.of(11, 12, 13, 3, 2, 7));
            LottoNumber lottoNumber = new LottoNumber(4);
            WinningInformation winningInformation = new WinningInformation(winningNumber, lottoNumber);
            // when
            WinningStatisticsDto winningStatisticsDto = lottoGameService.calculateWinningStatistics(playerLotto,
                    winningInformation);
            // then
            Assertions.assertThat(winningStatisticsDto.getYieldRate().toString()).isEqualTo("40000300.0");
        }
    }
}