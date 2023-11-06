package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketsTest {

    @Test
    @DisplayName("로또 당첨 결과 확인")
    void resultOfLottoTickets() {
        WinningNumbers winningNumbers = new WinningNumbers(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);
        List<LottoNumbers> lottoNumbers = new ArrayList<>();

        lottoNumbers.add(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoNumbers.add(new LottoNumbers(Arrays.asList(2, 3, 4, 5, 6, 7)));
        lottoNumbers.add(new LottoNumbers(Arrays.asList(3, 4, 5, 6, 7, 8)));
        lottoNumbers.add(new LottoNumbers(Arrays.asList(8, 9, 10, 11, 12, 13)));
        lottoNumbers.add(new LottoNumbers(Arrays.asList(1, 9, 10, 11, 12, 13)));

        LottoTickets lottoTickets = new LottoTickets(lottoNumbers);

        List<LottoResult> lottoResults = lottoTickets.resultOfLottoTickets(winningNumbers);

        assertAll(() -> {
            Assertions.assertThat(lottoResults.get(0).matchCount()).isEqualTo(6);
            Assertions.assertThat(lottoResults.get(0).bonusMatchCount()).isEqualTo(0);

            Assertions.assertThat(lottoResults.get(1).matchCount()).isEqualTo(5);
            Assertions.assertThat(lottoResults.get(1).bonusMatchCount()).isEqualTo(1);

            Assertions.assertThat(lottoResults.get(2).matchCount()).isEqualTo(4);
            Assertions.assertThat(lottoResults.get(2).bonusMatchCount()).isEqualTo(1);

            Assertions.assertThat(lottoResults.get(3).matchCount()).isEqualTo(0);
            Assertions.assertThat(lottoResults.get(3).bonusMatchCount()).isEqualTo(0);

            Assertions.assertThat(lottoResults.get(4).matchCount()).isEqualTo(1);
            Assertions.assertThat(lottoResults.get(4).bonusMatchCount()).isEqualTo(0);
        });

    }
}