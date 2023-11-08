package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"1,2,3,4,5,6,1", "1,2,3,4,5,7,2", "1,2,3,4,5,8,3", "1,2,3,4,7,8,4", "1,2,3,7,8,9,5", "1,2,7,8,9,10,-1", "1,7,8,9,10,11,-1", "7,8,9,10,11,12,-1"})
    void getRank(int num1, int num2, int num3, int num4, int num5, int num6, int rank) {
        Lotto lotto = new Lotto(List.of(num1, num2, num3, num4, num5, num6));
        List<Integer> winNums = List.of(1, 2, 3, 4, 5, 6);
        int bonusNum = 7;

        int result = lotto.getRank(winNums, bonusNum).getValue();

        assertThat(result).isEqualTo(rank);
    }
}