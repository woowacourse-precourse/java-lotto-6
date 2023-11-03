package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RandomNumbersTest {

    @Test
    void 랜덤_숫자를_생성하는_기능_테스트() {
        //given
        RandomNumber randomNumber = new RandomNumber();

        //when
        List<Integer> randomNumbers = randomNumber.generateLottoNumbers();

        //then
        Assertions.assertThat(randomNumbers).isNotEmpty();
    }
}
