package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String ENTER_PURCHASE_AMOUNT="구입금액을 입력해주세요.";
    private static final String ENTER_WINNING_NUMBER="당첨번호를 입력해주세요.";
    private static final String ENTER_BONUS_NUMBER="보너스 번호를 입력해주세요.";

    public int inputPurchaseAmount(){
        System.out.println(ENTER_PURCHASE_AMOUNT);
        String purchaseAmount = Console.readLine();
        return convertStringToInt(purchaseAmount);
    }
    public List<Integer> inputWinningNumbers(){
        System.out.println(ENTER_WINNING_NUMBER);
        String numbers = Console.readLine();
        return convertStringarraytoIntList(numbers);
    }
    public int inputBonusNumber(){
        System.out.println(ENTER_BONUS_NUMBER);
        String bonusNumber = Console.readLine();
        return convertStringToInt(bonusNumber);
    }
    public int convertStringToInt(String number) throws NumberFormatException{
        int changeNum = 0;
        try {
            changeNum = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ErrorMessage.NOT_FORMAT_NUMBER.getMessage());
        }
        return changeNum;

    }
    public List<Integer> convertStringarraytoIntList(String numbers){
        List<Integer> number = Arrays.stream(numbers.split(","))
                                         .mapToInt(Integer::parseInt)
                                            .boxed()
                                             .collect(Collectors.toList());
        return number;
    }


}
