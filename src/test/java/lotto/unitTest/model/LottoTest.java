package lotto.unitTest.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest
    @CsvSource(value = {
            "1, true",
            "2, true",
            "3, true",
            "4, true",
            "5, true",
            "6, true",
            "7, false",
    })
    void 로또가_숫자를_포함하면_true_포함하지_않으면_false를_반환한다(int number, boolean result) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto.contains(number)).isEqualTo(result);
    }

    @Test
    void 오름차순으로_정렬된_로또_번호들을_보여준다() {
        Lotto lotto = new Lotto(Arrays.asList(6, 5, 4, 3, 2, 1));

        assertThat(lotto.showNumbers()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    void 다른_로또와_중복되는_번호들의_개수를_계산한다() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto otherLotto = new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9));

        assertThat(lotto.countMatchOtherLotto(otherLotto)).isEqualTo(3);
    }
}