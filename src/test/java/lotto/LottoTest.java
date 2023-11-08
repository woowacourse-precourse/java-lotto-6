package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.LottoGenerator;
import lotto.utils.FixNumberGenerator;
import lotto.utils.NumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 몇_개의_숫자가_일치하는지_테스트() {
        //given
        int buyPrice = 1000;
        LottoGenerator lottoGenerator = new LottoGenerator();
        NumberGenerator numberGenerator = new FixNumberGenerator();
        Lotto lotto = new Lotto(numberGenerator.generateNumber());
        List<Integer> winningList = List.of(1, 2, 3, 4, 5, 45);
        //when
        int count = lotto.checkNumbers(winningList);
        //then
        assertThat(count).isEqualTo(5);
    }

}