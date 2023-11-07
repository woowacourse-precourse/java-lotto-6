package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("로또 번호의 숫자 범위가 1~45를 벗어나면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({"0,1,2,3,4,5", "41,42,43,44,45,46"})
    void creatLottoByOutOfScopeNumber(String value) {
        List<Integer> list = Arrays.asList(value.split(","))
                .stream()
                .map(token -> Integer.valueOf(token))
                .collect(Collectors.toList());

        assertThatThrownBy(() -> new Lotto(list))
                .isInstanceOf(IllegalArgumentException.class);
    }
}