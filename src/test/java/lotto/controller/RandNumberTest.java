package lotto.controller;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.controller.RandNumber.randomLottoNumber;

public class RandNumberTest {

    @Test
    @DisplayName("로또 번호 6개 생성")
    void createLottoNumberTest() {
        RandNumber randNumber = new RandNumber();
        List<Integer> numbers = randomLottoNumber();
        Assertions.assertThat(numbers.size()).isEqualTo(6);
    }
}
