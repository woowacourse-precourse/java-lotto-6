package lotto.utils;

import lotto.exception.AlreadyExistNumberException;
import lotto.exception.InvalidInputException;
import lotto.exception.InvalidRangeNumberException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoInputValidator {

    public boolean isNumericValidation(String number){
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }
    public boolean isNumberRangeValidation(String numberAsString){
        int number = Integer.parseInt(numberAsString);
        return number >= 1 && number < 46;
    }


    public boolean isDuplicationNumber(String number, List<Integer> winningNumbers){
        return winningNumbers.contains(number);
    }

    public boolean isDuplicationNumber(List<Integer> lottoTicket,
                                       int bonusNumber){
        List<Integer> withDuplicates = getWithDuplicates(lottoTicket, bonusNumber);
        List<Integer> withoutDuplicates = getWithoutDuplicates(withDuplicates);

        if (withoutDuplicates.size()<7){
            return false;
        }
        return true;
    }


    public List<Integer> checkWinningNumbersValidate(List<String> withSplitLottoNumbers) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : withSplitLottoNumbers) {
            if(!isNumericValidation(number)){
                throw new InvalidInputException("[Error] 숫자만 입력해주세요.");
            } else if(!isNumberRangeValidation(number)){
                throw new InvalidRangeNumberException();
            } else if(isDuplicationNumber(number, winningNumbers)){
                throw new AlreadyExistNumberException();
            }
            winningNumbers.add(Integer.valueOf(number));
        }

        return winningNumbers;
    }
    public int checkBonusNumberValidate(String bonusNumber, List<Integer> winningNumbers) {
        if (!isNumericValidation(bonusNumber)){
            throw new InvalidInputException("[Error] 보너스 번호는 숫자만 입력해주세요.");
        } else if (!isNumberRangeValidation(bonusNumber)){
            throw new InvalidRangeNumberException();
        } else if (!isDuplicationNumber(winningNumbers, Integer.parseInt(bonusNumber))){
            throw new AlreadyExistNumberException();
        }

        return Integer.parseInt(bonusNumber);
    }


    private static List<Integer> getWithoutDuplicates(List<Integer> withDuplicates) {
        return withDuplicates.stream().distinct().collect(Collectors.toList());
    }

    private static List<Integer> getWithDuplicates(List<Integer> winningNumbers,
                                                   int bonusNumber) {
        // 해당 로또 [1,2,3,4,5,6] 보너스 7을 예시로 중복 값이 있나 확인하는 작업 진행
        List<Integer> withDuplicates = winningNumbers;
        withDuplicates.add(bonusNumber);
        return withDuplicates;
    }

}
