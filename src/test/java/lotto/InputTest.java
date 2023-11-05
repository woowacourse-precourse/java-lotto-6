package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
class InputTest {
//    private static InputStream stream = System.in;
    Validator validator;

    @BeforeEach
    public void initTest(){
        validator = new Validator();
    }
//    @AfterEach
//    public void afterEach(){
//        System.setIn(stream);
//    }
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
//    @DisplayName("보너스 번호 입력이 유효하지 않는 경우")
//    @Test
//    void bonusInvalid(){
//        String userInput = "4001\n";
//        InputStream in = new ByteArrayInputStream(userInput.getBytes());
//        System.setIn(in);
//
//        assertThatThrownBy(()->input.pickBonusNumber())
//                .isInstanceOf(IllegalArgumentException.class);
//    }
//    @DisplayName("입력 금액이 1000으로 나누어 떨어지지 않는 경우.")
//    @Test
//    void divideInvalid1(){
//        String userInput = "4001";
//        InputStream in = new ByteArrayInputStream(userInput.getBytes());
//        System.setIn(in);
//
//        assertThatThrownBy(()->input.buyAmount())
//                .isInstanceOf(IllegalArgumentException.class);
//    }
//
//    @DisplayName("보너스 번호 입력이 유효하지 않는 경우")
//    @Test
//    void bonusInvalid2(){
//        String userInput = "46,\n";
//        InputStream in = new ByteArrayInputStream(userInput.getBytes());
//        System.setIn(in);
//
//        assertThatThrownBy(()->input.pickBonusNumber())
//                .isInstanceOf(IllegalArgumentException.class);
//    }
//    @DisplayName("보너스 번호 입력이 유효하지 않는 경우")
//    @Test
//    void bonusInvalid3(){
//        String userInput = "46 \n";
//        InputStream in = new ByteArrayInputStream(userInput.getBytes());
//        System.setIn(in);
//
//        assertThatThrownBy(()->input.pickBonusNumber())
//                .isInstanceOf(IllegalArgumentException.class);
//    }

}
