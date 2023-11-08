package lotto.core.numbergenerator;

import static lotto.core.enums.LottoNumberEnum.END_VALUE;
import static lotto.core.enums.LottoNumberEnum.SIZE;
import static lotto.core.enums.LottoNumberEnum.START_VALUE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {
    @DisplayName("1~45사이 랜덤 번호를 생성한다.")
    @Test
    void createRandomUniqueNumber() {
        //given
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        //when
        List<Integer> randomUniqueNumber = randomNumberGenerator.createRandomUniqueNumber();

        //then
        assertThat(randomUniqueNumber.size()).isEqualTo(SIZE.getValue());
        assertThat(randomUniqueNumber).allMatch(num -> num >= START_VALUE.getValue() && num <= END_VALUE.getValue());
    }
}