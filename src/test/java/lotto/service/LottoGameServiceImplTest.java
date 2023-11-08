package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import lotto.common.LottoRank;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.dto.request.LottoNumberRequest;
import lotto.dto.request.LottoPurchaseCostRequest;
import lotto.dto.request.LottoRequest;
import lotto.dto.response.LottoBuyResponse;
import lotto.dto.response.LottoGameResultResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGameServiceImplTest {
    @DisplayName("로또 구매 테스트")
    @Test
    void buyLottos() {
        LottoGameServiceImpl lottoGameService = new LottoGameServiceImpl();
        LottoPurchaseCostRequest request = new LottoPurchaseCostRequest("4000");

        LottoBuyResponse lottoBuyResponse = lottoGameService.buyLottos(request);

        assertThat(lottoBuyResponse.getCount()).isEqualTo(4);
    }

    @DisplayName("로또 결과계산 테스트")
    @Test
    void calculateResult() {
        LottoGameServiceImpl lottoGameService = new LottoGameServiceImpl(
                Arrays.asList(new Lotto(Arrays.asList(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6)))
                )
        );
        LottoGameResultResponse lottoGameResultResponse = lottoGameService.calculateResult(
                new LottoRequest("1,2,3,4,5,6"), new LottoNumberRequest("7"));

        assertThat(lottoGameResultResponse.getProfitRate()).isEqualTo(200000000);
        assertThat(lottoGameResultResponse.getGameResultCounts().get(LottoRank.FIRST_RANK))
                .isEqualTo(1);
    }
}
