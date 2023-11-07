package lotto.service;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class LottoNumberGeneratorTest {

    LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

    @Test
    @DisplayName("생성기는 1부터 45까지의 랜덤한 숫자를 반환한다")
    void 로또숫자생성기_테스트() {
        //given
        Set<Integer> createdNumbers = new HashSet<>();
        int count = 0;

        //when
        while (createdNumbers.size() < 45 && count < 100000) {
            List<Integer> lottoNumbers = lottoNumberGenerator.generate();
            lottoNumbers.forEach(num -> createdNumbers.add(num));
            count++;
        }

        //then
        assertThat(createdNumbers).contains(1, 45);
        assertThat(createdNumbers.size()).isEqualTo(45);
    }

    @RepeatedTest(1000)
    @DisplayName("생성기는 중복 숫자를 생성하지 않는다")
    void 로또숫자생성기_테스트2() {
        //given
        List<Integer> lottoNumbers = lottoNumberGenerator.generate();

        //when
        long count = lottoNumbers.stream().distinct().count();

        //then
        assertThat(count).isEqualTo(lottoNumbers.size());
    }
}
