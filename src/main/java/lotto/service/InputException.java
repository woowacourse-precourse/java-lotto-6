package lotto.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.InputConstant;
import lotto.constant.NumberConstant;

public class InputException {
    public static int validMoney(String input){
        int money = validMoneyInteger(input);
        validMoneyPositive(money);
        validMoneyDivide(money);

        return money;
    }

    public static List<Integer> validLotto(String input){
        List<String> strArr = validLottoSeperate(input);
        List<Integer> numbers = validLottoInteger(strArr);
        validLottoLength(numbers);
        validLottoNumberRange(numbers);
        validLottoDuplicate(numbers);

        return numbers;
    }

    public static int validBonus(String input, List<Integer> numbers){
        int number = validBonusInteger(input);
        validBonusRange(number);
        validBonusDuplicate(number, numbers);

        return number;
    }

    private static int validMoneyInteger(String input){
        try{
            return Integer.parseInt(input);
        } catch (NumberFormatException ex){
            throw new IllegalArgumentException();
        }
    }

    private static void validMoneyPositive(int money){
        if (money >= NumberConstant.DEFAULT_VALUE){
            throw new IllegalArgumentException();
        }
    }

    private static void validMoneyDivide(int money){
        if (money % NumberConstant.LOTTO_PRICE != NumberConstant.DEFAULT_VALUE){
            throw new IllegalArgumentException();
        }
    }

    private static boolean isLottoContainBlank(String input){
        return input.contains(InputConstant.BLANK.getValue());
    }

    private static List<String> validLottoSeperate(String input){
        String[] strArr = input.split(InputConstant.SEPERATOR.getValue());
        return new ArrayList<String>(Arrays.asList(strArr));
    }

    private static List<Integer> validLottoInteger(List<String> strArr){
        List<Integer> lottoNumbers = new ArrayList<>();
        for(String str : strArr){
            if (isLottoContainBlank(str)){
                throw new IllegalArgumentException();
            }
            try{
                lottoNumbers.add(Integer.parseInt(str));
            } catch(NumberFormatException ex){
                throw new IllegalArgumentException();
            }
        }
        return lottoNumbers;
    }

    private static void validLottoLength(List<Integer> numbers){
        if (numbers.size() != NumberConstant.LOTTO_RANGE){
            throw new IllegalArgumentException();
        }
    }

    private static void validLottoNumberRange(List<Integer> numbers){
        for (int number : numbers){
            if (number < NumberConstant.MIN_NUMBER || number > NumberConstant.MAX_NUMBER){
                throw new IllegalArgumentException();
            }
        }
    }

    private static void validLottoDuplicate(List<Integer> numbers){
        Set<Integer> sNumbers = new HashSet<>(numbers);
        if (sNumbers.size() != numbers.size()){
            throw new IllegalArgumentException();
        }
    }

    private static int validBonusInteger(String input){
        try{
            return Integer.parseInt(input);
        } catch(NumberFormatException ex){
            throw new IllegalArgumentException();
        }
    }

    private static void validBonusRange(int number){
        if (number < NumberConstant.MIN_NUMBER || number > NumberConstant.MAX_NUMBER){
            throw new IllegalArgumentException();
        }
    }

    private static void validBonusDuplicate(int number, List<Integer> numbers){
        Set<Integer> sNumbers = new HashSet<>(numbers);
        sNumbers.add(number);
        if(sNumbers.size() != numbers.size() + 1){
            throw new IllegalArgumentException();
        }
    }
}
