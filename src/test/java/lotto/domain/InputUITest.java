package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputUITest {
    private InputUI inputUI;

    @BeforeEach
    void setUp() {
        inputUI = new InputUI();
    }

    @ParameterizedTest
    @CsvSource({"15,[ERROR] 구입 금액은 1000원 단위여야 합니다.","-20,[ERROR] 구입 금액은 0원 이상이여야 합니다.","\0,[ERROR] 구입 금액은 정수여야 합니다.","만원,[ERROR] 구입 금액은 정수여야 합니다."})
    void checkValidPurchase_입력값_에러여부_판단(String input, String expect) {

        assertThatThrownBy(()->inputUI.checkValidPurchase(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expect);
    }
}