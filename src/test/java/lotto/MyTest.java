package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MyTest {
    private LottoController lottoController;
    private LottoDB lottoDB;

    @DisplayName("로또를 구입할 금액이 정수형으로 올바르게 입력되지 않으면 에러가 발생한다.")
    @Test
    public void checkLottoCountInputError1() {
        assertThatThrownBy(() -> {
            lottoController = new LottoController();
            lottoController.convertStringToInteger("abcd");
        })
                .isInstanceOf(IllegalArgumentException.class); // 예외 유형을 확인
    }

    @DisplayName("로또를 구입할 금액이 1000으로 나누어 떨어지지 않으면 에러가 발생한다.")
    @Test
    public void checkLottoCountInputError2() {
        assertThatThrownBy(() -> {
            lottoDB = new LottoDB();
            lottoDB.setUserLottoCount(1234);
        })
                .isInstanceOf(IllegalArgumentException.class); // 예외 유형을 확인
    }
}
