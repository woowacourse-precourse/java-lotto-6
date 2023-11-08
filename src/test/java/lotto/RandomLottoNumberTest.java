package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.RandomLottoNumber.randLottoNumbers;

public class RandomLottoNumberTest {
    @DisplayName("로또가 제대로 생성되는지 확인")
    @Test
    void randLottoNumbersTest(){
        int lottoChance = 2;
        ArrayList<List<Integer>> randomLotto = randLottoNumbers(lottoChance);

        Assertions.assertThat(randomLotto.size()).isEqualTo(2);
        Assertions.assertThat(randomLotto.get(0).size()).isEqualTo(6);
    }
}
