package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoQuantity;
import lotto.domain.Money;
import lotto.domain.Prize;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class LottoServiceTest {

    private static MockedStatic<Randoms> mockedRandoms;
    private static LottoService lottoService;

    @BeforeEach
    void setUp() {
        mockedRandoms = mockStatic(Randoms.class);
        lottoService = new LottoService();
    }

    @AfterEach
    void cleanUp() {
        mockedRandoms.close();
    }

    @Test
    @DisplayName("금액을 지불한 만큼 로또들을 생성한 뒤 가져온다.")
    void getLottos() throws Exception {
        //given
        given(Randoms.pickUniqueNumbersInRange(anyInt(), anyInt(), anyInt()))
                .willReturn(List.of(1, 2, 3, 4, 5, 6)
                        , List.of(1, 2, 3, 4, 5, 44)
                        , List.of(1, 2, 3, 4, 5, 45));
        Money money = new Money("3000");
        //when
        List<Lotto> lottos = lottoService.getLottos(money);
        //then
        assertThat(lottos.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("PrizeResult를 생성한 뒤 해당 필드값을 가져온다.")
    void getPrizeResult() throws Exception {
        //given
        given(Randoms.pickUniqueNumbersInRange(anyInt(), anyInt(), anyInt()))
                .willReturn(List.of(1, 2, 3, 4, 5, 6)
                        , List.of(1, 2, 3, 4, 5, 6)
                        , List.of(1, 2, 3, 4, 5, 44)
                        , List.of(1, 2, 3, 4, 5, 45)
                        , List.of(1, 2, 3, 4, 18, 19));
        int tickets = 5;
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 44;
        List<Lotto> lottos = new LottoQuantity(tickets).getLottos();
        //when
        Map<Prize, Integer> result = lottoService.getPrizeResult(lottos, winningNumbers, bonusNumber);
        //then
        assertAll(
                () -> assertEquals(2, result.get(Prize.FIRST)),
                () -> assertEquals(1, result.get(Prize.SECOND)),
                () -> assertEquals(1, result.get(Prize.THIRD)),
                () -> assertEquals(1, result.get(Prize.FOURTH)),
                () -> assertEquals(0, result.get(Prize.FIFTH))
        );

    }

    @Test
    @DisplayName("총 수익률을 생성한 뒤 해당 필드값을 가져온다.")
    void getRevenue() throws Exception {
        //given
        Map<Prize, Integer> result = Map.of(Prize.FIRST, 0
                , Prize.SECOND, 0
                , Prize.THIRD, 0
                , Prize.FOURTH, 0
                , Prize.FIFTH, 1);

        Money money = new Money("8000");
        //when
        String revenue = lottoService.getRevenue(result, money);
        //then
        assertThat(revenue).isEqualTo("62.5%");
    }

}