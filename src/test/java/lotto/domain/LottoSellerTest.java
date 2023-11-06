package lotto.domain;

import lotto.constant.Value;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoSellerTest {

    @DisplayName("셀러__로또_하나_정렬상태_테스트")
    @Test
    void issueOneLottoTest() {
        LottoSeller seller = LottoSeller.create();
        Lotto lotto = seller.issueLotto();

        Assertions.assertThat(lotto.getNumbers()).isSorted();
    }

    @DisplayName("셀러__로또_판매_개수_테스트")
    @Test
    void sellLottoTest() {
        int money = 6000;

        LottoSeller seller = LottoSeller.create();
        List<Lotto> lottos = seller.sellLottos(money);

        int answerCount = money / Value.THOUSAND.get();
        Assertions.assertThat(lottos.size()).isEqualTo(answerCount);
    }
}