package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import lotto.utils.constants.ExceptionMessage;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {
    @Test
    void amountPurchaseDivide_천단위_로또구매금액_나누기() {
        int purchaseInput = 6000;
        int lottoNumber = LottoService.amountPurchaseDivide(purchaseInput);
        assertThat(lottoNumber).isEqualTo(6);
    }

    @Test
    void generateLottoNumbers_로또_번호_생성() {
        int lottoNumber = 3;
        List<Lotto> allLottoNumbers = LottoService.generateLottoNumbers(lottoNumber);
        assertThat(allLottoNumbers).hasSize(3);
        for (Lotto lotto : allLottoNumbers) {
            assertThat(lotto.getNumbers()).hasSize(6);
        }
    }
}