package lotto;

import lotto.domain.LottoNumberGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberGeneratorTest {
    @Test
    void generateLottoNumbers_테스트() {
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6);
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    List<Integer> numbers = LottoNumberGenerator.generateLottoNumbers();
                    for (Integer num : input) {
                        assertThat(numbers).contains(num);
                    }
                },
                input
        );
    }
}
