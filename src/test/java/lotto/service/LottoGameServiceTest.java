package lotto.service;

import lotto.domain.LottoCount;
import lotto.utility.TypeConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static lotto.configuration.InputFormatConfig.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;

class LottoGameServiceTest {
    private LottoGameService lottoGameService = new LottoGameServiceImpl();

    @DisplayName("구입금액에서 로또 가격을 나눈 만큼의 로또 개수를 반환한다.")
    @ParameterizedTest
    @CsvSource({"1000", "3000", "10000", "600000", "7000000"})
    void computeLottoCount(String purchaseAmount) {
        // given
        int money = TypeConverter.convertStringToInt(purchaseAmount);

        // when
        LottoCount lottoCount = lottoGameService.computeLottoCount(purchaseAmount);

        //then
        assertThat(lottoCount.getLottoCount()).isEqualTo(money / LOTTO_PRICE);
    }
}