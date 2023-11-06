package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumbersGeneratorTest {
    @DisplayName("로또 번호가 생성되면 오름차순으로 정렬된다.")
    @Test
    void getSortedLottoNumbers() {
        LottoNumbersGenerator generator = new ManualGenerator();
        List<Integer> actaul = generator.getSortedLottoNumbers();
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);

        assertThat(actaul).isEqualTo(expected);
    }
}
