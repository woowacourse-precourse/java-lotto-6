package lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {


    private RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    @Test
    void generateLottoNumbers() {
        //given
        List<Integer> numbers;
        //when
        numbers = randomNumberGenerator.GenerateLottoNumbers();
        //then
        Assertions.assertThat(numbers).isNotEmpty();
    }

    @Test
    void generateBonusNumber() {
        //given
        List<Integer> bonusNumbers;
        //when
        bonusNumbers = randomNumberGenerator.GenerateBonusNumber();
        //then
        Assertions.assertThat(bonusNumbers).isNotEmpty();

    }
}