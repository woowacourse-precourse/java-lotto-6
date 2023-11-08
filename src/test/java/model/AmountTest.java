package model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AmountTest {
    @Test
    void 천원단위_아니면Error(){
        assertThatThrownBy(()-> new Amount("1001"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 숫자판별테스트(){
        assertThatThrownBy(() -> new Amount("100K"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}