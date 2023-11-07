package lotto.view;


import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.service.Calculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoViewTest {

    LottoView lottoView = new LottoView();

    @Test
    @DisplayName("Lotto.toString()은 오름차순과 문제의 출력형식을 지킨다.")
    void Lotto_toString_테스트(){
        //given
        Lotto lotto = new Lotto(List.of(1,12,31,43,22,6));

        //when
        String string = lotto.toString();

        //then
        assertThat(string).isEqualTo("[1, 6, 12, 22, 31, 43]");
    }

    @Test
    void 수익률_출력형식_테스트() {
        //given
        Map<Rank, Integer> map = new HashMap<>();
        map.put(Rank.FIFTH, 1);
        int pay = 1000;

        //when
        double value = Calculator.calculateRateOfReturn(map, pay);
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
