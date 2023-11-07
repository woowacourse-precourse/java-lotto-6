package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberGeneratorTest {

    static final int LOTTO_PRICE = 1000;
    static final LottoNumberGenerator lottoNumberGenerator = LottoNumberGenerator.getInstance();

    @Test
    @DisplayName("로또 구입 금액이 1000원 단위일 경우 로또 번호 생성")
    void createLottoNumbers() {
        int money = 5000;

        List<LottoNumber> lottoNumbers = lottoNumberGenerator.createLottoNumbers(money);

        assertThat(lottoNumbers).hasSize(money / LOTTO_PRICE);
    }

    @Test
    @DisplayName("로또 구입 금액이 1000원 단위가 아닐 경우 예외 발생")
    void throwExceptionWhenMoneyCannotDividedBy1000() {
        int money = 1500;

        Assertions.assertThrows(IllegalArgumentException.class, () -> lottoNumberGenerator.createLottoNumbers(money));
    }
}