package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.Lotto;
import lotto.utils.FixNumberGenerator;
import lotto.utils.NumberGenerator;
import org.junit.jupiter.api.Test;

public class LottoTest {

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
