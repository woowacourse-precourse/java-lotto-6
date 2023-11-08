package lotto;

import static lotto.utils.ConstantValues.MAX_LOTTO_NUMBER;
import static lotto.utils.ConstantValues.MIN_LOTTO_NUMBER;
import static lotto.utils.ErrorMessages.LOTTO_NUMBER_OUT_OF_RANGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

// domain 패키지 밑에 있는 것이 자연스럽지만 LottoTest의 패키지 이동에 대한 설명이 없으므로 그대로 두었습니다.
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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 1~45사이가 아닌 숫자가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void createLottoByOverRangeOfNumber(int number) {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, number)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(LOTTO_NUMBER_OUT_OF_RANGE, MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER));
    }

    @DisplayName("로또 번호에 특정 번호가 포함되어 있는지 검사한다.")
    @Test
    void hasLottoNumber() {
        // given
        int commonNumber = 1;
        int notCommonNumber = 7;
        Lotto lotto = new Lotto(List.of(commonNumber, 2, 3, 4, 5, 6));
        // when, then
        assertThat(lotto.hasNumber(commonNumber)).isEqualTo(true);
        assertThat(lotto.hasNumber(notCommonNumber)).isEqualTo(false);
    }

    @DisplayName("로또가 다른 로또와 공통된 숫자가 몇개 있는지 검사한다.")
    @Test
    void getSameCount() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto otherLotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        int expectedSameCount = 3;
        // when, then
        assertThat(lotto.getSameCount(otherLotto)).isEqualTo(expectedSameCount);
    }

    @DisplayName("로또가 가진 번호들을 오름차순 정렬, 쉼표로 구분, 대괄호로 감싼 뒤 반환한다.")
    @Test
    void lottoToStringForPrinting() {
        // given
        Lotto lotto = new Lotto(List.of(35, 20, 9, 8, 13, 5));
        String expectedResult = "[5, 8, 9, 13, 20, 35]";
        // when
        String lottoPrintFormat = lotto.toString();
        // then
        assertThat(lottoPrintFormat).isEqualTo(expectedResult);
    }
}