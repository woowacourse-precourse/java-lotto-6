package lotto.model;

import lotto.service.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottosTest {

    @Test
    @DisplayName("Lottos 객체의 길이를 반환한다.")
    void getLottoLength() {
        // given
        String price = "10000";
        Lottos newLottos = LottoService.create(price);

        //  when
        Integer lottoLength = newLottos.getLottoLength();

        // then
        assertEquals(10, lottoLength);
    }

    @Test
    @DisplayName("Lottos 객체를 반환한다.")
    void getLottos() {

        // given
        String price = "10000";
        Lottos newLottos = LottoService.create(price);

        // when & then
        assertThat(newLottos.getLottoInfoList()).isInstanceOf(java.util.ArrayList.class);
    }

    @Test
    @DisplayName("Lottos 객체를 문자열로 반환한다.")
    void testToString() {

        // given
        String price = "10000";
        Lottos newLottos = LottoService.create(price);

        // when
        String lottosString = newLottos.toString();
        StringBuilder expected = new StringBuilder();
        for(int i = 0; i < 10; i++){
            expected.append("[").append(newLottos.getLottoInfoList().get(i).getLotto().toString()).append("]\n");
        }

        // then
        assertEquals(expected.toString(), lottosString);
    }
}