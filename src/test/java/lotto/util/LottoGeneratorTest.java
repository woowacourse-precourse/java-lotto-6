package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.List;

import static lotto.constants.Constants.Integers.MAX_LOTTO_NUMBER;
import static lotto.constants.Constants.Integers.MIN_LOTTO_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    @DisplayName("로또 번호 발행하는 기능 30회 반복 후 범위 내에 숫자가 있는지 확인")
    @RepeatedTest(30)
    public void generateLotto_repeat30_inRange() throws Exception {
        //given
        List<Integer> numbers = LottoGenerator.generateLottoNumbers();

        //when, then
        assertThat(numbers).allMatch((number) ->
                MIN_LOTTO_NUMBER.getValue() <= number && number <= MAX_LOTTO_NUMBER.getValue()
        );
     }
}
