package lotto;

import lotto.domain.CompareLottoValue;
import lotto.domain.Lotto;
import lotto.util.Validator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.CompareLottoValue.compareValueStart;
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

    @Test
    void 그릇된_형식_테스트(){
        List<String> 형식에러리스트 = List.of("1","2","a","b","5","8");
        assertThatThrownBy(() ->
                Validator.validateLottoNumLimit(형식에러리스트))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스숫자_범위_초과_테스트(){
        String bonus = "0";
        assertThatThrownBy(() ->
                Validator.validateBonusNumLimit(bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스숫자_그릇된_형식_테스트(){
        String bonus = "a";
        assertThatThrownBy(() ->
                Validator.validateBonusNumChange(bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨숫자와_보너스볼의_중복여부_테스트(){
        int bonusBall = 6;
        List<Integer> winningBalls = List.of(1,2,3,4,5,6);
        assertThatThrownBy(() ->
                Validator.validateWinningAndBonus(bonusBall, winningBalls))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void 총_수익률_계산(){
        List<Integer> lottoBall1 = List.of(8, 21, 23, 41, 42, 43);
        List<Integer> lottoBall2 = List.of(3, 5, 11, 16, 32, 38);
        List<Integer> lottoBall3 = List.of(7, 11, 16, 35, 36, 44);
        List<Integer> lottoBall4 = List.of(1, 8, 11, 31, 41, 42);
        List<Integer> lottoBall5 = List.of(13, 14, 16, 38, 42, 45);
        List<Integer> lottoBall6 = List.of(7, 11, 30, 40, 42, 43);
        List<Integer> lottoBall7 = List.of(2, 13, 22, 32, 38, 45);
        List<Integer> lottoBall8 = List.of(1, 3, 5, 14, 22, 45);

        List<List<Integer>> lottoBalls2 = new ArrayList<>();
        lottoBalls2.add(lottoBall1);
        lottoBalls2.add(lottoBall2);
        lottoBalls2.add(lottoBall3);
        lottoBalls2.add(lottoBall4);
        lottoBalls2.add(lottoBall5);
        lottoBalls2.add(lottoBall6);
        lottoBalls2.add(lottoBall7);
        lottoBalls2.add(lottoBall8);

        int amount = 8000;

        List<Integer> winningBalls2 = List.of(1,2,3,4,5,6);
        int bonusBall = 7;
        compareValueStart(winningBalls2, lottoBalls2, bonusBall,8000);
        Assertions.assertThat(CompareLottoValue.getRateOfTurn(amount)).isEqualTo(62.5);
    }

}