package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class LottoTest {

    @Test
    void validateTest() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        Assertions.assertDoesNotThrow(() -> new Lotto(numbers));
    }

    @Test
    void numberOrderTest() {
        //given
        List<Integer> numbers = new ArrayList<>(new ArrayList<>(Arrays.asList(3, 4, 2, 6, 5, 1)));

        //when
        Lotto lotto = new Lotto(numbers);

        //then
        org.assertj.core.api.Assertions.assertThat(numbers.get(0)).isEqualTo(1);
        org.assertj.core.api.Assertions.assertThat(numbers.get(3)).isEqualTo(4);
        org.assertj.core.api.Assertions.assertThat(numbers.get(5)).isEqualTo(6);
    }

    @Test
    void printNumbersTest() {
        //given
        List<Integer> numbers = new ArrayList<>(Arrays.asList(13, 24, 32, 36, 40, 41));

        //when
        Lotto lotto = new Lotto(numbers);
        String lottoNumbers = lotto.toString();

        //then
        org.assertj.core.api.Assertions.assertThat(lottoNumbers).isEqualTo("13, 24, 32, 36, 40, 41");
    }
}