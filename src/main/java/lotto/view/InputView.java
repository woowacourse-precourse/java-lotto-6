package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.IllegalArgumentExceptionHandler;
import lotto.view.validator.InputViewValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private final InputViewValidator inputViewValidator;
    private final IllegalArgumentExceptionHandler illegalArgumentExceptionHandler;

    public InputView(InputViewValidator inputViewValidator, IllegalArgumentExceptionHandler illegalArgumentExceptionHandler){
        this.inputViewValidator = inputViewValidator;
        this.illegalArgumentExceptionHandler = illegalArgumentExceptionHandler;
    }
    //구입금액입력
    public Long inputTotalAmount(){
        try{
            String string = Console.readLine();
            inputViewValidator.validateTotalAmount(string);
            Long totalAmount = Long.parseLong(string);
            return totalAmount;
        } catch (IllegalArgumentException e){
            illegalArgumentExceptionHandler.handleException(e);
            return inputTotalAmount();
        }
    }
    //당첨번호
    public List<Integer> inputWinnerNumbers(){
        try{
            String string = Console.readLine();
            inputViewValidator.validateWinnerNumbers(string);
            List<Integer> winnerNumberList = Arrays.stream(string.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            return winnerNumberList;
        } catch (IllegalArgumentException e){
            illegalArgumentExceptionHandler.handleException(e);
            return inputWinnerNumbers();
        }
    }
    //보너스번호
    public Integer inputBonusNumber(List<Integer> numbers){
        try{
            String string = Console.readLine();
            inputViewValidator.validateBonusNumber(string,numbers);
            Integer bonusNumber = Integer.parseInt(string);
            return bonusNumber;
        } catch (IllegalArgumentException e){
            illegalArgumentExceptionHandler.handleException(e);
            return inputBonusNumber(numbers);
        }
    }
}
