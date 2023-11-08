package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Money;
import lotto.domain.PrizeCount;
import lotto.dto.LottoMatchResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrizeCountTest {
    private List<LottoMatchResponse> lottoMatchResponses;

    @BeforeEach
    void setUpLottoMatchResponses() {
        lottoMatchResponses = new ArrayList<>();
    }

    @DisplayName("구매 금액이 8,000원, 5등 1장이면 수익률은 62.5%이다.")
    @Test
    void calculateReturnRate1() {
        LottoMatchResponse lottoMatchResponse = new LottoMatchResponse(3, false);
        lottoMatchResponses.add(lottoMatchResponse);

        PrizeCount prizeCount = new PrizeCount(lottoMatchResponses);

        assertThat(prizeCount.calculateReturnRate(new Money(8_000))).isEqualTo(62.5);
    }

    @DisplayName("구매 금액이 100,000원이고 5등 5장, 4등 1장이면 수익률은 75.0%이다.")
    @Test
    void calculateReturnRate2() {
        LottoMatchResponse fourthMatchResult = new LottoMatchResponse(4, false);
        LottoMatchResponse fifthMatchResult = new LottoMatchResponse(3, false);

        addLottoMatchResponse(fourthMatchResult, 1);
        addLottoMatchResponse(fifthMatchResult, 5);

        PrizeCount prizeCount = new PrizeCount(lottoMatchResponses);

        assertThat(prizeCount.calculateReturnRate(new Money(100_000))).isEqualTo(75.0);
    }

    private void addLottoMatchResponse(LottoMatchResponse lottoMatchResponse, int size) {
        for (int i = 0; i < size; i++) {
            lottoMatchResponses.add(lottoMatchResponse);
        }
    }
}