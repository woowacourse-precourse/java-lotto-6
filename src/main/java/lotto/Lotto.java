package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    
    // 잘못 된 입력이 들어왔을 경우 -1 반환
    public static int inputBuyMoney() {
        System.out.println("구입 금액을 입력해주세요.");

        String input = Console.readLine();
        int money = validateBuyMoney(input);
        return money;
    }

    private static int validateBuyMoney(String input) {
        int money = -1;

        money = Integer.parseInt(input);

        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000으로 나누어 떨어져야 합니다.");
        }
        return money;
    }


    public static List<Integer> inputCorrectNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");

        List<Integer> numbers = new ArrayList<>();

        String input = Console.readLine();

        for(String str : input.split(",")){
            numbers.add(Integer.parseInt(str));
        }

        validateCorrectNumbers(numbers);

        return numbers;
    }

    private static void validateCorrectNumbers(List<Integer> numbers) {
        if(numbers.size() != 6){
            throw new IllegalArgumentException("[ERROR] 당첨번호는 6개 입력해야 합니다.");
        }

        for (Integer number : numbers) {
            if(number > 45 || number < 1){
                throw new IllegalArgumentException("[ERROR] 숫자의 범위는 1 ~ 45 사이여야 합니다.");
            }
        }

        Set<Integer> validSet = new HashSet<>(numbers);
        if(validSet.size() != 6){
            throw new IllegalArgumentException("[ERROR] 당첨번호는 중복 없이 6개 입력해야 합니다.");
        }
    }

    public void printLotto(){
        System.out.println(this.numbers);
    }

    public static Integer inputBonusNumber(List<Integer> correctNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");

        String input = Console.readLine();

        Integer bonusNumber = Integer.parseInt(input);

        validateBonusNumber(correctNumbers, bonusNumber);

        return bonusNumber;
    }

    private static void validateBonusNumber(List<Integer> correctNumbers, Integer bonusNumber) {
        if(bonusNumber < 1 || bonusNumber > 45){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1 ~ 45 숫자를 입력해야 합니다.");
        }

        if(correctNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되면 안됩니다.");
        }
    }


}
