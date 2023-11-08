package lotto.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class RandomNumbersGeneratorTest {

    RandomNumbersGenerator randomNumbersGenerator =new RandomNumbersGenerator();

    @DisplayName("랜덤 넘버 정상 발행 테스트")
    @Test
    void TestRandomNumbersGenerator(){
        assertThat(randomNumbersGenerator.generate().size()).isEqualTo(6);
    }
}