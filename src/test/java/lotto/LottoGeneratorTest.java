package lotto;

import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.LottoStorage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {
    @DisplayName("구입금액만큼의 로또를 발행하여 LottoStorage 에 저장한다.")
    @Test
    void generateLottoAtLottoStorage() {

        int purchasePrice = 8000;
        new LottoGenerator(purchasePrice);

        List<Lotto> lottoStorage = LottoStorage.getLotto();

        assertThat(lottoStorage.size()).isEqualTo(purchasePrice / 1000);
    }
}
