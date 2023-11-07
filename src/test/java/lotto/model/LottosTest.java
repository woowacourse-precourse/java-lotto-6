package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.Lotto;
import lotto.Lottos;
import lotto.utils.FixNumberGenerator;
import lotto.utils.NumberGenerator;
import org.junit.jupiter.api.Test;

public class LottosTest {

    @Test
    void 로또_당첨을_확인하는_기능_테스트() {
        //given
        int buyPrice = 1000;
        LottoGenerator lottoGenerator = new LottoGenerator();
        NumberGenerator numberGenerator = new FixNumberGenerator();
        List<Lotto> lottoList = lottoGenerator.generate(buyPrice, numberGenerator);
        List<Integer> winningList = List.of(1, 2, 3, 4, 5, 45);
        //when
        int count = Lottos.checkNumbers(lottoList, winningList);
        //then
        assertThat(count).isEqualTo(5);
    }
}
