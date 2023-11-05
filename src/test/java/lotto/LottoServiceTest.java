package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {

    @Test
    @DisplayName("금액을 입력받으면 구입한 로또의 갯수를 반환")
    void lottoCount() {
        LottoService lottoService = new LottoService();
        int lottoCount = lottoService.lottoCount(10000);
        Assertions.assertThat(10).isEqualTo(lottoCount);
    }

    @Test
    @DisplayName("랜덤한 6자리 숫자를 생성")
    void randomNumber() {
        LottoService lottoService = new LottoService();
        List<Integer> randomNumber = lottoService.randomNumber();

        Assertions.assertThat(6).isEqualTo(randomNumber.size());
    }

    @Test
    @DisplayName("입렵받은 갯수만큼 로또를 발행")
    void lottoIssuance() {
        LottoService lottoService = new LottoService();
        List<Lotto> lottos = lottoService.lottoIssuance(3);

        Assertions.assertThat(3).isEqualTo(lottos.size());
        for (int i = 0; i < lottos.size(); i++) {
            Assertions.assertThat(lottos.get(i)).isInstanceOf(Lotto.class);
        }
    }

}