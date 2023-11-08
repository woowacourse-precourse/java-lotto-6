package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.InputViewMessages;
import lotto.utils.InputValidator;

import java.util.List;



public class LottoGameInputView {
    private final InputValidator inputValidator = new InputValidator();

    public String requestPurchaseAmount(){
        try{
            System.out.println(InputViewMessages.PURCHASE_AMOUNT_PROMPT);
            String money = Console.readLine();
            inputValidator.validateMoney(money);
            System.out.println();
            return money;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            System.out.println();
            return requestPurchaseAmount();
        }
    }

    public String requestLottoWinningBonus(){
        try{
            System.out.println(InputViewMessages.WINNING_NUMBER_PROMPT);
            String lottoNumber = Console.readLine();
            inputValidator.validateLottoWinningNumber(lottoNumber);
            System.out.println();
            return lottoNumber;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            System.out.println();
            return requestLottoWinningBonus();
        }
    }

    public String requestLottoWinningBonus(List<Integer> lottoWinningNumbers) {
        try{
            System.out.println(InputViewMessages.BONUS_NUMBER_PROMPT);
            String bonusNumber = Console.readLine();
            inputValidator.validateLottoWinningBonusNumber(bonusNumber, lottoWinningNumbers);
            System.out.println();
            return bonusNumber;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            System.out.println();
            return requestLottoWinningBonus(lottoWinningNumbers);
        }
    }
}