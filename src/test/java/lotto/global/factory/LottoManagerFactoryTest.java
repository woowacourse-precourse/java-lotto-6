package lotto.global.factory;

import lotto.module.manager.LottoManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoManagerFactoryTest {

    @Test
    void Lotto_Manager_싱글톤_생성_성공_테스트() {
        // given
        LottoManager lottoManager1 = LottoManagerFactory.getSingletonLottoManager();
        LottoManager lottoManager2 = LottoManagerFactory.getSingletonLottoManager();
        LottoManager lottoManager3 = LottoManagerFactory.getSingletonLottoManager();
        LottoManager lottoManager4 = LottoManagerFactory.getSingletonLottoManager();

        // when
        // then
        Assertions.assertThat(lottoManager1)
                .isSameAs(lottoManager2)
                .isSameAs(lottoManager3)
                .isSameAs(lottoManager4);
    }
}