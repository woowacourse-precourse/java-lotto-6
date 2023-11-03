package lotto.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserInputService {
    private static final String MONEY_INPUT_REQUEST = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_INPUT_REQUEST = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_REQUEST = "보너스 번호를 입력해 주세요.";

    private static final String MONEY_INPUT_REQUEST_ERROR_MESSAGE = "[ERROR] 1000으로 나누어 떨어지는 정수로 재입력 해주세요";

    private static final String WINNING_NUMBERS_INPUT_REQUEST_ERROR_MESSAGE = "[ERROR] 6가지 로또 번호를 똑바로 입력해 주세요";

    private static final String BONUS_NUMBERS_INPUT_REQUEST_ERROR_MESSAGE = "[ERROR] 중복되지 않는 정확한 숫자를 입력해 주세요";


    public Integer validMoneyInputRequest(){
        Integer money;
        while (true) {
            try {
                money = moneyInputRequest();
                System.out.println();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return money;
    }

    public Integer moneyInputRequest(){
        System.out.println(MONEY_INPUT_REQUEST);
        String input = readLine();
        if (!isNumber(input) || !checkDevisedBy1000(input)) {
            throw new IllegalArgumentException(MONEY_INPUT_REQUEST_ERROR_MESSAGE);
        }
        return Integer.parseInt(input);
    }


    public boolean isNumber(String input){
        try {
            Integer.parseInt(input);
            return true;
        }catch (Exception e){
            return false;
        }
    }


    public boolean checkDevisedBy1000(String input){
        return Integer.parseInt(input) % 1000 == 0;
    }


    public HashSet<Integer> validWinningNumbersInputRequest(){
        HashSet<Integer> validWinningNumbers;
        while (true) {
            try {
                validWinningNumbers = winningNumbersInputRequest();
                System.out.println();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return validWinningNumbers;
    }


    //차후 빠른 비교, 번호 중복 확인을 위해 HashSet<String>으로 반환
    public HashSet<Integer> winningNumbersInputRequest(){
        System.out.println(WINNING_NUMBERS_INPUT_REQUEST);
        List<String> numbers = parsingInputNumbers(readLine());
        if (consistOfNumberTest(numbers) == false ||
                sizeIsSixTest(numbers) == false ||
                numberInOneToFourtyFIve(numbers) == false)
            throw new IllegalArgumentException(WINNING_NUMBERS_INPUT_REQUEST_ERROR_MESSAGE);

        List<Integer> newNumbers = numbers.stream().map(num -> Integer.parseInt(num)).toList();
        return new HashSet<>(newNumbers);
    }


    public List<String> parsingInputNumbers(String input){
        return List.of(input.split(","));
    }


    public boolean consistOfNumberTest(List<String> input){
        for (String num : input) {
            if (isNumber(num) == false) {
                return false;
            }
        }
        return true;
    }


    public boolean sizeIsSixTest(List<String> input){
        Set<String> stringSet = new HashSet<>(input);
        return (stringSet.size() == 6);
    }


    public boolean numberInOneToFourtyFIve(List<String> input){
        for (String number: input) {
            int numberToInt = Integer.parseInt(number);
            if (1 > numberToInt || numberToInt > 45){
                return false;
            }
        }
        return true;
    }


    public Integer validBonusNumberInputRequest(Set<Integer> lottoNumbers){
        Integer bonusNumber;
        while (true) {
            try {
                bonusNumber = bonusNumberInputRequest(lottoNumbers);
                System.out.println();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNumber;
    }

    public Integer bonusNumberInputRequest(Set<Integer> lottoNumbers){
        System.out.println(BONUS_NUMBER_INPUT_REQUEST);
        String bonusNumber = readLine();
        if( isNumber(bonusNumber) == false ||
                bonusNumberNotInLottoNumbers(lottoNumbers, Integer.parseInt(bonusNumber)) == false ||
                numberInOneToFourtyFIve(List.of(bonusNumber)) == false)
            throw new IllegalArgumentException(BONUS_NUMBERS_INPUT_REQUEST_ERROR_MESSAGE);
        return Integer.parseInt(bonusNumber);
    }


    public boolean bonusNumberNotInLottoNumbers(Set<Integer> lottoNumbers, Integer bonusNumber){
        return lottoNumbers.contains(bonusNumber) == false;
    }


}
