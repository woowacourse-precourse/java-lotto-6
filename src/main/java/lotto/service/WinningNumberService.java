package lotto.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.service.exception.IllegalArgumentExceptionHandler;
import lotto.service.exception.NumberFormattingExceptionHandler;
import lotto.service.exception.InputErrorMessage;

public class WinningNumberService {

    private BuyingLottoService buyingLottoService = new BuyingLottoService();

    public List<Integer> validateWinningNumber(String input){
        List<String> inputNumber = convertToList(input);
        List<Integer> winningNumber;
        try {
            verifyNumberSize(inputNumber);
            verifyNumberFormat(inputNumber);
            winningNumber = convertStringListToInt(inputNumber);
            verifyRange(winningNumber);
            verifyDuplication(winningNumber);
        } catch (NumberFormattingExceptionHandler | IllegalArgumentExceptionHandler e){
            System.out.println(e.getMessage());
            return null;
        }
        return winningNumber;
    }

    public int validateBonusNumber(String inputNumber){
        int bonusNumber;
        try{
            bonusNumber = buyingLottoService.convertStringtoInt(inputNumber);
            verifyRange(bonusNumber);
        }catch (NumberFormattingExceptionHandler | IllegalArgumentExceptionHandler e){
            System.out.println(e.getMessage());
            return -1;
        }
        return bonusNumber;
    }

    private List convertToList(String number){
        return Arrays.stream(number.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }
    private void verifyNumberSize(List<String> winningNumber) {
        if (winningNumber.size() != 6) {
            throw new IllegalArgumentExceptionHandler(InputErrorMessage.WRONG_NUMBER_SIZE);
        }
    }
    private void verifyNumberFormat(List<String> winningNumber){
        try{
            for(String number : winningNumber){
                Integer.parseInt(number);
            }
        }catch(NumberFormatException e){
            throw new NumberFormattingExceptionHandler(InputErrorMessage.INVALID_NUMBER);
        }
    }
    private List convertStringListToInt(List<String> numbers){
        List<Integer> winningNumber = new ArrayList<>();
        for(String number : numbers){
            winningNumber.add(Integer.parseInt(number));
        }
        return winningNumber;
    }

    private void verifyRange(List<Integer> winningNumber){
        for(int x : winningNumber){
            if(x<1 || x>45){
                throw new IllegalArgumentExceptionHandler(InputErrorMessage.WRONG_NUMBER_RANGE);
            }
        }
    }
    private void verifyRange(int bonusNumber){
        if(bonusNumber<1 || bonusNumber>45){
            throw new IllegalArgumentExceptionHandler(InputErrorMessage.WRONG_NUMBER_RANGE);
        }
    }
    private void verifyDuplication(List<Integer> winningNumber){
        Set<Integer> checkDuplication = new HashSet<>();
        for(int number : winningNumber){
            if(checkDuplication.contains(number)){
                throw new IllegalArgumentExceptionHandler(InputErrorMessage.DUPLICATE_NUMBER);
            }
            checkDuplication.add(number);
        }
    }
}
