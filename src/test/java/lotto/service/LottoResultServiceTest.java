package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import lotto.domain.PurchasedLotto;
import lotto.dto.LottoResultDto;
import lotto.dto.WinningLottoDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultServiceTest {
    @DisplayName("로또 결과가 정확히 나오면 통과")
    @Test
    void success() {
        // give
        LottoResultService lottoResultService = new LottoResultService();
        HashSet<PurchasedLotto> purchasedLotto = new HashSet<>();

        List<Integer> purchasedNumbers1 = List.of(1,2,3,4,5,6);
        List<Integer> purchasedNumbers2 = List.of(1,2,3,10,11,12);
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);
        int bonusNumber = 10;

        purchasedLotto.add(new PurchasedLotto(purchasedNumbers1));
        purchasedLotto.add(new PurchasedLotto(purchasedNumbers2));
        WinningLottoDto dto = new WinningLottoDto(winningNumbers, bonusNumber);

        // when
        LottoResultDto lottoResultDto = lottoResultService.generateLottoResult(purchasedLotto, dto,
                purchasedLotto.size());

        // then
        assertThat(lottoResultDto.firstPrizeCount()).isEqualTo(1);
        assertThat(lottoResultDto.secondPrizeCount()).isEqualTo(0);
        assertThat(lottoResultDto.thirdPrizeCount()).isEqualTo(0);
        assertThat(lottoResultDto.fourthPrizeCount()).isEqualTo(0);
        assertThat(lottoResultDto.fifthPrizeCount()).isEqualTo(1);
    }
}