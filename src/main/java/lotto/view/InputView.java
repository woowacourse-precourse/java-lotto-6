package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.BonusNumber;

import java.util.List;

import static lotto.Validator.*;

public class InputView {

    public static final String purchaseAmountMessage = "구입 금액을 입력해 주세요.";
    public static final String WinningNumbersMessage = "당첨 번호를 입력해 주세요.";
    public static final String BonusNumberMessage = "보너스 번호를 입력해 주세요.";

    public int inputPurchaseAmount(){
        while(true){
            try{
                System.out.println(purchaseAmountMessage);
                String input = Console.readLine();
                System.out.println();

                validateNotEmptyInput(input);
                int amount = validateInputIsNumeric(input);
                validatePositiveNumber(amount);

                return amount;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }catch (Exception e){
                throw e;
            }
        }
    }

    public List<Integer> inputWinningNumber(){
        System.out.println(WinningNumbersMessage);
        String input = Console.readLine();
        System.out.println();

        validateNotEmptyInput(input);
        List<Integer> numbers = validateSplittedInput(input);
        return numbers;
    }

    public BonusNumber inputBonusNumber(){
        System.out.println(BonusNumberMessage);
        String input = Console.readLine();
        System.out.println();
        validateNotEmptyInput(input);
        int bonusNumber = validateInputIsNumeric(input);
        validatePositiveNumber(bonusNumber);
        return new BonusNumber(bonusNumber);
    }



}
