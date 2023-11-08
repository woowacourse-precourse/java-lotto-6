package model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {
    private static Lotto lotto;

    @DisplayName("로또 6개 숫자가 아닐 시 에러 확인")
    @Test
    void lottoNumbersValidateTest() {
        List<Integer> numbers = new ArrayList(Arrays.asList(1,2,3));

        assertThatThrownBy(() -> lotto = new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 1-45 범위 숫자가 아닐 시 에러 확인")
    @Test
    void lottoNumbersValidateNumberRangeTest() {
        List<Integer> numbers = new ArrayList(Arrays.asList(1,2,3,4,5,46));;

        assertThatThrownBy(() -> lotto = new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
