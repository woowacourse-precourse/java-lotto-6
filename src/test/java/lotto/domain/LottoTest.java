package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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


    @DisplayName("로또 번호 입력 - 정상")
    @Test
    void createLotto() {
        String input = "1,2,3,4,5,6";

        Lotto lotto = new Lotto(input);
        List<Integer> expectedResult = List.of(1, 2, 3, 4, 5, 6);

        assertThat(lotto.getNumbers()).isEqualTo(expectedResult);
    }

    @DisplayName("로또 번호 입력 - empty 예외")
    @Test
    void createLottoEmpty() {
        String input = "";

        assertThatThrownBy(() -> new Lotto(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 입력 - null 예외")
    @Test
    void createLottoNULL() {
        String input = null;

        assertThatThrownBy(() -> new Lotto(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 입력 - 공백만 입력 예외")
    @Test
    void createLottoOnlySpace() {
        String input = "  ";

        assertThatThrownBy(() -> new Lotto(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 입력 - 숫자 중간 공백 예외")
    @Test
    void creatLottoIncludeMiddleSpace() {
        assertThatThrownBy(() -> new Lotto("1,2, ,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 입력 - 숫자 이후 공백 예외")
    @Test
    void creatLottoIncludeAfterSpace() {
        assertThatThrownBy(() -> new Lotto("1,2,3,4,5,6, , , ,"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 입력 - 숫자 이후 공백 예외")
    @Test
    void creatLottoIncludePreSpace() {
        assertThatThrownBy(() -> new Lotto(" , ,1,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 입력 - 문자 포함 예외")
    @Test
    void createLottoWithCharacter() {
        String number = "1,q,2,w,3,e";

        assertThatThrownBy(() -> new Lotto(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 입력 - 문자만 존재 예외")
    @Test
    void createLottoOnlyCharacter() {
        String number = "q,w,e,r,t,y";

        assertThatThrownBy(() -> new Lotto(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 입력 - 7개 이상의 숫자 예외")
    @Test
    void creatLottoWithOverRangeInput() {
        assertThatThrownBy(() -> new Lotto("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("로또 번호 입력 - 입력값 6개 미만 예외")
    @Test
    void createLottoWithUnderRangeInput() {
        assertThatThrownBy(() -> new Lotto("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 입력 - 45를 초과하는 값이 있는 경우 예외")
    @Test
    void createLottoOverRangeNumbers() {
        assertThatThrownBy(() -> new Lotto("1,2,3,4,5,46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 입력 - 1 미만의 값 입력 예외")
    @Test
    void createLottoUnderRangeNumbers() {
        assertThatThrownBy(() -> new Lotto("1,2,3,4,5,0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 번호 입력 - 중복값 예외")
    @Test
    void createLottoWithDuplicatedNumbers() {
        assertThatThrownBy(() -> new Lotto("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}