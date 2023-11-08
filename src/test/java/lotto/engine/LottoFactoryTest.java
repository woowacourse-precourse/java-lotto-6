package lotto.engine;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.engine.domain.Lotto;
import lotto.engine.manager.LottoFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoFactoryTest {
    LottoFactory lottoFactory;

    @BeforeEach
    void setUp() {
        lottoFactory = new LottoFactory();
    }

    @DisplayName("요청한 갯수만큼 정렬된 로또들을 발행한다.")
    @ParameterizedTest(name = "[{index}차]시도: quantity: {0}")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void testIssueLotto(int quantity) {
        //given
        //when
        List<Lotto> lottos = lottoFactory.issueLotto(quantity);
        //then
        assertThat(lottos).hasSize(quantity);
    }

    @Test
    @DisplayName("로또 발행 내역을 보여준다.")
    void testShowTotalLotto() {
        //given
        Lotto lottoA = new Lotto(List.of(10, 20, 30, 31, 32, 33));
        Lotto lottoB = new Lotto(List.of(3, 7, 11, 14, 43, 44));
        List<Lotto> lottos = List.of(lottoA, lottoB);
        //when
        String issuedLottos = lottoFactory.showTotalLotto(lottos);
        //then
        assertThat(issuedLottos).contains("[", "]", ",","\n");
    }


}