package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InputService {
    static private final String requestMoney ="구입금액을 입력해 주세요.";
    static private final String requestWinningNums ="당첨 번호를 입력해 주세요.";
    static private final String requestBonusNum ="보너스 번호를 입력해 주세요.";
    public int howMuchMoney(){
        System.out.println(requestMoney);
        String tempMoney = Console.readLine();
        ValidateService.validateNumber(tempMoney);
        int money = Integer.parseInt(tempMoney);
        return money;
    }

    public List<Integer> winningNumbers(){
        System.out.println(requestWinningNums);
        List<String> tempWinningNumbers = Arrays.asList(
                Console.readLine().split(",")
        );
        tempWinningNumbers.stream()
                .forEach(ValidateService::validateNumber);
        List<Integer> winningNumbers = tempWinningNumbers.stream()
                .map(Integer::parseInt).collect(Collectors.toList());
        ValidateService.validateNumbersInRange(winningNumbers);
        ValidateService.validateAuthorizedLength(winningNumbers);
        ValidateService.validateDuplicatedNums(winningNumbers);
        return winningNumbers;
    }

    public int bonusNumber(List<Integer> winningNumbers){
        System.out.println(requestBonusNum);
        String tempBonus = Console.readLine();
        ValidateService.validateNumber(tempBonus);
        int bonus = Integer.parseInt(tempBonus);
        ValidateService.validateBonusInWinningNums(bonus,winningNumbers);
        ValidateService.validateNumberInRange(bonus);
        ValidateService.validateDuplicatedNums(bonus,winningNumbers);
        return bonus;
    }

    public <T> T iterWhenException(Supplier<T> userInput){
        T input = null;
        try{
            input = userInput.get();
        }catch (IllegalArgumentException illegalArgumentException){
            return iterWhenException(userInput);
        }
        return input;
    }
}
