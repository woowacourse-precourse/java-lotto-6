package lotto;

import lotto.domain.Game;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class GameTest {

    @DisplayName("입력된 보너스 번호가 1~45 외의 숫자이면 예외가 발생한다.")
    @Test
    void checkBonusNumberIsInRange(){
        //given
        int example1 =0;
        int example2 =60;
        List<Integer> testWinningNumbers=List.of(1,2,3,4,5,6);

        //when
        Throwable result1 =catchThrowable(()->{
            new Game(testWinningNumbers,example1);
        });
        Throwable result2 = catchThrowable(()->{
            new Game(testWinningNumbers,example2);
        });

        //then
        assertThat(result1).isInstanceOf(IllegalArgumentException.class);
        assertThat(result2).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 로또번호에 중복이 존재하면 예외가 발생한다.")
    @Test
    void checkDuplicateNumberInList(){
        //given
        List<Integer> example = List.of(1,1,2,3,4,5);
        int testBonusNumber = 10;

        //when
        Throwable result = catchThrowable(()->{
            new Game(example,testBonusNumber);
        });

        //then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 로또번호가 6자리가 아니면 예외가 발생한다.")
    @Test
    void checkSizeOfNumberList(){
        //given
        List<Integer> example1 = List.of(1,2,3);
        List<Integer> example2 = List.of(1,2,3,4,5,6,7,8);
        int testBonusNumber = 10;

        //when
        Throwable result1 = catchThrowable(()->{
            new Game(example1,testBonusNumber);
        });
        Throwable result2 = catchThrowable(()->{
            new Game(example2,testBonusNumber);
        });

        //then
        assertThat(result1).isInstanceOf(IllegalArgumentException.class);
        assertThat(result2).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 로또번호와 보너스번호가 중복되면 예외가 발생한다.")
    @Test
    void checkLottoNumberAndBonusNumberDuplicate(){
        //given
        List<Integer> testWinningNumbers = List.of(1,2,3,4,5,6);
        int testBonusNumber = 6;

        //when
        Throwable result = catchThrowable(()->{
            new Game(testWinningNumbers,testBonusNumber);
        });

        //then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }
}
