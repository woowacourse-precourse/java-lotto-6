package lotto.validation;

import lotto.model.WinningNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ValidationUtilsTest {
    private ValidationUtils validationUtils = new ValidationUtils();

    @Test
    public void 유저_입력금액_검증_테스트() {
        //given
        String input1 = "500";
        String input2 = "7000";
        String input3 = "13400";
        String input4 = "a";

        //when
        boolean isValid1 = validationUtils.validateUserAmount(input1);
        boolean isValid2 = validationUtils.validateUserAmount(input2);
        boolean isValid3 = validationUtils.validateUserAmount(input3);
        boolean isValid4 = validationUtils.validateUserAmount(input4);

        //then
        Assertions.assertThat(isValid1).isFalse();
        Assertions.assertThat(isValid2).isTrue();
        Assertions.assertThat(isValid3).isFalse();
        Assertions.assertThat(isValid4).isFalse();
    }

    @Test
    public void 입력_당첨번호_검증_테스트() {
        //given
        String input1 = "1,2,3,4,5,6";
        String input2 = "";
        String input3 = "1,2,8,9,20,45,";
        String input4 = ",6,8,2,1,3,25";
        String input5 = "14,5,7,2,,19,4";
        String input6 = "7,36, 8,10,22,17";
        String input7 = "7,36,8,10,22,47";
        String input8 = "3,3,8,10,22,17";
        String input9 = "7,36,8,10,22";

        //when
        boolean isValid1 = validationUtils.validateWinningNumber(input1);
        boolean isValid2 = validationUtils.validateWinningNumber(input2);
        boolean isValid3 = validationUtils.validateWinningNumber(input3);
        boolean isValid4 = validationUtils.validateWinningNumber(input4);
        boolean isValid5 = validationUtils.validateWinningNumber(input5);
        boolean isValid6 = validationUtils.validateWinningNumber(input6);
        boolean isValid7 = validationUtils.validateWinningNumber(input7);
        boolean isValid8 = validationUtils.validateWinningNumber(input8);
        boolean isValid9 = validationUtils.validateWinningNumber(input9);

        //then
        Assertions.assertThat(isValid1).isTrue();
        Assertions.assertThat(isValid2).isFalse();
        Assertions.assertThat(isValid3).isFalse();
        Assertions.assertThat(isValid4).isFalse();
        Assertions.assertThat(isValid5).isFalse();
        Assertions.assertThat(isValid6).isFalse();
        Assertions.assertThat(isValid7).isFalse();
        Assertions.assertThat(isValid8).isFalse();
        Assertions.assertThat(isValid9).isFalse();
    }

    @Test
    public void 입력_보너스번호_검증_테스트() {
        //given
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));
        String input1 = "7";
        String input2 = "";
        String input3 = "46";
        String input4 = "4";

        //when
        boolean isValid1 = validationUtils.validateBonusNumber(winningNumber, input1);
        boolean isValid2 = validationUtils.validateBonusNumber(winningNumber, input2);
        boolean isValid3 = validationUtils.validateBonusNumber(winningNumber, input3);
        boolean isValid4 = validationUtils.validateBonusNumber(winningNumber, input4);

        //then
        Assertions.assertThat(isValid1).isTrue();
        Assertions.assertThat(isValid2).isFalse();
        Assertions.assertThat(isValid3).isFalse();
        Assertions.assertThat(isValid4).isFalse();
    }
}
