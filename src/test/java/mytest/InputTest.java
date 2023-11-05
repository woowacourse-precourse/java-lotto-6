package mytest;
import java.io.ByteArrayInputStream;
import lotto.Input;
import java.io.InputStream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputTest {
    @DisplayName("1000원 단위의 금액이 아니면 예외가 발생한다.")
    @Test
    void creatNotCorrectUnit(){
        InputStream input = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("1111".getBytes());
        System.setIn(in);
        Input getUser = new Input();
        assertThatThrownBy(()->getUser.getUserCash())
        .isInstanceOf(IllegalArgumentException.class);
    }


}