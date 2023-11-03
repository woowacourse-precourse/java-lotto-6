package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.controller.RandNumber.*;

public class RandNumberTest {
    @DisplayName("랜덤 넘버 6개 뽑기")
    @Test
    void createRandomNumberTest() {
        List<Integer> numbers =makeRandNumber();
        Assertions.assertThat(numbers.size()).isEqualTo(6);
    }

    @DisplayName("보너스 넘버 1개 뽑기")
    @Test
    void createRandomBonusNumberTest() {
        List<Integer> bonusNumber = makeBonusNumber();
        Assertions.assertThat(bonusNumber.size()).isEqualTo(1);
    }

    @DisplayName("랜덤 넘버와 보너스 넘버가 중복되는지 확인")
    @Test
    void checkDuplicateTest() {
        List<Integer> lottoNumber = new ArrayList<>();
        lottoNumber.add(1);
        lottoNumber.add(2);
        List<Integer> bonusNumber = new ArrayList<>();
        bonusNumber.add(1);

        Assertions.assertThat(checkDuplicate(lottoNumber, bonusNumber)).isEqualTo(false);
    }

    @DisplayName("랜덤 넘버와 보너스 넘버가 중복되는지 확인")
    @Test
    void checkNotDuplicateTest() {
        List<Integer> lottoNumber = new ArrayList<>();
        lottoNumber.add(1);
        lottoNumber.add(2);
        List<Integer> bonusNumber = new ArrayList<>();
        bonusNumber.add(3);

        Assertions.assertThat(checkDuplicate(lottoNumber, bonusNumber)).isEqualTo(true);
    }

    @DisplayName("중복된 숫자가 나오지 않을 때까지 계속 보너스 숫자 뽑기")
    @Test
    void reMakeBonusNumberTest() {
        List<Integer> lottoNumber = new ArrayList<>();
        lottoNumber.add(1);
        lottoNumber.add(2);
        List<Integer> bonusNumber = new ArrayList<>();
        bonusNumber.add(1);

        List<Integer> resultBonusNumber = reMakeBonusNumber(lottoNumber, bonusNumber);
        System.out.println(resultBonusNumber.get(0));
        Assertions.assertThat(resultBonusNumber.get(0)).isNotEqualTo(1);
    }

}
