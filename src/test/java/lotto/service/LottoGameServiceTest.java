package lotto.service;

import java.util.List;
import lotto.LottoExceptionMessage;
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
                    .hasMessage(LottoExceptionMessage.INVALID_NUMBER.getError());
        }

        @Test
        @DisplayName("[Exception] 로또 숫자 최댓값 45 초과인 경우")
        void upperBound() {
            lottoGameService = new LottoGameService(() -> List.of(1, 2, 3, 4, 5, 46),
                    new YieldCalculator());

            Assertions.assertThatThrownBy(() -> lottoGameService.createPlayerLotto(1))
                    .hasMessage(LottoExceptionMessage.INVALID_NUMBER.getError());
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
                    .hasMessage(LottoExceptionMessage.DUPLICATE_EXISTS.getError());
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

}