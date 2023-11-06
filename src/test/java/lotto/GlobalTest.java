package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class GlobalTest {

    @DisplayName("로또 발행 개수 맞는지 확인")
    @Test
    void getLottoCount() {
        Global global = new Global();
        int money = 5000;
        int lottoCount = global.getLottoCount(money);
        int expectedCount = 5;

        assertThat(lottoCount).isEqualTo(expectedCount);
    }

    @DisplayName("발행 개수만큼 로또 발행했는지 확인")
    @Test
    void getIssuedLottoList() {
        Global global = new Global();
        List<Lotto> issuedLottoList = global.getIssuedLottos(3);
        int listSize = issuedLottoList.size();
        int expectedSize = 3;

        assertThat(listSize).isEqualTo(expectedSize);
    }
}