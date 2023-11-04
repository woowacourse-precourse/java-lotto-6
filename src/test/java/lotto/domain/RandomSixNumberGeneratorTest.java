package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class RandomSixNumberGeneratorTest {
    private static RandomSixNumberGenerator randomNumberGenerator;

    @BeforeAll
    static void init() {
        randomNumberGenerator = new RandomSixNumberGenerator();
    }

    @RepeatedTest(value = 10, name = "{displayName} 중 {currentRepetition} of {totalRepetitions}")
    @DisplayName("중복없는 6개의 숫자 생성")
    void 중복없는_6개_숫자_생성() {
        //when
        List<Integer> sixNumber = randomNumberGenerator.getSixNumber();

        //then
        assertThat(sixNumber.size()).isEqualTo(6);
        for (Integer number : sixNumber) {
            assertThat(Collections.frequency(sixNumber, number)).isEqualTo(1);
        }
    }

    @RepeatedTest(value = 10, name = "{displayName} 중 {currentRepetition} of {totalRepetitions}")
    @Disabled("1~45 사이의 6개의 숫자 생성")
    void 범위_1부터_45사이의_6개_숫자_생성() {
        //when
        List<Integer> sixNumber = randomNumberGenerator.getSixNumber();

        //then
        assertThat(sixNumber.size()).isEqualTo(6);
        for (Integer number : sixNumber) {
            assertThat(Collections.frequency(sixNumber, number)).isBetween(1, 45);
        }
    }
}