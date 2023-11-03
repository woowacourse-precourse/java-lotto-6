package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class LottoPurchaseMachineTest {

    LottoPurchaseMachine lottoPurchaseMachine = new LottoPurchaseMachine();

    @Test
    void 로또_구입_금액_만큼_로또_발행하기() {
        //given
        int purchaseAmount = Randoms.pickNumberInRange(1, 100) * 1000;
        //when
        ArrayList<Lotto> lottos = lottoPurchaseMachine.publishLottoTicket(purchaseAmount);
        //then
        assertThat(lottos.size()).isEqualTo(purchaseAmount / 1000);
    }

}