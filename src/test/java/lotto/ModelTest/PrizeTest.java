package lotto.ModelTest;

import lotto.model.PrizeLotto;
import lotto.model.PrizeMoney;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTest {
    PrizeLotto prizeLotto = new PrizeLotto(List.of(1,2,3,4,5,6),7);

    @DisplayName("당첨 번호 잘 들어갔는지 확인")
    @Test
    void matchPrizeLottoNum() {
        assertThat(prizeLotto.getPrizeNumbers()).contains(1,2,3,4,5,6);
    }

    @DisplayName("보너스 번호 잘 들어갔는지 확인")
    @Test
    void matchPrizeBonusNum() {
        assertThat(prizeLotto.getBonusNum()).isEqualTo(7);
    }

}
