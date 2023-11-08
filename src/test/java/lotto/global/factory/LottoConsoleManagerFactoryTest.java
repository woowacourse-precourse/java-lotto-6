package lotto.global.factory;

import lotto.module.console.LottoConsoleManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoConsoleManagerFactoryTest {

    @Test
    void Lotto_Console_Manager_싱글톤_생성_성공_테스트() {
        // given
        LottoConsoleManager lottoConsoleManager1 = LottoConsoleManagerFactory.getSingletonLottoConsoleManager();
        LottoConsoleManager lottoConsoleManager2 = LottoConsoleManagerFactory.getSingletonLottoConsoleManager();
        LottoConsoleManager lottoConsoleManager3 = LottoConsoleManagerFactory.getSingletonLottoConsoleManager();
        LottoConsoleManager lottoConsoleManager4 = LottoConsoleManagerFactory.getSingletonLottoConsoleManager();

        // when
        // then
        Assertions.assertThat(lottoConsoleManager1)
                .isSameAs(lottoConsoleManager2)
                .isSameAs(lottoConsoleManager3)
                .isSameAs(lottoConsoleManager4);
    }

}