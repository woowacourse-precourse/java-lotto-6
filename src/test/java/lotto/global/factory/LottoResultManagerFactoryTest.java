package lotto.global.factory;

import lotto.module.result.LottoResultManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoResultManagerFactoryTest {
    @Test
    void Lotto_Result_Manager_싱글톤_생성_성공_테스트() {
        // given
        LottoResultManager lottoResultManager1 = LottoResultManagerFactory.getSingletonLottoResultManager();
        LottoResultManager lottoResultManager2 = LottoResultManagerFactory.getSingletonLottoResultManager();
        LottoResultManager lottoResultManager3 = LottoResultManagerFactory.getSingletonLottoResultManager();
        LottoResultManager lottoResultManager4 = LottoResultManagerFactory.getSingletonLottoResultManager();

        // when
        // then
        Assertions.assertThat(lottoResultManager1)
                .isSameAs(lottoResultManager2)
                .isSameAs(lottoResultManager3)
                .isSameAs(lottoResultManager4);
    }

}