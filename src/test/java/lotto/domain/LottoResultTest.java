package lotto.domain;

import static lotto.domain.LottoRank.SECOND;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class LottoResultTest {
    @DisplayName("[Success] 로또 번호와 당첨 금액의 일치하는 개수와, 보너스 번호 일치여부에 맞게 올바른 rank를 찾아 인스턴스를 생성하고 리턴한다.")
    @Test
    void returnExactRank() {
        assertThat(LottoResult.create(5, true).getRank())
                .isEqualTo(SECOND);
    }

    @DisplayName("[Success] 당첨 금액을 올바르게 리턴한다.")
    @Test
    void returnExactPrize() {
        assertThat(LottoResult.create(5, true).getLottoPrize())
                .isEqualTo(SECOND.getPrize());
    }
}
