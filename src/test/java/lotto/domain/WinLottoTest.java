package lotto.domain;

import static lotto.constants.ErrorMessage.ERROR_LOTTO_CONTAINS_BONUS;
import static lotto.constants.TestGlobalConstant.ERROR_PREFIX_TEXT;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import lotto.constants.LottoPrize;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinLottoTest {

    @ParameterizedTest
    @DisplayName("당첨 번호 로또 예외 발생 테스트")
    @MethodSource("errorWitLottoData")
    void winLottoCreateExceptionTest(Lotto winLotto, int bonusNumber, String errorMessage) {
        assertThatThrownBy(() -> new WinLotto(winLotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX_TEXT, errorMessage);
    }

    static Stream<Arguments> errorWitLottoData() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(15, 2, 23, 43, 5, 6)), 23, ERROR_LOTTO_CONTAINS_BONUS.getMessage()),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 6, ERROR_LOTTO_CONTAINS_BONUS.getMessage())
        );
    }

    @ParameterizedTest
    @DisplayName("당첨 번호 정상적인 경우 저장 처리 테스트")
    @MethodSource("initWinLottoData")
    void winLottoCreateSaveTest(Lotto winLotto, int bonusNumber) {
        // new Lotto 생성 시 로또 범위 1 ~ 45 / 로또 번호 중복 / 로또 갯수 검증
        Assertions.assertThatNoException().isThrownBy(() -> new WinLotto(winLotto, bonusNumber));
    }

    static Stream<Arguments> initWinLottoData() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 45)), 44),
                Arguments.of(new Lotto(List.of(2, 18, 3, 4, 5, 6)), 23),
                Arguments.of(new Lotto(List.of(15, 2, 23, 43, 5, 6)), 19)
        );
    }

    @ParameterizedTest
    @DisplayName("로또 당첨 번호 비교 테스트")
    @MethodSource("initWitLottoData2")
    void lottoNumberWinningComparisonTest(
            List<Integer> winLottoNumber
            , int bonusNumber
            , Lotto otherLotto
            , LottoPrize reuslt
    ) {

        WinLotto test = new WinLotto(new Lotto(winLottoNumber), bonusNumber);

        Assertions.assertThat(test.lottoComparison(otherLotto)).isEqualTo(reuslt);
    }

    static Stream<Arguments> initWitLottoData2() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 45)
                        , 44
                        , new Lotto(List.of(1, 2, 3, 4, 5, 45))
                        , LottoPrize.FIRST_PRIZE),
                Arguments.of(List.of(2, 18, 3, 4, 5, 6)
                        , 23
                        , new Lotto(List.of(2, 18, 3, 4, 5, 23))
                        , LottoPrize.SECOND_PRIZE),
                Arguments.of(List.of(15, 2, 23, 43, 5, 6)
                        , 19
                        , new Lotto(List.of(3, 4, 7, 8, 9, 10))
                        , LottoPrize.NO_PRIZE)
        );
    }

}