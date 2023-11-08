package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.assertj.core.api.Assertions.*;


class RandomGeneratorTest {
    @DisplayName("로또 자동 생성기 갯수 테스트")
    @Test
    void lottoListSizeTest(){
        //given
        final RandomGenerator randomGenerator = new RandomGenerator();

        //when
        randomGenerator.generate();

        //then
        List<Integer> numList = randomGenerator.getNumList();
        assertThat(numList.stream().distinct().count()).isEqualTo(6);

    }

    @DisplayName("로또 범위 테스트")
    @Test
    void lottoRangeTest(){
        //given
        final RandomGenerator randomGenerator = new RandomGenerator();

        //when
        randomGenerator.generate();

        //then
        List<Integer> numList = randomGenerator.getNumList();
        assertThat(numList.stream().allMatch(number -> number >= 1 && number <= 45)).isTrue();
    }
}