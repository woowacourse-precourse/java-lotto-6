package model;


import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;

import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class RandomLottoTest {

    private static RandomLotto randomLotto;

    @BeforeAll
    static void setUp() {
        randomLotto = new RandomLotto();
    }

    @Test
    public void createRandomLottoTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    assertThat(randomLotto.createRandomLotto()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
    }
}