package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
    Validator validator = new Validator();
    @DisplayName("로또의 번호가 6개를 넘어갈 경우.")
    @Test
    void sizeOver(){
        String arrayInput = "1,2,3,4,5,6,7";
        List<Integer> numbers = Arrays.stream(arrayInput.split(","))
                .map(Integer::parseInt)
                .toList();
        assertThatThrownBy(()-> validator.validateCount(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또의 번호의 숫자가 유효하지 않은 경우.")
    @Test
    void numberInvalid(){
        Integer numberInput = 46;
        assertThatThrownBy(()->validator.validateRange(numberInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또의 번호의 숫자가 유효하지 않은 경우.")
    @Test
    void numberInvalid2(){
        Integer numberInput = 0;
        assertThatThrownBy(()->validator.validateRange(numberInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("유저의 입력에 숫자가 아닌값이 있는 경우.")
    @Test
    void inputInvalid(){
        String userInput = "12,34,13,45,24,35.";
        assertThatThrownBy(()->validator.validateNumberList(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("구매하는 돈 1000의 배수가 아닌경우")
    @Test
    void Invalid2(){
        String userInput = "100001";
        assertThatThrownBy(()->validator.validateBuyAmount(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("구매하는 돈 음수인 경우")
    @Test
    void Invalid3(){
        String userInput = "-10000";
        assertThatThrownBy(()->validator.validateBuyAmount(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("구매하는 돈 옳지 않은 문자열인 경우")
    @Test
    void Invalid4(){
        String userInput = "-10000";
        assertThatThrownBy(()->validator.validateBuyAmount(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("숫자 6개가 범위를 벗어나는 이유")
    @Test
    void Invalid5(){
        String userInput = "1,2,3,4,5,46";
        assertThatThrownBy(()->validator.validatePickSixNumber(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("숫자 6개가 범위를 벗어나는 이유")
    @Test
    void Invalid6(){
        String userInput = "-1,2,3,4,5,46";
        assertThatThrownBy(()->validator.validatePickSixNumber(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("숫자가 아닌 값이 들어간 경우")
    @Test
    void Invalid7(){
        String userInput = "-1,2,3,4,5,46";
        assertThatThrownBy(()->validator.validatePickSixNumber(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("추가 숫자 잘못 입력한 경우")
    @Test
    void Invalid8(){
        String userInput = "-1,2,3,4,5,46";
        assertThatThrownBy(()->validator.validatePickSixNumber(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}