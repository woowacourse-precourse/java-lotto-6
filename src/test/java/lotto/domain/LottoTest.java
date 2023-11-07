package lotto.domain;

import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

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
    @DisplayName("당첨번호의 문자열을 리스트로 변경")
    @Test
    public void 리스트_변경(){
        //given (주어진 값)
        String one = "1, 2,  3, 4,5,21";
        String two = "45,23,42,3,2,6";

        List<Integer> checkOne = new ArrayList<>(List.of(1,2,3,4,5,21));
        List<Integer> checkTwo = new ArrayList<>(List.of(2,3,6,23,42,45));

        //when (기능 작동)
        Lotto lotto = new Lotto(one);
        List<Integer> lottoOne = lotto.getLottoNumbers();

        lotto = new Lotto(two);
        List<Integer> lottoTwo = lotto.getLottoNumbers();

        //then (기능 작동 후 결과)
        Assertions.assertThat(lottoOne).isEqualTo(checkOne);
        Assertions.assertThat(lottoTwo).isEqualTo(checkTwo);
    }
    @DisplayName("사용자의 로또 번호 중 당첨번호가 없을경우")
    @ParameterizedTest
    @ValueSource(ints = {1,5,7,8,9,11})
    public void 당첨번호가_없을경우(int number){
        //given
        List<Integer> numbers = new ArrayList<>(List.of(2,3,24,34,25,45));

        //when
        Lotto lotto = new Lotto(numbers);
        boolean check = lotto.checkUserAndLottoNumbers(numbers,number);
        //then
        Assertions.assertThat(check).isFalse();
    }
    @DisplayName("사용자의 로또 번호 중 당첨번호가 있을경우")
    @ParameterizedTest
    @ValueSource(ints = {1,5,7,8,9,11})
    public void 당첨번호가_있을경우(int number){
        //given
        List<Integer> numbers = new ArrayList<>(List.of(1,5,7,8,9,11));

        //when
        Lotto lotto = new Lotto(numbers);
        boolean check = lotto.checkUserAndLottoNumbers(numbers,number);
        //then
        Assertions.assertThat(check).isTrue();
    }
}