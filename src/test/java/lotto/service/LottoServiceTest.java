package lotto.service;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoMatchCount;
import lotto.model.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {

    @Test
    @DisplayName("Lottos 객체를 생성한다.")
    void create() {
        //given
        String price = "14000";

        //when
        Lottos newLottos = LottoService.create(price);

        //then
        assertThat(newLottos.getLottoLength()).isEqualTo(14);
    }

    @Test
    @DisplayName("LottoMatchCount 객체를 생성한다.")
    void checkTotalMatchCount() {
        //given
        Lottos randomLottos = LottoService.create("14000");
        BonusNumber bonusNumber = new BonusNumber(7);
        Lotto winningLotto = new Lotto(List.of(1,2,3,4,5,6));
        //when
        Object newLottoMatchCount = LottoService.checkTotalMatchCount(randomLottos, bonusNumber, winningLotto);
        //then
        assertThat(newLottoMatchCount).isInstanceOf(LottoMatchCount.class);
    }
}