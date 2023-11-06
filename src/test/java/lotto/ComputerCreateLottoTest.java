package lotto;


import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import lotto.controller.LottoController;
import lotto.domain.Lottos;
import lotto.view.LottoView;
import org.junit.jupiter.api.Test;

public class ComputerCreateLottoTest {

    @Test
    void 금액_입력시_로또_번호_발행() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        LottoView lottoView = new LottoView();

        Method lottoPayMethod = LottoView
                .class
                .getDeclaredMethod("lottoPay", String.class);
        lottoPayMethod.setAccessible(true);
        lottoPayMethod.invoke(lottoView, "10000");
    }
    @Test
    void 정렬확인(){
        assertRandomUniqueNumbersInRangeTest(
                () -> { // input 21 output 8 둘다 8 나오면 OK
                    Lottos lottos = LottoController
                            .getInstance()
                            .lottoSell("1000");
                    assertThat(lottos.getLottos().get(0).getNumbers())
                            .isEqualTo(new Lottos().getLottos().get(0).getNumbers());
                },
                List.of(21, 8, 23, 41, 42, 43)
        );
    }

    @Test
    void 숫자가_아닌_것_예외처리(){
        String numberStr = "ㅂㅈㄷ";

        assertThatThrownBy(() -> new Lottos(numberStr))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 천_미만의_수_예외처리(){
        String numberStr = "900";

        assertThatThrownBy(() -> new Lottos(numberStr))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 백원단위가_있을_때_예외처리(){
        String numberStr = "11900";

        assertThatThrownBy(() -> new Lottos(numberStr))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
