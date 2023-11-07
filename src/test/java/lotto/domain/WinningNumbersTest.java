package lotto.domain;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class WinningNumbersTest {
    @Test
    void setWinningNumbers(){
        assertThatThrownBy(() -> new PurchaseManager("1, 2, 3, 4, 5, 6"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void setWinningNumbers2(){
        assertThatThrownBy(() -> new PurchaseManager("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void setWinningNumbers3(){
        assertThatThrownBy(() -> new PurchaseManager("1,2,3,4,5,66"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void setWinningNumbers4(){
        assertThatThrownBy(() -> new PurchaseManager("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void setWinningNumbers5(){
        assertThatThrownBy(() -> new PurchaseManager("1,a,b,c,d,e"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void setBonusNumber() {
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        assertThatThrownBy(() -> winningNumbers.setBonusNumber("5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}