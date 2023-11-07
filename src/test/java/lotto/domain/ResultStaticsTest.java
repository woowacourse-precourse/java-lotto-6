package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ResultStaticsTest {
    ResultStatics statics;
    Lottos lottos;
    LottoResult lottoResult;

    @BeforeEach
    void beforeTestInit() {
        List<Lotto> lottoList = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12)),
                new Lotto(List.of(13, 14, 15, 16, 17, 18))
        );
        lottoResult = new LottoResult(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 8);
        lottos = new Lottos(lottoList);

        statics = lottos.calculateResult(lottoResult);
    }

    @DisplayName("총 수익률은 구매한 로또 금액과 당첨 금액을 나눈 후, 100을 곱한 값이다.")
    @Test
    void calculateEarningRate() {
        double earningRate = statics.getEarningRate();
        int phrasedMoney = statics.getPhrasedMoney();
        long totalEarning = statics.calculateTotalEarning();
        Assertions.assertThat(earningRate)
                .isEqualTo(((double) totalEarning / phrasedMoney) * 100);
    }
}