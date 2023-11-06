package lotto.model;


import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("랜덤_로또_생성기_테스트")
class RandomLottoGeneratorTest {

    @Test
    @DisplayName("랜덤_로또_생성_테스트")
    void generate() {
        RandomLottoGenerator lottoGenerator = new RandomLottoGenerator();
        List<Integer> randomNums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertRandomUniqueNumbersInRangeTest(
                ()->{
                    Lotto lotto = lottoGenerator.generate();
                    assertThat(lotto.getNumbers()).isEqualTo(randomNums);
                },
                randomNums
        );

    }

}