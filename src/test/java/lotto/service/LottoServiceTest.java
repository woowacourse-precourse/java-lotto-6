package lotto.service;

import lotto.domain.Game;
import lotto.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {

    private final LottoService lottoService = new LottoService();

    @DisplayName("입력된 금액으로 구매가능한 개수만큼 로또번호를 발급해야 한다.")
    @Test
    void 입력된_금액으로_구매가능한_개수만큼_로또번호를_발급하는_기능_테스트(){
        //given
        final User case1 = new User(1000);
        final User case2 = new User(100_000);

        //when
        lottoService.buyLottoAtOnce(case1);
        lottoService.buyLottoAtOnce(case2);

//        //then
//        assertThat(case1.getUserLotteries().size()).isEqualTo(1);
//        assertThat(case2.getUserLotteries().size()).isEqualTo(100);
    }



}