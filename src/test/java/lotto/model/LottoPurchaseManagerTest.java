package lotto.model;

import lotto.system.util.LottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoPurchaseManagerTest {
    @DisplayName("구입 금액에 따른 구입 수량 계산 확인")
    @ParameterizedTest(name = "구입 금액이 {0}원이면 {1}개 구입")
    @CsvSource(value = {"1000:1", "14000:14", "450000:450", "9990000:9990"}, delimiter = ':')
    public void 구입_수량_계산(int purchaseAmount, int expectedPurchaseQuantity) {
        // given
        LottoPurchaseManager lottoPurchaseManager = new LottoPurchaseManager(new LottoNumberGenerator());

        // when
        int calculatePurchaseQuantity = lottoPurchaseManager.calculatePurchaseQuantity(purchaseAmount);

        // then
        assertEquals(expectedPurchaseQuantity, calculatePurchaseQuantity);
    }

    @DisplayName("구입한 로또 용지의 로또 번호 확인")
    @ParameterizedTest(name = "새로운 {0}개의 로또 용지 번호 확인")
    @CsvSource(value = {"25000", "50000"})
    public void 구입한_로또_용지의_로또_번호_확인(int purchaseQuantity) {
        // given
        LottoPurchaseManager lottoPurchaseManager = new LottoPurchaseManager(new LottoNumberGenerator());
        int minLottoNumber = 1;
        int maxLottoNumber = 45;

        // when
        List<LottoPaper> purchasedLottoPapers = lottoPurchaseManager.purchaseLottoPapers(purchaseQuantity);

        // then
        assertAll(
                "구입한 로또 용지 개수 확인과 로또 번호가 1부터 45임을 확인",
                () -> assertEquals(purchaseQuantity, purchasedLottoPapers.size()),
                () -> assertThat(purchasedLottoPapers)
                        .flatExtracting(LottoPaper::getLottoNumbers)
                        .allMatch(number -> number >= minLottoNumber && number <= maxLottoNumber)
        );
    }
}