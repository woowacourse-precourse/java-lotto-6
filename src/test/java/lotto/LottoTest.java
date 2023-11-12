package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

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

    @DisplayName("로또가 두개 주어졌을 때 일치하는 숫자를 셀 수 있다.")
    @Test
    void countMatchNumbers() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto comparisonTargetLotto = new Lotto(List.of(2, 3, 4, 5, 6, 7));
        int countMatchNumbers = lotto.countMatchNumbers(comparisonTargetLotto);
        Assertions.assertThat(countMatchNumbers).isEqualTo(5);
    }

    @DisplayName("로또와 번호가 주어졌을 때 번호가 로또 내에 포함된 번호인지 알 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"1,true","2,true","3,true","10,false"})
    void containNumber(int number, boolean expectedContains) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        boolean contains = lotto.contains(new LottoNumber(number));
        Assertions.assertThat(contains).isEqualTo(expectedContains);
    }

}