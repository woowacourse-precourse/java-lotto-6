package lotto.view;

import lotto.util.ValidatorLotto;
import lotto.util.Parser;
import lotto.util.Validator;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Input {
    public int inputValidateNumberOfLotto(int lottoPrice) {
        boolean isValidate = false;
        String input = "";

        while(!isValidate) {
            input = inputBuyPrice();
            isValidate = isValidateBuyPrice(input);
        }
        return Integer.parseInt(input) / lottoPrice;
    }

    public String inputValidateWinningNumbers() {
        boolean isValidate = false;
        String input = "";

        while(!isValidate) {
            input = inputWinningNumbers();
            isValidate = isValidateWinningNumbers(input);
        }
        return input;
    }

    public String inputValidateBonusNumber(List<Integer> winningNumbers) {
        boolean isValidate = false;
        String input = "";

        while(!isValidate) {
            input = inputBonusNumber();
            isValidate = isValidateBonusNumber(winningNumbers, input);
        }
        return input;
    }

    private boolean isValidateBuyPrice(String input) {
        try{
            Validator.validateRemainderNumber(input);
            return true;
        }catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private boolean isValidateWinningNumbers(String input) {
        try{
            ValidatorLotto.validateLottoNumbers(Parser.getSplitLottoNumber(input));
            return true;
        }catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private boolean isValidateBonusNumber(List<Integer> winningNumbers, String input) {
        try{
            Validator.validateBonusNumber(input);
            ValidatorLotto.validateWinningNumber(winningNumbers, Integer.parseInt(input));
            return true;
        }catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private String inputBuyPrice() {
        System.out.println(EnumOutput.REQUEST_BUY_MONEY.getMessage());
        return Console.readLine();
    }

    private String inputWinningNumbers() {
        System.out.println("\n" + EnumOutput.REQUEST_WINNING_NUMBERS.getMessage());
        return Console.readLine();
    }

    private String inputBonusNumber() {
        System.out.println("\n" + EnumOutput.REQUEST_BONUS_NUMBER.getMessage());
        return Console.readLine();
    }
}