package lotto.domain;

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

    private static final String ERROR_PREFIX_TEXT = "[ERROR]";

    @ParameterizedTest
    @DisplayName("당첨 번호 로또 예외 발생 테스트")
    @MethodSource("errorWitLottoData")
    void winLottoCreateExceptionTest(List<Integer> winLottoNumber, int bonusNumber, String errorMessage) {
        assertThatThrownBy(() -> new WinLotto(new Lotto(winLottoNumber), bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX_TEXT, errorMessage);
    }

    static Stream<Arguments> errorWitLottoData() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 5), 44, "중복된 로또 번호가 존재합니다."),
                Arguments.of(List.of(2, 18, 3, 4, 5, 6, 1), 23, "로또 번호가 6자리가 아닙니다."),
                Arguments.of(List.of(15, 2, 23, 43, 5, 6), 23, "보너스 번호가 당첨 로또 번호에 중복됩니다.")
        );
    }

    @ParameterizedTest
    @DisplayName("당첨 번호 정상적인 경우 저장 처리 테스트")
    @MethodSource("initWinLottoData")
    void winLottoCreateSaveTest(List<Integer> winLottoNumber, int bonusNumber) {
        // new Lotto 생성 시 로또 범위 1 ~ 45 / 로또 번호 중복 / 로또 갯수 검증
        Assertions.assertThatNoException().isThrownBy(() -> new WinLotto(new Lotto(winLottoNumber), bonusNumber));
    }

    static Stream<Arguments> initWinLottoData() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 45), 44),
                Arguments.of(List.of(2, 18, 3, 4, 5, 6), 23),
                Arguments.of(List.of(15, 2, 23, 43, 5, 6), 19)
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