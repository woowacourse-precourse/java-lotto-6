package lotto;

import java.util.Arrays;
import java.util.stream.Collectors;
import lotto.Model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @DisplayName("로또 번호가 잘 생성되는지 확인한다.")
    @Test
    void createBasicLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));;
    }

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

    //TODO 비슷한 테스트케이스, List값만 바꿔도 될 수 있도록 공부해서 수정
    @DisplayName("로또 번호에 숫자가 아닌 문자가 포함되어 있으면 예외가 발생한다.")
    @Test
    void createLottoByContainLetter() {
        /**
         * List.of(1,2,3,4,5,-1)
         * List.of(1,2,3,4,5,a)
         * List.of(1,2,3,4,5,0.1)
         * List.of(1,2,3,4,5,*)
         */
        assertThatThrownBy(() -> new Lotto(List.of())).isInstanceOf(
            IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1~45 사이의 값이 아니면 예외가 발생한다. ")
    @Test
    void createLottoByInvalidNumber() {
        /**
         * List.of(1,2,3,4,5,55)
         * List.of(1,2,3,4,5,0)
         * List.of(1,2,3,4,5,100)
         */

        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 55)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 Empty 값이 있으면 예외가 발생한다. ")
    @Test
    void createLottoByEmptyValue() {
        //이 경우, 애초에 공백 문자가 들어갈 수 없는 구조라 예외 발생이 어려움. 기능명세서 수정.
        String input = "1,2,3,4,,6";
        List<Integer> lottoNumbers = Arrays.stream(input.split(","))
            .map(String::trim)
            .filter(s -> !s.isEmpty())
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        assertThatThrownBy(() -> new Lotto(lottoNumbers))
            .isInstanceOf(IllegalArgumentException.class);
    }

}