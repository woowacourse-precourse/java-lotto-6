package lotto.domain;

import org.junit.jupiter.api.Test;




import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class LottoNumberGeneratorTest {
    LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

    @Test
    void generateLottoNumbers_테스트() {
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6);
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    List<Lotto> numbers = lottoNumberGenerator.getLottoNumbers();
                    for(Lotto number : numbers){
                        for (Integer num : input) {
                            assertThat(number.getNumbers().contains(num));
                        }
                    }
                },
                input
        );
    }
}
