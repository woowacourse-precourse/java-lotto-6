package lotto.utils.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UnitValidatorTest {

    @Test
    @DisplayName("구입 금액이 정상적인 경우")
    void 구입_금액이_정상적인_경우() throws Exception {
        //given
        int money = 5000;
        //when then
        assertThatCode(() -> UnitValidator.validMoneyUnitCheck(money))
                .doesNotThrowAnyException();
    }
    @Test
    @DisplayName("구입 금액이 정상적이지 않은 경우")
    void 구입_금액이_정상적이지_않은_경우() throws Exception {
        //given
        int money1 = 500; // 천원 미만임
        int money2 = 0; // 돈이 아예 없음
        int money3 = 1001; // 천원 단위가 아님
        //when then
        assertThatThrownBy(() ->
                UnitValidator.validMoneyUnitCheck(money1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() ->
                UnitValidator.validMoneyUnitCheck(money2))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() ->
                UnitValidator.validMoneyUnitCheck(money3))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("로또 리스트가 정상적인 범위인 경우")
    void 로또_리스트가_정상적인_범위인_경우() throws Exception {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        //when then
        assertThatCode(() -> UnitValidator.validNumberUnitCheck(numbers))
                .doesNotThrowAnyException();
    }
    @Test
    @DisplayName("로또 리스트가 정상적이지 않는 범위인 경우")
    void 로또_리스트가_정상적이지_않는_범위인_경우() throws Exception {
        //given
        List<Integer> case1 = List.of(46, 50, 55, 88, 99, 100);
        List<Integer> case2 = List.of(0, -1, -2, -4, -5, -100);
        //when then
        assertThatThrownBy(() ->
                UnitValidator.validNumberUnitCheck(case1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() ->
                UnitValidator.validNumberUnitCheck(case2))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("보너스 번호가 정상적인 범위인 경우")
    void 보너스_번호가_정상적인_범위인_경우() throws Exception {
        //given
        int case1 = 1;
        int case2 = 45;
        //when then
        assertThatCode(() -> UnitValidator.validBonusUnitCheck(case1))
                .doesNotThrowAnyException();
        assertThatCode(() -> UnitValidator.validBonusUnitCheck(case2))
                .doesNotThrowAnyException();
    }
    @Test
    @DisplayName("보너스 번호가 정상적이지 않은 범위인 경우")
    void 보너스_번호가_정상적이지_않은_범위인_경우() throws Exception {
        //given
        int case1 = 0;
        int case2 = 46;
        //when then
        assertThatThrownBy(() ->
                UnitValidator.validBonusUnitCheck(case1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() ->
                UnitValidator.validBonusUnitCheck(case2))
                .isInstanceOf(IllegalArgumentException.class);
    }
}