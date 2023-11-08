package lotto.global.factory;

import lotto.module.store.LottoStore;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoStoreFactoryTest {
    @Test
    void Lotto_Store_Factory_싱글톤_생성_성공_테스트() {
        // given
        LottoStore lottoStore1 = LottoStoreFactory.getSingletonLottoStore();
        LottoStore lottoStore2 = LottoStoreFactory.getSingletonLottoStore();
        LottoStore lottoStore3 = LottoStoreFactory.getSingletonLottoStore();
        LottoStore lottoStore4 = LottoStoreFactory.getSingletonLottoStore();

        // when
        // then
        Assertions.assertThat(lottoStore1)
                .isSameAs(lottoStore2)
                .isSameAs(lottoStore3)
                .isSameAs(lottoStore4);
    }

}