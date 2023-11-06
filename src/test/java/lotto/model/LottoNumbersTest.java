package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import lotto.model.exception.LottoNumbersException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoNumbersTest {

    @Test
    @DisplayName("LottoNumber 생성 성공")
    void createLottoNumber_success(){

        LottoNumbers LottoNumber = new LottoNumbers(Arrays.asList(1,2,3,4,5,6));
    }

    @Nested
    @DisplayName("LottoNumber 생성 실패")
    class CreateLottoNumbersFail {
        @Test
        @DisplayName("min 값보다 작은 숫자로 생성 시도")
        void outOfRangeLottoNumber_min(){
            assertThatThrownBy(() -> new LottoNumbers(Arrays.asList(0, 1, 2, 3, 4, 5)))
                    .isInstanceOf(LottoNumbersException.class);
        }

        @Test
        @DisplayName("max 값보다 큰 숫자로 생성 시도")
        void outOfRangeLottoNumber_max(){
            assertThatThrownBy(() -> new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 47)))
                    .isInstanceOf(LottoNumbersException.class);
        }
        
        @Test
        @DisplayName("중복된 값으로 생성 시도")
        void duplicatedLottoNumber(){
            assertThatThrownBy(() -> new LottoNumbers(Arrays.asList(1,1,2,3,4,5)))
                    .isInstanceOf(LottoNumbersException.class);
        }

        @Test
        @DisplayName("로또 번호 개수가 다른 경우")
        void incorrectLottoNumberCount(){
            assertThatThrownBy(() -> new LottoNumbers(Arrays.asList(1,2,3,4,5,6,7)))
                    .isInstanceOf(LottoNumbersException.class);
        }
    }

    @Test
    @DisplayName("로또 번호에 해당 숫자 포함 여부 확인")
    void isContainNumber(){
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        boolean containNumber = lottoNumbers.isContainNumber(1);
        boolean containNumber2 = lottoNumbers.isContainNumber(7);
        assertThat(containNumber).isTrue();
        assertThat(containNumber2).isFalse();
    }

    @Test
    @DisplayName("당첨 번호와 로또 일치 개수 확인")
    void countMatchNumber(){
        WinningNumbers winningNumbers = new WinningNumbers(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        int result = lottoNumbers.countMatchNumber(winningNumbers.getWinningNumbers());

        LottoNumbers lottoNumbers2 = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 7));
        int result2 = lottoNumbers2.countMatchNumber(winningNumbers.getWinningNumbers());

        LottoNumbers lottoNumbers3 = new LottoNumbers(Arrays.asList(11, 12, 13, 14, 15, 17));
        int result3 = lottoNumbers3.countMatchNumber(winningNumbers.getWinningNumbers());

        assertThat(result).isEqualTo(6);
        assertThat(result2).isEqualTo(5);
        assertThat(result3).isEqualTo(0);
    }
}