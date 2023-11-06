package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Collections.frequency;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {

    @Test
    @DisplayName("성공적으로 로또 결과를 가져와야 한다")
    public void 성공적으로_로또_결과를_가져와야_한다() {
        final String expectedResult = String.format(
                "3개 일치 (5,000원) - %d개\n" +
                        "4개 일치 (50,000원) - %d개\n" +
                        "5개 일치 (1,500,000원) - %d개\n" +
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n" +
                        "6개 일치 (2,000,000,000원) - %d개\n" +
                        "총 수익률은 %.1f%%입니다.",
                1,
                0,
                0,
                0,
                0,
                500.0F
        );
        LottoResult lottoResult = new LottoResult();
        Lotto lotto = new Lotto(List.of(1, 3, 5, 14, 22, 45));

        LottoResult getLottoResult = lottoResult.showLottoResult(List.of(1, 2, 3, 4, 5, 6), 7, List.of(lotto));

        assertThat(getLottoResult.toString()).isEqualTo(expectedResult);
    }

}
