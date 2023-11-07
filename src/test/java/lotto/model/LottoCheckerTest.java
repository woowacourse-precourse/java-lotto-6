package lotto.model;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoCheckerTest {

    @Test
    void 로또들의_당첨순위들을_계산한다() {
        final List<Lotto> lottos = List.of(
            new Lotto(List.of(1, 2, 3, 4, 5, 11)),
            new Lotto(List.of(1, 2, 3, 7, 11, 12))
        );
        final LottoChecker lottoChecker = new LottoChecker(List.of(1, 2, 3, 4, 5, 6), 7);

        final LottoResult lottoResult = lottoChecker.checkLottos(lottos);

        final String outputString = lottoResult.toOutputString();
        Assertions.assertThat(outputString).contains("3개 일치 (5,000원) - 1개");
        Assertions.assertThat(outputString).contains("4개 일치 (50,000원) - 0개");
        Assertions.assertThat(outputString).contains("5개 일치 (1,500,000원) - 1개");
        Assertions.assertThat(outputString).contains("5개 일치, 보너스 볼 일치 (30,000,000원) - 0개");
        Assertions.assertThat(outputString).contains("6개 일치 (2,000,000,000원) - 0개");
    }

}