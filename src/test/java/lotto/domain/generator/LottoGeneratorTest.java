package lotto.domain.generator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {

    @Test
    void 로또_번호를_생성할때_개수는_6개이여야_함() {
        // given
        int givenLottoNumberSize = 6;

        // when
        LottoGeneratorImpl lottoGenerator = new RandomLottoGenerator();
        List<Integer> generatedNumber = lottoGenerator.generate();
        int lottoNumberSize = generatedNumber.size();

        // then
        assertThat(lottoNumberSize).isEqualTo(givenLottoNumberSize);
    }

    @Test
    void 로또_번호들은_정렬되어야_함() {
        // given
        List<Integer> givenList = List.of(1, 2, 3, 4, 5, 6);
        assertRandomUniqueNumbersInRangeTest(() -> {
            // when
            LottoGeneratorImpl lottoGenerator = new RandomLottoGenerator();
            List<Integer> generatedList = lottoGenerator.generate();
            // then
            assertThat(generatedList).isEqualTo(givenList);
        }, List.of(6, 5, 4, 3, 2, 1));
    }
}
