package lotto.domain;

import java.util.stream.Stream;
import lotto.constant.testConstant;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.constant.testConstant.BONUS_NUMBER_45;
import static lotto.constant.testConstant.LOTTO_1_TO_6;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 1~45 사이가 아닌 숫자가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46, -1})
    void createLottoByInvalideRangeNumber(int invalidNumber) {
        assertThatThrownBy(() -> new Lotto(List.of(invalidNumber, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 숫자는 1~45 사이의 숫자여야합니다.");
    }

    public static Stream<Arguments> lottoResults() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 44), 5, false),
                Arguments.of(List.of(1, 21, 22, 23, 24, 45), 1, true));
    }

    @DisplayName("getResult는 로또를 당첨 번호, 보너스번호와 비교한 결과를 반환한다.")
    @ParameterizedTest
    @MethodSource("lottoResults")
    void check_getResult(List<Integer> lottoNumbers, int winningCount, boolean bonusMatching) {
        Lotto lotto = new Lotto(lottoNumbers);
        LottoResult lottoResult = lotto.getResult(LOTTO_1_TO_6, BONUS_NUMBER_45);
        assertThat(lottoResult.getWinningCount()).isEqualTo(winningCount);
        assertThat(lottoResult.isBonusNumberMatching()).isEqualTo(bonusMatching);
    }
}