package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

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

    @Test
    @Disabled("랜덤한 6개 숫자 정렬")
    void 랜덤한_6개_숫자_정렬() {
        try (MockedStatic<Randoms> mock = Mockito.mockStatic(Randoms.class)) {
            //given
            List<Integer> mockSixNumbers = Arrays.asList(6, 5, 4, 3, 2, 1);
            mock.when(() -> Randoms.pickUniqueNumbersInRange(anyInt(), anyInt(), anyInt())).thenReturn(mockSixNumbers);

            //when
            List<Integer> sixNumber = randomNumberGenerator.getSixNumber();

            //then
            assertThat(sixNumber.size()).isEqualTo(6);
            assertThat(sixNumber).containsExactly(1, 2, 3, 4, 5, 6);
        }
    }
}