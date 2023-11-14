package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BuyerTest {

    @DisplayName("6개의 사용자 로또 발행")
    @Test
    void createRandomLotto() {

        List<Lotto> lottos = IntStream.range(0, 6)
                .mapToObj(i -> new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)))
                .toList();

        Buyer buyer = new Buyer(lottos);

        assertThat(buyer.getLottos()).hasSize(6);
    }
}