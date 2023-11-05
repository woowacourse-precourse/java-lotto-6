package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoBuyer;
import lotto.domain.Rank;
import lotto.service.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.logging.Logger;

public class LottoViewTest {

    LottoView lottoView = new LottoView();
    Calculator calculator = new Calculator();

    @Test
    void 수익률_출력형식_테스트() {
        //given
        Map<Rank, Integer> map = new HashMap<>();
        map.put(Rank.FIFTH, 1);
        int pay = 1000;

        //when
        double value = calculator.calculateRateOfReturn(map, pay);
        String string = lottoView.printRate(value);

        //then
        assertThat(string).isEqualTo("총 수익률은 500.0%입니다.");
    }

    @ParameterizedTest
    @ValueSource(doubles = {100.05, 100.06, 100.07, 100.08, 100.09})
    @DisplayName("소숫점 둘째자리에서 5이상면 올린다.")
    void 수익률_출력형식_테스트2(double value) {
        //given
        //when
        String string = lottoView.printRate(value);

        //then
        assertThat(string).isEqualTo("총 수익률은 100.1%입니다.");
    }

    @ParameterizedTest
    @ValueSource(doubles = {100.04, 100.03, 100.02, 100.01, 100.00})
    @DisplayName("소숫점 둘째자리에서 4이하면 버린다.")
    void 수익률_출력형식_테스트3(double value) {
        //given
        //when
        String string = lottoView.printRate(value);

        //then
        assertThat(string).isEqualTo("총 수익률은 100.0%입니다.");
    }
}
