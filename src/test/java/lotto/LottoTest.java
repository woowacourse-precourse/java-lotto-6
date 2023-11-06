package lotto;

import lotto.domain.Lotto;
import lotto.util.Validator;
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

    // 아래에 추가 테스트 작성 가능

    @DisplayName("로또 금액 입력시 1000원보다 작은 숫자가 입력되면 예외가 발생한다.")
    @Test
    void 금액이_1000원보다_작을_때_테스트(){
        String 금액값 = "999";
        assertThatThrownBy(() ->
                Validator.validateInputAmount(금액값))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 금액 입력시 숫자가 입력되지 않으면 예외가 발생한다.")
    @Test
    void 금액이_숫자가_아닐_때_테스트(){
        String 금액값 = "ab12";
        assertThatThrownBy(() ->
                Validator.validateInputAmount(금액값))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 금액 입력시 숫자가 1000으로 나눠지지 않으면 예외가 발생한다.")
    @Test
    void 금액이_1000으로_나눠지지_않을_때_아닐_때_테스트(){
        String 금액값 = "4500";
        assertThatThrownBy(() ->
                Validator.validateInputAmount(금액값))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복_번호_테스트(){
        List<Integer> 중복된로또번호 = List.of(1,2,4,4,5,6);
        assertThatThrownBy(() ->
                Validator.validateSameNumberCheckStart(중복된로또번호))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 범위_초과_테스트(){
        List<String> 범위초과리스트 = List.of("1","2","50","0","5","8");
        assertThatThrownBy(() ->
                Validator.validateLottoNumLimit(범위초과리스트))
                .isInstanceOf(IllegalArgumentException.class);
    }



}