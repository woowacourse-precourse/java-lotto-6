package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import lotto.domain.PurchasedLotto;
import lotto.domain.WinningLotto;
import lotto.dto.PurchasedLottoDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    @DisplayName("로또 번호 비교후 구매한 로또가 올바른 등수를 가지면 통과")
    @Test
    void success_CompareNumbers() {
        // give
        LottoService lottoService = new LottoService();
        HashSet<PurchasedLotto> purchasedLotto = new HashSet<>();

        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);
        int bonusNumber = 7;
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        List<Integer> purchasedNumbers = List.of(1,2,3,4,5,7);
        purchasedLotto.add(new PurchasedLotto(purchasedNumbers));
        // when
        lottoService.compareNumbers(winningLotto, purchasedLotto);
        PurchasedLottoDto purchasedLottoDto = purchasedLotto.iterator().next().toDto();
        //then
        assertThat(purchasedLottoDto.rank()).isEqualTo(LottoRank.SECOND);
    }
}