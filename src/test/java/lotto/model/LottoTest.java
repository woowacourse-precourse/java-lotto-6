package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import lotto.model.exception.LottoNumbersException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    @DisplayName("LottoNumber 생성 성공")
    void createLottoNumber_success(){

        Lotto LottoNumber = new Lotto(Arrays.asList(1,2,3,4,5,6));
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

    @Nested
    @DisplayName("LottoNumber 생성 실패")
    class CreateGivenLottoFail {
        @Test
        @DisplayName("min 값보다 작은 숫자로 생성 시도")
        void outOfRangeLottoNumber_min(){
            assertThatThrownBy(() -> new Lotto(Arrays.asList(0, 1, 2, 3, 4, 5)))
                    .isInstanceOf(LottoNumbersException.class);
        }

        @Test
        @DisplayName("max 값보다 큰 숫자로 생성 시도")
        void outOfRangeLottoNumber_max(){
            assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 47)))
                    .isInstanceOf(LottoNumbersException.class);
        }
        
        @Test
        @DisplayName("중복된 값으로 생성 시도")
        void duplicatedLottoNumber(){
            assertThatThrownBy(() -> new Lotto(Arrays.asList(1,1,2,3,4,5)))
                    .isInstanceOf(LottoNumbersException.class);
        }

        @Test
        @DisplayName("로또 번호 개수가 다른 경우")
        void incorrectLottoNumberCount(){
            assertThatThrownBy(() -> new Lotto(Arrays.asList(1,2,3,4,5,6,7)))
                    .isInstanceOf(LottoNumbersException.class);
        }
    }

    @Test
    @DisplayName("로또 번호에 해당 숫자 포함 여부 확인")
    void isContainNumber(){
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        boolean containNumber = lotto.isContainNumber(1);
        boolean containNumber2 = lotto.isContainNumber(7);
        assertThat(containNumber).isTrue();
        assertThat(containNumber2).isFalse();
    }

    @Test
    @DisplayName("당첨 번호와 로또 일치 개수 확인")
    void countMatchNumber(){
        WinningNumbers winningNumbers = new WinningNumbers(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int result = lotto.countMatchNumber(winningNumbers.getWinningNumbers());

        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        int result2 = lotto2.countMatchNumber(winningNumbers.getWinningNumbers());

        Lotto lotto3 = new Lotto(Arrays.asList(11, 12, 13, 14, 15, 17));
        int result3 = lotto3.countMatchNumber(winningNumbers.getWinningNumbers());

        assertThat(result).isEqualTo(6);
        assertThat(result2).isEqualTo(5);
        assertThat(result3).isEqualTo(0);
    }
}