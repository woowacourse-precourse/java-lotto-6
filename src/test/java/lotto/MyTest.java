package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.*;

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
        List<Integer> inputWinningNumber = new ArrayList<>();
        inputWinningNumber.add(1); // 유효한 1을 추가한 상태
        String inputBonus = "2a";

        assertThatThrownBy(() -> {
            Application.inputBounsNumber(inputWinningNumber, inputBonus);
        }).isInstanceOf(NoSuchElementException.class);

    }

    @Test
    @DisplayName("보너스 번호 입력에서 Null 값 입력시 예외 발생")
    void testInputBounsNumberByNullPointerException(){
        List<Integer> inputWinningNumber = new ArrayList<>();
        inputWinningNumber.add(1); // 유효한 1을 추가한 상태
        String inputBonus = null;

        assertThatThrownBy(() -> {
            Application.inputBounsNumber(inputWinningNumber, inputBonus);
        }).isInstanceOf(NoSuchElementException.class);

    }

    @Test
    @DisplayName("보너스 번호 입력에서 중복되는 값을 입력하면 예외 발생")
    void testInputBounsNumberByIllegalArgumentException(){
        List<Integer> inputWinningNumber = new ArrayList<>();
        inputWinningNumber.add(1); // 유효한 1을 추가한 상태
        String inputBonus = "1";

        assertThatThrownBy(() -> {
            Application.inputBounsNumber(inputWinningNumber, inputBonus);
        }).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    @DisplayName("입력한 값이 만약 1~45를 벗어난 숫자일 경우 false")
    void testUserInputNumber(){
        boolean result = Application.userInputNumber(0);
        assertThat(result).isFalse();
        
    }

    @Test
    @DisplayName("입력한 보너스 번호가 1~45를 벗어난 숫자일 경우 예외 발생")
    void testAddBonusNumberByRange(){
        List<Integer> inputWinningNumber = new ArrayList<>();
        inputWinningNumber.add(1); // 유효한 1을 추가한 상태
        int inputBonus = 0;

        assertThatThrownBy(() -> {
            Application.addBonusNumber(inputWinningNumber, inputBonus);
        }).isInstanceOf(IllegalArgumentException.class).
        hasMessage("[ERROR] 1~45까지 중 에서 입력해주세요");
    }

    @Test
    @DisplayName("입력한 보너스 번호가 당첨번호와 중복되면 예외 발생")
    void testAddBonusNumberByContains(){
        List<Integer> inputWinningNumber = new ArrayList<>();
        inputWinningNumber.add(1); // 유효한 1을 추가한 상태
        int inputBonus = 1;

        assertThatThrownBy(() -> {
            Application.addBonusNumber(inputWinningNumber, inputBonus);
        }).isInstanceOf(IllegalArgumentException.class).
                hasMessage("[ERROR] 이미 추가된 번호입니다. 다시 시도하세요.");
    }

    @Test
    @DisplayName("이미 입력된 번호에 새로운 번호와 몇개가 일치하는지 출력하는 메소드")
    void testNumberMatches(){
        Map<Integer, List<Integer>> inputMap = new HashMap<>(); // 기존에 입력된 번호들
        List<Integer> inputList = new ArrayList<>(); // 기존에 입력한 번호와 매치할 번호

        inputMap.put(1, List.of(1,2,3));

        inputList.add(1);
        inputList.add(2);

        Map<Integer, Integer> result = Application.numberMatches(inputMap, inputList);

        assertTrue(result.values().stream().allMatch(value -> value.equals(2)));

    }

    @Test
    @DisplayName("번호가 있다면 true, 없다면 false")
    void testContainsBonusNumber(){
        Map<Integer, List<Integer>> inputMap = new HashMap<>(); // 기존에 입력된 번호들
        Integer inputBonus = 3;

        inputMap.put(1, List.of(1,2,3));

        boolean result = Application.containsBonusNumber(inputMap, inputBonus);
        assertThat(result).isTrue();

    }

    @Test
    @DisplayName("합한 값을 반환하는 메소드")
    void testCalculateTotalProfitRate(){
        Application.setSixMatchPrize(1); // 2000000000
        Application.setFiveMatchWithBonusPrize(1); // 30000000
        Application.setFiveMatchPrize(1); // 1500000
        Application.setFourMatchPrize(1); // 50000
        Application.setThreeMatchPrize(1); // 5000

        int sixMatchPrize = 2000000000 * Application.getSixMatchPrize();
        int fiveMatchWithBonusPrize = 30000000 * Application.getFiveMatchWithBonusPrize();
        int fiveMatchPrize = 1500000 * Application.getFiveMatchPrize();
        int fourMatchPrize = 50000 * Application.getFourMatchPrize();
        int threeMatchPrize = 5000 * Application.getThreeMatchPrize();

        double expectedTotalProfitRate = (sixMatchPrize + fiveMatchWithBonusPrize + fiveMatchPrize + fourMatchPrize + threeMatchPrize);

        double result = Application.calculateTotalProfitRate();
        assertThat(result).isEqualTo(expectedTotalProfitRate);
    }

    @Test
    @DisplayName("소수점 둘째자리까지 출력")
    void testCalculateProfitRate(){
        int input = 15000;

        Application.setFourMatchPrize(1); // 50000
        Application.setThreeMatchPrize(1); // 5000

        int fourMatchPrize = 50000 * Application.getFourMatchPrize();
        int threeMatchPrize = 5000 * Application.getThreeMatchPrize();

        Application.calculateProfitRate(input);

        double expectation = 366.67;

        assertEquals(expectation, Application.getStatistics(), 0.01);

    }

}
