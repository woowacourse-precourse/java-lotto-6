package lotto.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.constant.LottoPrize;
import lotto.model.Lotto;
import lotto.view.OutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class OutputControllerTest {
    private OutputController outputController;

    @BeforeEach
    void init() {
        outputController = new OutputController(new OutputView());
    }

    // 업데이트 되는 부분 양식 생성 검증 테스트
    @DisplayName("OutputView에서 업데이트 되어야 하는 양식(구입한 로또 개수)이 제대로 생성되는지 테스트.")
    @ParameterizedTest
    @CsvSource(value = {"1:1", "5:5"}, delimiter = ':')
    void 구입한_로또_개수_업데이트_양식_테스트(int given, String expected) {
        // when
        String actual = outputController.creatLottoTicketsCountText(given);

        // then
        assertThat(actual).contains(expected);
    }

    @DisplayName("OutputView에서 업데이트 되어야 하는 양식(구입한 로또들 번호)이 제대로 생성되는지 테스트.")
    @Test
    void 구입한_로또들_번호_업데이트_양식_생성_테스트() {
        // given
        List<Lotto> fixedTickets = new ArrayList<>() {{
            add(new Lotto(List.of(2, 3, 4, 5, 6, 1)));
            add(new Lotto(List.of(14, 15, 16, 17, 18, 19)));
            add(new Lotto(List.of(2, 3, 4, 5, 6, 10)));
            add(new Lotto(List.of(2, 3, 4, 5, 10, 11)));
        }};
        String expected = """
                [2, 3, 4, 5, 6, 1]
                [14, 15, 16, 17, 18, 19]
                [2, 3, 4, 5, 6, 10]
                [2, 3, 4, 5, 10, 11]""";

        // when
        String actual = outputController.createLottoTicketsText(fixedTickets);

        // then
        assertThat(actual).contains(expected);
    }

    @DisplayName("OutputView에서 업데이트 되어야 하는 양식(상금 개수 통계)이 제대로 생성되는지 테스트.")
    @Test
    void 상금_개수_통계_업데이트_양식_생성_테스트() {
        // given
        Map<LottoPrize, Integer> prizeCounter = new HashMap<>() {{
            put(LottoPrize.FIFTH, 10);
            put(LottoPrize.FOURTH, 5);
            put(LottoPrize.THIRD, 2);
            put(LottoPrize.SECOND, 0);
            put(LottoPrize.FIRST, 1);
            put(LottoPrize.NOTHING, 110);
        }};
        String expected = """
                3개 일치 (5,000원) - 10개
                4개 일치 (50,000원) - 5개
                5개 일치 (1,500,000원) - 2개
                5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
                6개 일치 (2,000,000,000원) - 1개""";

        // when
        String actual = outputController.createPrizeCounterText(prizeCounter);

        // then
        assertThat(actual).contains(expected);
    }

    @DisplayName("OutputView에서 업데이트 되어야 하는 양식(수익률)이 제대로 생성되는지 테스트.")
    @Test
    void 수익률_업데이트_양식_생성_테스트() {
        // given
        double rateOfReturn = 25000.0256;
        String expected = """
                25000.0""";
        // when
        String actual = outputController.createRateOfReturnText(rateOfReturn);

        // then
        assertThat(actual).contains(expected);
    }
}
