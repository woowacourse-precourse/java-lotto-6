package lotto.global;

import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PublishTest {

    @DisplayName("로또 발행 개수 맞는지 확인")
    @Test
    void getLottoCount() {
        Publish publish = new Publish();
        int money = 5000;
        int actualCount = publish.getLottoCount(money);
        int expectedCount = 5;

        assertThat(expectedCount).isEqualTo(actualCount);
    }

    @DisplayName("발행 개수만큼 로또 발행했는지 확인")
    @Test
    void getIssuedLottoList() {
        Publish publish = new Publish();
        List<Lotto> issuedLottoList = publish.getIssuedLottos(3);
        int actualSize = issuedLottoList.size();
        int expectedSize = 3;

        assertThat(expectedSize).isEqualTo(actualSize);
    }
}