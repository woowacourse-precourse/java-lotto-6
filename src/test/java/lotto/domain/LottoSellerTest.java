package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoSellerTest {

    @Test
    @DisplayName("돈을 주면 로또 뭉치를 팔 수 있다.")
    void sell_lotto_bundle() {
        // given
        int fee = 4000;
        LottoSeller lottoSeller = new LottoSeller(new LottoMachine(
                (startInclusive, endInclusive, count) -> Arrays.asList(1, 2, 3, 4, 5, 6)));

        // when
        LottoBundle lottoBundle = lottoSeller.sell(fee);

        // then
        assertThat(lottoBundle).isEqualTo(
                new LottoBundle(
                        Arrays.asList(
                                Arrays.asList(1, 2, 3, 4, 5, 6),
                                Arrays.asList(1, 2, 3, 4, 5, 6),
                                Arrays.asList(1, 2, 3, 4, 5, 6),
                                Arrays.asList(1, 2, 3, 4, 5, 6))
                )
        );
    }
}
