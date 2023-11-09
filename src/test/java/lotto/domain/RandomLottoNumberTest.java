package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RandomLottoNumberTest {
    RandomLottoNumber randomLottoNumber;
    static final int LOTTO_NUMBER_SIZE = 6;

    @BeforeEach
    void initRandomLottoNumber() {
        randomLottoNumber = new RandomLottoNumber();
        randomLottoNumber.initRandomNumber();
    }

    @DisplayName("로또 번호가 중복 없이 무작위로 생성되는지 확인")
    @Test
    void createRandomLottoNumber() {
        List<Integer> LottoNumber = randomLottoNumber.getNumbers();
        Set<Integer> setLottoNumber = LottoNumber.stream().collect(Collectors.toSet());
        assertThat(setLottoNumber.size()).isEqualTo(LOTTO_NUMBER_SIZE);
    }
}