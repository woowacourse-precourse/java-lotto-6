package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 23, 45})
    @DisplayName("1 부터 45 사이의 숫자를 넣어 LottoNumber를 생성할 수 있다")
    void createLottoNumberValidTest(int number) {
        LottoNumber lottoNumber = new LottoNumber(number);

        assertThat(lottoNumber.number()).isEqualTo(number);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("LottoNumber 생성시 입력 숫자가 1보다 작거나 45보다 큰 경우 예외를 발생시킨다")
    void createLottoNumberInvalidTest(int number) {

        assertThatThrownBy(() -> new LottoNumber(number))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("LottoNumber는 1에서 45 사이의 무작위 숫자를 정해진 갯수만큼 생성할 수 있다.")
    void createRandomLottoNumberTest() {
        Set<LottoNumber> randomLottoNumbers = LottoNumber.createRandomLottoNumbers(6);
        LottoNumber randomLottoNumber = randomLottoNumbers.stream()
            .findAny()
            .get();

        assertAll(
            () -> assertThat(randomLottoNumbers.size()).isEqualTo(6),
            () -> assertThat(randomLottoNumber.number()).isGreaterThanOrEqualTo(1),
            () -> assertThat(randomLottoNumber.number()).isLessThanOrEqualTo(45)
        );
    }

    @Test
    @DisplayName("LottoNumber는 가지고 있는 숫자에 따라 다른 객체로 인식된다.")
    void compareLottoNumberTest() {
        int lottoRangeStart = 1;
        int lottoRangeEnd = 45;

        Set<LottoNumber> lottoNumbers = IntStream.rangeClosed(lottoRangeStart, lottoRangeEnd)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toSet());

        assertThat(lottoNumbers.size())
            .isEqualTo(lottoRangeEnd - lottoRangeStart + 1);
    }
}
