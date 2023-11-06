package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

public class WinningLottoTest {

    @ParameterizedTest
    @DisplayName("당첨 로또 번호를 쉼표로 구분지어 받아 리스트로 반환")
    @ValueSource(strings = {"1,2,3,4,5,6"})
    void inputLottoCommaToList(String inputLotto) {
        List<Integer> winningLotto = Arrays.stream(inputLotto.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();

        Assertions.assertThat(winningLotto.size()).isEqualTo(6);
    }
}
