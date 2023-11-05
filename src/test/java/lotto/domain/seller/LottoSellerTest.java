package lotto.domain.seller;

import lotto.config.Config;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoEnvelop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoSellerTest {
    private LottoSeller lottoSeller;

    @BeforeEach
    void setUp() {
        lottoSeller = new LottoSeller();
    }

    @DisplayName("돈을 받고 로또 봉투를 만든다.")
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 3000, 4000, 5000, 6000})
    void makeLottoEnvelope(Integer money) {
        LottoEnvelop lottoEnvelop = null;

        // when
        lottoSeller.makeLottoEnvelope(money);
        lottoEnvelop = lottoSeller.sell();

        int result = lottoEnvelop.size();
        int targetSizeEnvelop = (money / 1000);

        // than
        assertThat(result).isEqualTo(targetSizeEnvelop);
    }
}