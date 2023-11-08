package lotto.util;

import java.util.List;
import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static lotto.util.Constant.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

    private final Generator lottoGenerator = new Generator();

    @DisplayName("입력한 금액에 맞는 로또를 생성한다.")
    @Test
    void generateLottoNumbers() {
        int purchasedAmount = 8000;
        List<Lotto> lottoList = lottoGenerator.generateLottoNumbers(purchasedAmount);

        assertThat(lottoList.size()).isEqualTo(purchasedAmount / LOTTO_PRICE);
    }
}