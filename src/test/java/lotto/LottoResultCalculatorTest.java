package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.Utils.LottoResultCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class LottoResultCalculatorTest {

    @Test
    @DisplayName("두 리스트에서 중복된 요소의 갯수를 찾는 메서드 테스트입니다.")
    void count_Element_Test() {
        List<Integer> list1 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> list2 = new ArrayList<>(List.of(1, 2, 3, 7, 8, 9));

        int result = LottoResultCalculator.countElement(list1, list2);

        assertThat(result).isEqualTo(3);
    }
}
