package lotto.domain;

import static lotto.constant.testConstant.LOTTO_1_TO_6;
import static lotto.constant.testConstant.LOTTO_7_TO_12;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.constant.testConstant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoCollectionTest {
    List<Lotto> lottos = List.of(LOTTO_1_TO_6, LOTTO_7_TO_12);

    @DisplayName("from은 로또 리스트를 받아서 로또 컬렉션 객체를 생성한다")
    @Test
    void check_from() {
        assertThat(LottoCollection.from(lottos)).isInstanceOf(LottoCollection.class);

        assertThat(LottoCollection.from(lottos).getLottoCollection())
                .hasSize(lottos.size())
                .allSatisfy(lotto -> assertThat(lotto).isInstanceOf(Lotto.class));
    }

    @DisplayName("getResultGroup은 각 로또별 비교 결과를 받아서 리스트로 담는다")
    @Test
    void check_getResultGroup() {
        LottoCollection lottoCollection = LottoCollection.from(List.of(LOTTO_1_TO_6, LOTTO_7_TO_12));
        Lotto winningLotto = new Lotto(List.of(1, 2, 7, 41, 42, 43));
        int bonusNumber = 8;
        List<LottoResult> resultGroup = lottoCollection.getResultGroup(winningLotto, bonusNumber);
        assertThat(resultGroup).containsExactly(LottoResult.of(2, false)
                , LottoResult.of(1, true));
    }
}
