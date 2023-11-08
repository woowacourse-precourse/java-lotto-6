package lotto;

import lotto.Generator.NumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

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

    @DisplayName("오름차순 정렬 테스트")
    @Test
    void 리스트_오름차순_정렬() {

        Assertions.assertThat(lotto.sortNumber(lotto.getNumbers())).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("로또 번호는 1부터 45 사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void createLottoByoverNumberRange() {
        NumberGenerator numberGenerator = new NumberGenerator();
        Assertions.assertThat(numberGenerator.makeRandomNumber()).allSatisfy(numbers -> Assertions.assertThat(numbers).isBetween(1, 45));
    }
    // 아래에 추가 테스트 작성 가능
}