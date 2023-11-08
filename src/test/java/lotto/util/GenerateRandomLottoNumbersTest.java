package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GenerateRandomLottoNumbersTest {

    private static RandomUtils randomUtils = new GenerateRandomLottoNumbers();
    private static List<Integer> lottoNumbers = randomUtils.generateRandomNumbers();

    @DisplayName("generateRandomNumbers() : 숫자 범위는 1~45까지이다.")
    @Test
    void generateRandomNumbers_NumbersRange_Success() throws Exception {
        //given
        final int min = 1;
        final int max = 45;

        //when //then
        assertTrue(lottoNumbers.stream()
                .allMatch(lottoNumber -> lottoNumber >= min && lottoNumber <= max));
    }

    @DisplayName("generateRandomNumbers() : 중복되지 않는 6개의 숫자를 뽑는다.")
    @Test
    void generateRandomNumbers_NumbersDistinct_Success() throws Exception {
        //given
        long distinctCount = lottoNumbers.stream()
                .distinct()
                .count();

        //when //then
        assertEquals(lottoNumbers.size(), distinctCount);
    }

    @DisplayName("generateRandomNumbers() : 번호는 오름차순으로 정렬한다.")
    @Test
    void generateRandomNumbers_NumbersSort_Success() throws Exception {
        //given
        List<Integer> sortedNumbers = new ArrayList<>(lottoNumbers);

        //when
        Collections.sort(sortedNumbers);

        // then
        assertEquals(lottoNumbers, sortedNumbers);
    }
}