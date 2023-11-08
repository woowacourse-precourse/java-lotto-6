package lotto.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


@DisplayName("Lotto 클래스 테스트")
public class LottoTest {

    @DisplayName("로또 번호에 중복된 숫자의 입력은 예외처리된다.")
    @Test
    void duplicateLottoNumberExceptionTest(){
        List<Integer> numbers = List.of(1,2,2,3,4,5);
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Lotto(numbers));

        List<Integer> numbers2 = List.of(1,1,1,1,1,1);
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Lotto(numbers2));
    }

    @DisplayName("1~45이외의 로또 번호 입력은 예외처리된다.")
    @Test
    void belowZeroNumberInputOccurExceptionTest(){
        List<Integer> numbers = List.of(-1,5,6,7,8,9);
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Lotto(numbers));

        List<Integer> numbers2 = List.of(0, 43,35,37,32,23);
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Lotto(numbers));
    }

    @DisplayName("로또 번호 갯수가 6개가 아니면 예외 처리")
    @Test
    void lottoNumberLengthIsNotSix(){
        List<Integer> numbers = List.of(1,2,3,4,5);
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Lotto(numbers));

        List<Integer> number2 = List.of(12,3,4,5,7,8,23);
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Lotto(numbers));
    }

    @DisplayName("정상 입력 테스트")
    @Test
    void normalInputTest(){
        List<Integer> numbers = List.of(35,23,12,16,17,28);
        Lotto lotto = new Lotto(numbers);
    }

}
