package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

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

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 숫자 비교 및 보너스 번호 유무 정상 출력 확인")
    @ParameterizedTest
    @MethodSource("listProvider")
    void checkNumberAndBonusNumber(List<Integer> argument) {
        List<Integer> validTest = Arrays.asList(5, 6, 10, 11, 22, 33);
        Lotto having = new Lotto(argument);
        Lotto answer = new Lotto(validTest);

        assertThat(having.checkNumber(answer)).isEqualTo(2);
        assertThat(having.checkBonus(10)).isFalse();
    }

    static Stream<List<Integer>> listProvider() {
        return Stream.of(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(1, 2, 3, 33, 5, 8));
    }
}