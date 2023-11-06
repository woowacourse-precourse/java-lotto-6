package io;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserInputValidateTest {

    @DisplayName("userMoneyAmount 메서드로 로또 구입 금액의 유효성을 검사한다(자연수이며 1000의 배수인지)")
    @Test
    void 로또_구입금액_테스트_희망편() {
        String money = "2000";

        int result = UserInputValidate.userMoneyAmount(money);

        Assertions.assertThat(result).isEqualTo(2000);
    }

    @DisplayName("로또 구입 금액에 정수가 아닌 수를 넣으면 에러가 난다.")
    @Test
    void 로또_구입금액_에러편_정수가아닌수() {
        String money = "가나";

        Assertions.assertThatThrownBy(() -> UserInputValidate.userMoneyAmount(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력 금액은 정수여야 합니다.");
    }

    @DisplayName("로또 구입 금액에 음수를 넣으면 에러가 난다.")
    @Test
    void 로또_구입금액_에러편_음수() {
        String money = "-2000";

        Assertions.assertThatThrownBy(() -> UserInputValidate.userMoneyAmount(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력 금액은 자연수여야 합니다.");
    }

    @DisplayName("로또 구입 금액에 1000의 배수가 아닌 수를 넣으면 에러가 난다.")
    @Test
    void 로또_구입금액_에러편_1000의배수가아님() {
        String money = "1050";

        Assertions.assertThatThrownBy(() -> UserInputValidate.userMoneyAmount(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력 금액은 1000의 배수여야 합니다.");
    }

    @DisplayName("당첨 로또 번호의 유효성을 검사한다.")
    @Test
    void 당첨_로또_번호_희망편() {
        String winningLotteryInput = "1,2,3,4,5,6";

        List<String> result = UserInputValidate.winLotteryRange(winningLotteryInput);

        Assertions.assertThat(result).containsExactly("1","2","3","4","5","6");
    }


    @DisplayName("당첨 로또 번호가 숫자가 아니면 에러가 난다.")
    @Test
    void 당첨_로또_번호_문자() {
        String winningLotteryInput = "1,2,3,4,5,가";

        Assertions.assertThatThrownBy(() -> UserInputValidate.winLotteryRange(winningLotteryInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 숫자여야 합니다");
    }

    @DisplayName("당첨 로또 번호가 범위를 벗어나면 에러가 난다.")
    @Test
    void 당첨_로또_번호_범위() {
        String winningLotteryInput = "1,2,3,4,5,46";

        Assertions.assertThatThrownBy(() -> UserInputValidate.winLotteryRange(winningLotteryInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호의 범위는 1부터 45까지입니다.");
    }

    @DisplayName("당첨 로또 번호에 중복된 숫자가 있으면 에러가 난다.")
    @Test
    void 당첨_로또_번호_중복() {
        String winningLotteryInput = "1,2,2,4,5,6";

        Assertions.assertThatThrownBy(() -> UserInputValidate.winLotteryDuplicateAndLength(winningLotteryInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 숫자에는 중복된 수가 없어야 합니다.");
    }

    @DisplayName("당첨 로또 번호가 6개가 아니면 에러가 난다.")
    @Test
    void 당첨_로또_번호_길이() {
        String winningLotteryInput = "1,2,3,4,5";

        Assertions.assertThatThrownBy(() -> UserInputValidate.winLotteryDuplicateAndLength(winningLotteryInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 숫자는 6개 입니다.");
    }

    @DisplayName("당첨 로또 번호가 유효하면 리스트로 만든다.")
    @Test
    void 당첨_로또_번호_리스트_생성() {
        List<String> winningLottery = Arrays.asList("1","2","3","4","5","6");

        List<Integer> result = UserInputValidate.makeWinningLottery(winningLottery);

        Assertions.assertThat(result).containsExactly(1,2,3,4,5,6);
    }

    @DisplayName("보너스 번호가 유효하면 return 한다.")
    @Test
    void 보너스_번호_희망편() {
        String bonusInput = "6";
        List<Integer> winningLotteryNum = Arrays.asList(1,2,3,4,30,8);

        int result = UserInputValidate.bonusNumCheck(bonusInput, winningLotteryNum);

        Assertions.assertThat(result).isEqualTo(6);
    }

    @DisplayName("보너스 번호가 정수가 아닌 경우 에러가 난다.")
    @Test
    void 보너스_번호_정수가_아닌_수() {
        String bonusInput = "가";
        List<Integer> winningLotteryNum = Arrays.asList(1,2,3,4,30,8);

        Assertions.assertThatThrownBy(() -> UserInputValidate.bonusNumCheck(bonusInput, winningLotteryNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 정수여야 합니다.");
    }

    @DisplayName("보너스 번호가 당청 로또 번호와 중복되는 경우 에러가 난다.")
    @Test
    void 보너스_번호_중복() {
        String bonusInput = "30";
        List<Integer> winningLotteryNum = Arrays.asList(1,2,3,4,30,8);

        Assertions.assertThatThrownBy(() -> UserInputValidate.bonusNumCheck(bonusInput, winningLotteryNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호와 당첨 로또 번호는 중복되면 안됩니다.");
    }

    @DisplayName("보너스 번호의 범위가 1-45가 아닌 경우 에러가 난다.")
    @Test
    void 보너스_번호_범위() {
        String bonusInput = "46";
        List<Integer> winningLotteryNum = Arrays.asList(1,2,3,4,30,8);

        Assertions.assertThatThrownBy(() -> UserInputValidate.bonusNumCheck(bonusInput, winningLotteryNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호의 범위는 1부터 45까지입니다.");
    }
}