package lotto;

import model.LotteryNumbers;
import model.LottoPrice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;


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

    @DisplayName("로또번호 정렬 검사입니다.")
    @Test
    void sortTest(){
        List<Integer> lotteryNumbers = List.of(6,5,4,3,2,1);
        List<Integer> answerNumbers = List.of(1,2,3,4,5,6);

        Lotto lotto = new Lotto(lotteryNumbers);

        assertThat(lotto.toString()).isEqualTo(answerNumbers.toString());
    }

    @DisplayName("1미만 45초과되는 추첨번호 입력 범위가 있으면 예외가 발생한다.")
    @Test
    void validateRangeTest(){
        assertThatThrownBy(() -> new Lotto(List.of(12,21,34,45,67,1))).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(0,2,4,6,7,11))).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호에 중복번호가 입력되면 예외가 발생한다.")
    @Test
    void bonusNumberDuplicateCheckTest() {
        assertThatThrownBy(() -> new LotteryNumbers(List.of(1,2,3,4,5,6),6)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 0미만 또는 45 초과하는 숫자를 입력받으면 예외 발생한다.")
    @Test
    void validateBonusNumberRangeTest() {
        assertThatThrownBy(() -> new LotteryNumbers(List.of(1,2,3,4,5,6),0)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LotteryNumbers(List.of(11,25,34,12,9,5),48)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값으로 0 들어오면 예외 발생")
    @Test
    void inputZeroTest() {
        assertThatThrownBy(() -> new LottoPrice(0)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000원 단위로 들어오지 않으면 예외 발생")
    @Test
    void inputDivideTest(){
        assertThatThrownBy(() -> new LottoPrice(1080)).isInstanceOf(IllegalArgumentException.class);
    }
}