package lotto.test;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Lotto;

public class LottoTest {
    @Test
    @DisplayName("로또 입력 값이 6개 미만인 경우 에러를 발생해야한다")
    void lottoSixValuesTest() {
        Assertions.assertThatThrownBy(() -> new Lotto(List.of(34, 5, 1, 26, 23)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("로또는 정렬된 채 저장되어야한다")
    void lottoOrderedTest() {
        List<Integer> unsortedNumbers = List.of(34, 5, 1, 26, 23, 13);
        Lotto lotto = new Lotto(unsortedNumbers);

        List<Integer> sortedNumbers = lotto.getNumbers();

        List<Integer> expectedSortedNumbers = List.of(1, 5, 13, 23, 26, 34);
        Assertions.assertThat(sortedNumbers).isEqualTo(expectedSortedNumbers);
    }

}
