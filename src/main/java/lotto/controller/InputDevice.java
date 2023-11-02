package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.ErrorMessage;
import lotto.view.Printer;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputDevice {
    public Integer inputLottoPurchasePayment(){
        while(true){
            Printer.printInputLottoPurchasePayment();
            try{
                String inputValue = Console.readLine();
                checkIsNumber(inputValue);
                Integer lottoPurchasePayment = Integer.valueOf(inputValue);
                checkValidLottoPurchasePayment(lottoPurchasePayment);
                return lottoPurchasePayment;
            } catch (IllegalArgumentException e){
                Printer.printErrorMessage(ErrorMessage.INVALID_PURCHASE_PAYMENT.getMessage());
            }
        }
    }

    public List<Integer> inputWinningNumbers(){
        while(true){
            Printer.printInputWinningNumbers();
            try{
                String inputValue = Console.readLine();
                String[] row = inputValue.split(",");
                checkIsNumberList(row);
                List<Integer> numbers = parsingNumbers(row);
                checkValidWinningLotto(numbers);
                return numbers;
            } catch (IllegalArgumentException e){
                Printer.printErrorMessage(ErrorMessage.INVALID_WINNING_LOTTO.getMessage());
            }
        }
    }

    public Integer inputBonusNumber(List<Integer> winningNumbers){
        while(true){
            Printer.printInputBonusNumber();
            try{
                String inputValue = Console.readLine();
                checkIsNumber(inputValue);
                Integer bonusNumber = Integer.valueOf(inputValue);
                checkValidLottoNumber(bonusNumber);
                checkIsContainBonusNumberInWinningNumber(bonusNumber, winningNumbers);
                return bonusNumber;
            } catch (IllegalArgumentException e){
                Printer.printErrorMessage(ErrorMessage.INVALID_BONUS_NUMBER.getMessage());
            }
        }
    }


    private void checkIsNumber(String inputValue){
        String regex = "^[1-9]\\d*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputValue);
        if(!matcher.matches()){
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.getMessage());
        }
    }

    private void checkValidLottoPurchasePayment(Integer number){
        int term = number % 1_000;
        if(term != 0){
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_PAYMENT.getMessage());
        }
    }

    private List<Integer> parsingNumbers(String[] row) {
        return Arrays.stream(row).toList().stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    private void checkIsNumberList(String[] row){
        for(String number : row){
            checkIsNumber(number);
        }
    }

    private void checkValidWinningLotto(List<Integer> numbers){
        for(int number : numbers){
            checkValidLottoNumber(number);
        }
        if(numbers.size() != 6){
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_LOTTO.getMessage());
        }
    }

    private void checkValidLottoNumber(Integer number){
        if(!(1 <= number && number <= 45)){
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER.getMessage());
        }
    }

    private void checkIsContainBonusNumberInWinningNumber(Integer bonusNumber, List<Integer> winningNumbers){
        if(winningNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER.getMessage());
        }
    }
}
