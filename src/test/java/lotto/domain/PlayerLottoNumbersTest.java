package lotto.domain;

import lotto.domain.lotto.Numbers;
import lotto.domain.lotto.PlayerLottoNumbers;
import lotto.domain.lotto.PurchasePrice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.mock;

@DisplayName("사용자의 생성된 로또들 객체에 대해")
class PlayerLottoNumbersTest {

    private final PurchasePrice purchasePrice = mock(PurchasePrice.class);
    private PlayerLottoNumbers playerLottoNumbers;

    @BeforeEach
    void setUp() {
        playerLottoNumbers = new PlayerLottoNumbers();
    }

    @Test
    @DisplayName("로또 구입 금액에 따라 로또들을 저장한다.")
    void Given_LottoAmountReturn2_When_SaveLottos_Then_hasSize2() {
        //given
        given(purchasePrice.getLottosAmount()).willReturn(2);

        //when
        playerLottoNumbers.saveLottos(purchasePrice);
        List<Numbers> lottoValues = playerLottoNumbers.getLottoValues();

        //then
        assertThat(lottoValues).hasSize(2);
    }

    @Test
    @DisplayName("저장된 로또들 만큼의 로또 가격을 반환한다.")
    void Given_When_Then_() {
        //given
        given(purchasePrice.getLottosAmount()).willReturn(2);
        playerLottoNumbers.saveLottos(purchasePrice);

        //when
        Integer lottosPrice = playerLottoNumbers.getLottosPrice();

        //then
        assertThat(lottosPrice).isEqualTo(2000);
    }
}
