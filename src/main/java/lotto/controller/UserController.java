package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class UserController {

    public static int getMoney() {
        String input;
        while(true){
            try{
                input = InputView.inputPurchaseAmount();
                NumberValidator.isNumber(input);
                NumberValidator.isNaturalNumber(input);
                NumberValidator.isDivisible(input);
                break;
            }catch (IllegalArgumentException exception){
                System.out.println(exception.getMessage());
            }
        }
        return Integer.parseInt(input);
    }

    public static List<Integer> getWinningNumbers() {
        List<Integer> winningNumbers;
        while(true){
            try{
                String input = InputView.inputWinningNumbers();
                winningNumbers = parsingString(input);
                InputNumbersValidator.isNumbers(winningNumbers);
//                RandomNumbersGenerator.isNaturalNumbers(winningNumbers);
                InputNumbersValidator.isPrperRange(winningNumbers);
                InputNumbersValidator.isSizeSix(winningNumbers);
                InputNumbersValidator.isDuplicated(winningNumbers);
                break;
            }catch (IllegalArgumentException exception){
                System.out.println(exception.getMessage());
            }
        }
        return winningNumbers;
    }

    private static List<Integer> parsingString(String input) {
        String[] arr = input.split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for(String number : arr){
            winningNumbers.add(Integer.valueOf(number));
        }
        return winningNumbers;
    }

    public static int getBonusNumber(List<Integer> winningNumbers) {
        String input;
        while(true){
            try{
                input = InputView.inputBonusNumber();
                NumberValidator.isNumber(input);
                NumberValidator.isProperRange(input);
                NumberValidator.isDuplicated(input, winningNumbers);
                break;
            }catch (IllegalArgumentException exception){
                System.out.println(exception.getMessage());
            }
        }
        return Integer.parseInt(input);
    }
}
