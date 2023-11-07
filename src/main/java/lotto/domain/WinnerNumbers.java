package lotto.domain;

import lotto.common.message.ExceptionMessage;
import lotto.common.utils.NumberUtil;
import lotto.validator.LottoBonusNumberValidator;
import lotto.validator.LottoWinnerNumberValidator;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class WinnerNumbers {

    private final List<Integer> numbers;
    private static final InputView inputView = new InputView();
    private static final LottoWinnerNumberValidator inputLottoWinnerNumberValidator = new LottoWinnerNumberValidator();
    private static final LottoBonusNumberValidator inputLottoBonusNumberValidator = new LottoBonusNumberValidator();


    public WinnerNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static List<String>  winnerNumbersValidateCheck(List<String> winnerNumbers){
        List<String> validWinnerNumbers = new ArrayList<>();
        for (String winnerNumber : winnerNumbers) {
            try{
                inputLottoWinnerNumberValidator.validateInputWinnerNumber(winnerNumber);
                validWinnerNumbers.add(winnerNumber);
            } catch (IllegalArgumentException error){
                System.out.println(error.getMessage());
                inputView.inputWinnerNumbers();
            }
        }
        if (validWinnerNumbers.size() == winnerNumbers.size()) {
            return uniqueWinnerNumber(validWinnerNumbers);
        } else {
            return inputView.inputWinnerNumbers();
        }
    }
    public static List<String> uniqueWinnerNumber(List<String> winnerNumbers) {
        List<String> numbers = new ArrayList<>();
        for (int i=0; i<winnerNumbers.size(); i++){
            numbers.add(winnerNumbers.get(i));
        }
        while (isWinnerNumbersDuplicate(numbers)){
            System.out.println(ExceptionMessage.DUPLICATED_NUMBER_CHECK);
            inputView.inputWinnerNumbers();
        }
        System.out.println();
        return numbers;
    }
    public static boolean isWinnerNumbersDuplicate(List<String> numbers) {
        List<String> distinctNumbers = numbers.stream()
                .distinct()
                .toList();
        return distinctNumbers.size() != NumberUtil.LOTTO_NUMBER_COUNT;
    }

    public static String bonusNumbersValidateCheck(String bonusNumber){
        try{
            inputLottoBonusNumberValidator.validateInputWinnerNumber(bonusNumber);
        } catch (IllegalArgumentException error){
            System.out.println(error.getMessage());
            inputView.inputBonusNumber();
        }
        return bonusNumber;
    }
    // 보너스 숫자가 winner과 다른지 확인
    public static boolean isBonusNumberDuplicateCheck(String bonusNumber, List<String> winnerNumbers ){
        for (int i=0; i<winnerNumbers.size(); i++){
            if(Integer.parseInt(winnerNumbers.get(i)) == Integer.parseInt(bonusNumber)){
                return false;
            }
        }
        return true;

    }
}
