package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    private static LottoGenerator lottoGenerator = new LottoGenerator();
    @RepeatedTest(1000)
    void generate_반복수행시_범위1_45내로_생성된다(){
        // when
        List<Integer> numbers = lottoGenerator.generate();
        // then
        for(int number : numbers){
            assertThat(number).isBetween(1, 45);
        }
    }
}