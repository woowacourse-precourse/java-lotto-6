package lotto.util;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import lotto.model.Lotto;
import org.junit.jupiter.api.Test;

public class RandomLottoGeneratorTest {

    @Test
    void RandomLottoGenerator로_Lotto를_생성할_수_있다() {
        //given
        RandomLottoGenerator lottoGenerator = new RandomLottoGenerator();

        //when
        Lotto lotto = lottoGenerator.generate();

        //then
        assertNotNull(lotto);
    }

    @Test
    void RandomLottoGenerator로_Lotto를_생성할_수_있다2() {
        List<Integer> randomUniqueNumbers = List.of(8, 21, 23, 41, 42, 43);

        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    //given
                    RandomLottoGenerator lottoGenerator = new RandomLottoGenerator();
                    Lotto expected = new Lotto(randomUniqueNumbers);

                    //when
                    Lotto lotto = lottoGenerator.generate();

                    //then
                    assertEquals(expected, lotto);
                },
                randomUniqueNumbers
        );
    }
}
