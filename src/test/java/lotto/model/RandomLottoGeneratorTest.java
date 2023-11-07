package lotto.model;


import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("랜덤_로또_생성기_테스트")
class RandomLottoGeneratorTest {

    @Test
    @DisplayName("랜덤_로또_생성_테스트")
    void generate() {
        RandomLottoGenerator lottoGenerator = new RandomLottoGenerator();
        List<Integer> nums = List.of(6, 5, 4, 3, 2, 1);
        List<Integer> expectedNums = new ArrayList<>(nums);
        Collections.sort(expectedNums);

        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    Lotto lotto = lottoGenerator.generate();
                    assertThat(lotto.getNumbers()).isEqualTo(expectedNums);
                },
                nums
        );

    }

}