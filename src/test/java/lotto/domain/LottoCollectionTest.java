package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoCollectionTest {
    @DisplayName("from은 로또 리스트를 받아서 로또 컬렉션 객체를 생성한다")
    @Test
    void check_from() {
        List<Lotto> lottos = List.of(new Lotto(List.of(1,2,3,4,5,6)), new Lotto(List.of(7,8,9,10,11,12)));
        assertThat(LottoCollection.from(lottos))
                .isInstanceOf(LottoCollection.class);
        assertThat(LottoCollection.from(lottos).getLottoCollection())
                .hasSize(lottos.size())
                .allSatisfy(lotto -> assertThat(lotto).isInstanceOf(Lotto.class));
    }
}
