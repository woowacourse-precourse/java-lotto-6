package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MyTest {

    @Test
    @DisplayName("입력한 값이 Null 이면 예외가 발생한다.")
    void createUserInputByNull(){
        assertThatThrownBy(() -> Application.moneyDiscrimination(null)).
                isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("입력한 값이 1000단위가 아니라면 예외가 발생한다.")
    void createUserInputByIncorrectAmount(){
        assertThatThrownBy(() -> Application.moneyDiscrimination(1300)).
                isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사용자가 정확히 맞는 돈을 넣으면 예외가 발생하지 않음.")
    void testInputMoney(){

        String inputMoney = "1000";

        Integer money = Application.inputMoney(inputMoney);

        assertThat(money).isEqualTo(1000);

    }

    @Test
    @DisplayName("입력된 돈을 횟수로 치환하는 메소드")
    void testMoneyReplaceCount(){
        int money = 1000;

        int count = Application.moneyReplaceCount(money);

        assertThat(count).isEqualTo(1);

    }

    @Test
    @DisplayName("입력된 횟수 만큼 랜덤 값을 출력")
    void testGenerateAndDisplayNumbers(){
        int count = 3;

        Map<Integer, List<Integer>> result = Application.generateAndDisplayNumbers(count);

        assertThat(result.size()).isEqualTo(3);

    }

    @Test
    @DisplayName("입력한 번호에서 콤마를 구분으로 나누고, 공백제거")
    void testInputWinningNumber1(){
        String input = "1, 2, 3, 4, 5, 6     ";
        List<Integer> result = Application.inputWinningNumber(input);

        assertThat(result.toString()).isNotNull().isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    @DisplayName("입력한 번호에서 숫자로 변환이 안되면 예외 발생")
    void testinputWinningNumberVerification(){
        String[] input = {"1","2","3","4","5","6a"};
        List<Integer> intNumbers = new ArrayList<>();

        boolean result = Application.checkWinningNumberValidity(input, intNumbers);
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("사용자가 입력하는 당첨금액이 맞게 입력했는지 검증")
    void testInputWinningNumberVerification(){
        List<Integer> inputWinningNumber = new ArrayList<>();
        inputWinningNumber.add(1); // 유효한 1을 추가한 상태

        assertThatThrownBy(() -> {
            Application.inputWinningNumberVerification(inputWinningNumber);
        }).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    @DisplayName("보너스 번호 입력에서 숫자로 변환이 안되면 예외 발생")
    void testInputBounsNumberByNumberFormatException(){

    }

    @Test
    void testUserInputNumber(){
//        boolean b = Application.userInputNumber(1);
//        assertThat(b).isTrue();


    }

    @Test
    @DisplayName("소수점 둘째자리까지 출력")
    void testCalculateTotalProfitRate(){

        int sixMatchPrize = 2000000;
        int fiveMatchWithBonusPrize = 3000000;
        int fiveMatchPrize = 100000;
        int fourMatchPrize = 5000;
        int threeMatchPrize = 200;

        PrizeCategory.MATCHES_SIX.setPrizeAmount(sixMatchPrize);
        PrizeCategory.MATCHES_FIVE_BONUS.setPrizeAmount(fiveMatchWithBonusPrize);
        PrizeCategory.MATCHES_FIVE.setPrizeAmount(fiveMatchPrize);
        PrizeCategory.MATCHES_FOUR.setPrizeAmount(fourMatchPrize);
        PrizeCategory.MATCHES_THREE.setPrizeAmount(threeMatchPrize);

        double expectedTotalProfitRate = (sixMatchPrize + fiveMatchWithBonusPrize + fiveMatchPrize + fourMatchPrize + threeMatchPrize);

        assertEquals(expectedTotalProfitRate, Application.calculateTotalProfitRate(), 0.01);
    }

}
