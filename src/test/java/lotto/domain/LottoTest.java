package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.domain.Lotto.validateNumberSeparate;
import static lotto.domain.Lotto.validateNumbersType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호가 1 이상 45 이하가 아닐 경우에 대한 테스트")
    void lottoNumberOutOfRangeTest() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 47)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호가 구분 문자로 제대로 분리되는지 확인하는 테스트")
    void lottoNumberSeparateTest() {
        //given
        String input = "1,2,3,4,5?6";
        String[] numbers = input.split(",");

        //when

        //then
        assertThatThrownBy(() -> validateNumberSeparate(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호에 숫자 외의 값이 들어갔는지 확인하는 테스트")
    void lottoNumberIsNotNumberTest(){
        //given
        String input = "o,t,t,f,f,s";
        String[] numbers = input.split(",");

        //when

        //then
        for (String number : numbers) {
            assertThatThrownBy(() -> validateNumbersType(number))
                    .isInstanceOf(NumberFormatException.class);
        }
    }
}