package lotto.view;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OutputViewTest {
    @Test
    void 랜덤넘버가_형식에맞게_출력되어야한다() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6);
        String result = OutputView.printRandomLottoNumbers(input);
        Assertions.assertThat(result).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

}