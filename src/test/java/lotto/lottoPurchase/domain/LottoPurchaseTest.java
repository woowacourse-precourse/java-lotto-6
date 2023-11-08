package lotto.lottoPurchase.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.List;
import lotto.lotto.domain.Lotto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoPurchaseTest {

    @AfterEach
    public void closeConsoleEach() {
        Console.close();
    }

    @DisplayName("로또 구입 금액이 숫자이지 않으면 예외가 발생한다.")
    @Test
    void 숫자가_아닌_로또_구매_금액() {
        LottoPurchase lottoPurchase = new LottoPurchase();
        String input = "2000a";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThatThrownBy(() -> lottoPurchase.insult())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 1000원으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void 나누어_떨어지지_않는_구매_금액() {
        LottoPurchase lottoPurchase = new LottoPurchase();
        String input = "2001";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        lottoPurchase.insult();

        assertThatThrownBy(() -> lottoPurchase.calculate())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액을 1000으로 나눈 구매 개수를 반환한다.")
    @Test
    void 금액에_따른_로또_구매_개수_반환() {
        LottoPurchase lottoPurchase = new LottoPurchase();
        String input = "14000";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        lottoPurchase.insult();
        lottoPurchase.calculate();

        assertThat(lottoPurchase.getPurchaseAmount()).isEqualTo(14);
    }

}
