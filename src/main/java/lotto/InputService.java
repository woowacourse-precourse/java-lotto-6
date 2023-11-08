package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InputService {

    public static Integer howMuchMoney(){
        OutputService.requestMoney();
        String tempMoney = Console.readLine();
        ValidateService.validateNumber(tempMoney);
        int money = Integer.parseInt(tempMoney);
        return money;
    }

    public static List<Integer> winningNumbers(){
        OutputService.requestWinningNums();
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

    public static Integer bonusNumber(List<Integer> winningNumbers){
        OutputService.requestBonusNum();
        String tempBonus = Console.readLine();
        ValidateService.validateNumber(tempBonus);
        Integer bonus = Integer.parseInt(tempBonus);
        ValidateService.validateBonusInWinningNums(bonus,winningNumbers);
        ValidateService.validateNumberInRange(bonus);
        ValidateService.validateDuplicatedNums(bonus,winningNumbers);
        return bonus;
    }

    public static  <T> T iterWhenException(Supplier<T> supplier){
        T input = null;
        try{
            input = supplier.get();
        }catch (IllegalArgumentException illegalArgumentException){
            System.out.println(illegalArgumentException.getMessage());
            return iterWhenException(supplier);
        }
        return input;
    }

    public static  <T,R> R iterWhenException(Function<T,R> supplier,T t){
        R input = null;
        try{
            input = supplier.apply(t);
        }catch (IllegalArgumentException illegalArgumentException){
            System.out.println(illegalArgumentException.getMessage());
            return iterWhenException(supplier,t);
        }
        return input;
    }
}
