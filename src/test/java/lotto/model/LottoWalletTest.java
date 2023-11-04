package lotto.model;

import static lotto.util.TestUtil.createLotto;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoWalletTest {

    @DisplayName("지갑에 로또가 정상적으로 저장된다.")
    @Test
    void successSaveLottoWallet() {
        List<Lotto> lottos = List.of(new Lotto[]{
                createLotto(),
                createLotto()
        });

        LottoWallet wallet = new LottoWallet(lottos);
        assertThat(wallet.getLottos()).isEqualTo(lottos);
    }
}