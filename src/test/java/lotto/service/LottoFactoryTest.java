package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import lotto.model.UserLotto;
import org.junit.jupiter.api.Test;

class LottoFactoryTest {

    @Test
    void 설정한_개수만큼_로또_발행() {
        //given
        int lottoCount = 5;
        //when
        LottoFactory lottoFactory = new LottoFactory();
        UserLotto userLotto = lottoFactory.createLottos(lottoCount);
        //then
        assertEquals(lottoCount, userLotto.size());
    }

}