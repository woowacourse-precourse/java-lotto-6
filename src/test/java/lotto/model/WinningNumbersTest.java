package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import lotto.model.exception.LottoNumbersException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    @Test
    @DisplayName("당첨 번호 생성 성공")
    void createWinningNumbers_success(){
        WinningNumbers winningNumbers = new WinningNumbers(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);
    }

    @Nested
    @DisplayName("당첨 번호 생성 실패")
    class createWinningNumbersFail{
        @Test
        @DisplayName("min 보다 작은 보너스 번호")
        void outOfRangeBonusNumber_min(){
            assertThatThrownBy(() -> new WinningNumbers(new LottoNumbers(Arrays.asList(1,2,3,4,5,6)), 0))
                    .isInstanceOf(LottoNumbersException.class);
        }

        @Test
        @DisplayName("min 보다 작은 보너스 번호")
        void outOfRangeBonusNumber_max(){
            assertThatThrownBy(() -> new WinningNumbers(new LottoNumbers(Arrays.asList(1,2,3,4,5,6)), 46))
                    .isInstanceOf(LottoNumbersException.class);
        }

        @Test
        @DisplayName("당첨 번호와 중복된 보너스 번호")
        void duplicatedBonusNumber(){
            assertThatThrownBy(() -> new WinningNumbers(new LottoNumbers(Arrays.asList(1,2,3,4,5,6)), 1))
                    .isInstanceOf(LottoNumbersException.class);
        }

        @Test
        @DisplayName("중복된 당첨 번호")
        void duplicatedWinningNumber(){
            assertThatThrownBy(() -> new WinningNumbers(new LottoNumbers(Arrays.asList(1,1,3,4,5,6)), 8))
                    .isInstanceOf(LottoNumbersException.class);
        }
    }


}