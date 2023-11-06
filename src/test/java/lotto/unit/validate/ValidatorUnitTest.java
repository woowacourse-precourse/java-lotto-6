package lotto.unit.validate;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.dto.input.GetWinningNumberDto;
import lotto.util.exception.ErrorMessage;
import lotto.util.validate.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorUnitTest {

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void NotDistinctLottoNumbers(){
        //given
        String winningNumbers = "1,2,2,3,4,5";
        //when

        //then
        assertThatThrownBy(() -> Validator.checkWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.SHOULD_BE_DISTINCT.toString());
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void overSixLottoNumbers(){
        //given
        String winningNumbers = "1,2,3,4,5,6,7";
        //when

        //then
        assertThatThrownBy(() -> Validator.checkWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_SIX_NUMBER.toString());
    }

    @DisplayName("로또 번호가 1보다 작으면 예외가 발생한다.")
    @Test
    void lowerThanOneLottoNumber(){
        //given
        String winningNumbers = "-1,2,3,4,5,6,7";
        //when

        //then
        assertThatThrownBy(() -> Validator.checkWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_RIGHT_BOUNDARY.toString());
    }

    @DisplayName("로또 번호가 45보다 크면 예외가 발생한다.")
    @Test
    void BiggerThanFourtyFiveLottoNumber(){
        //given
        String winningNumbers = "46,2,3,4,5,6,7";
        //when

        //then
        assertThatThrownBy(() -> Validator.checkWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_RIGHT_BOUNDARY.toString());
    }

    @DisplayName("천원보다 아래의 금액은 예외가 발생한다.")
    @Test
    void lowerThanThousandBuyMoneys(){
        //given
        String buyMoneys = "100";
        //when

        //then
        assertThatThrownBy(() -> Validator.checkBuyMoney(buyMoneys))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_THOUSAND.toString());
    }

    @DisplayName("천원으로 나누어 떨어지지 않는 금액은 예외가 발생한다.")
    @Test
    void cantDivideWithThousandBuyMoneys(){
        //given
        String buyMoneys = "1100";
        //when

        //then
        assertThatThrownBy(() -> Validator.checkBuyMoney(buyMoneys))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_THOUSAND.toString());
    }

    @DisplayName("보너스 번호가 당첨 번호에 있으면 예외가 발생한다.")
    @Test
    void bonusNumberInWinningNumbers(){
        //given
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);
        nums.add(7);
        GetWinningNumberDto getWinningNumberDto = new GetWinningNumberDto(nums);
        String bonusNumber = "7";
        //when

        //then
        assertThatThrownBy(() -> Validator.checkBonusNumber(getWinningNumberDto,bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.SHOULD_NOT_SAME_WITH_WINNING_NUMBERS.toString());
    }

    @DisplayName("보너스 번호가 45보다 크면 예외가 발생한다.")
    @Test
    void biggerThenFourtyFiveBonusNumber(){
        //given
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);
        nums.add(7);
        GetWinningNumberDto getWinningNumberDto = new GetWinningNumberDto(nums);
        String bonusNumber = "46";
        //when

        //then
        assertThatThrownBy(() -> Validator.checkBonusNumber(getWinningNumberDto,bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_RIGHT_BOUNDARY.toString());
    }

    @DisplayName("보너스 번호가 1보다 작으면 예외가 발생한다.")
    @Test
    void lowerThenOneBonusNumber(){
        //given
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);
        nums.add(7);
        GetWinningNumberDto getWinningNumberDto = new GetWinningNumberDto(nums);
        String bonusNumber = "-1";
        //when

        //then
        assertThatThrownBy(() -> Validator.checkBonusNumber(getWinningNumberDto,bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_RIGHT_BOUNDARY.toString());
    }
}
