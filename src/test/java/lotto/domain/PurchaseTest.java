package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class PurchaseTest {

    @DisplayName("유효한 구입 금액 입력 시 정상 동작 확인")
    @Test
    void inputValidMoney() {
        String input = "5000";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int result = Purchase.inputMoney();

        assertThat(result).isEqualTo(5000);

        System.setIn(System.in);
    }
}