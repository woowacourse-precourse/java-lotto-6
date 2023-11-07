package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoValueTest {

    @Test
    @DisplayName("로또 enum을 통한 당첨금 및 결과 확인")
    void getLottoValueInfoFromEnum() {
        LottoValue lottoValue = LottoValue.getLottoValue(3);
        assert lottoValue != null;
        assertThat(lottoValue.winningMoney).isEqualTo(5000);
        assertThat(lottoValue.result).isEqualTo("3개 일치 (5,000원)");

    }
}
