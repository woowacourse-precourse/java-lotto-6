package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputPurchaseAmountTest {
    private static final int NEGATIVE_PURCHASE = -1000;
    private static final int NOT_DIVIDE_1000 = 100500;
    @DisplayName("입력 받은 로또 구입 가격이 int형 이지만 양수가 아니라면 예외가 발생한다.")
    @Test
    void createPurchaseByNegative() {
        assertThatThrownBy(() -> InputPurchaseAmount.inputPurchaseAmountPositive(NEGATIVE_PURCHASE))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
