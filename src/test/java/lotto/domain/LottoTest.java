package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 toString() 테스트")
    @Test
    void lottoToString() {
        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6)).toString())
                .isEqualTo("1, 2, 3, 4, 5, 6");
    }

    @DisplayName("일치하는 로또 번호의 개수를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:6", "1,2,3,4,5,7:5", "1,2,3,4,8,7:4", "1,2,3,7,8,9:3"}, delimiter = ':')
    void matchNumbers(String numbers, int expected) {
        List<Integer> lottoNumbers = Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .toList();
        Lotto lotto = new Lotto(lottoNumbers);
        assertThat(lotto.matchNumbers(new LottoNumber(List.of(1, 2, 3, 4, 5, 6)))).isEqualTo(expected);
    }

    @DisplayName("보너스 번호가 일치하는지 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:7:false", "1,2,3,4,5,6:6:true"}, delimiter = ':')
    void matchBonusNumber(String numbers, int bonusNumber, boolean expected) {
        List<Integer> lottoNumbers = Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .toList();
        Lotto lotto = new Lotto(lottoNumbers);
        assertThat(lotto.containsBonusNumber(bonusNumber)).isEqualTo(expected);
    }
}