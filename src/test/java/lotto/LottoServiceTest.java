package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {

    @Test
    @DisplayName("금액을 입력받으면 구입한 로또의 갯수를 반환")
    void lottoCount() {
        LottoService lottoService = new LottoService();
        int lottoCount = lottoService.lottoCount(10000);
        Assertions.assertThat(10).isEqualTo(lottoCount);
    }
}