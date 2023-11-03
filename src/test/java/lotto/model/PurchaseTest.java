package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PurchaseTest {

    @DisplayName("문자 입력시 오류가 발생한다.")
    @Test
    void validateNum() {
        assertThatThrownBy(() -> new Purchase("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 가격이 1000원 단위가 아니면 오류가 발생한다.")
    @Test
    void validateUnit() {
        assertThatThrownBy(() -> new Purchase("1200"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}