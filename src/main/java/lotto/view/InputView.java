package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.InputValidation;

import java.util.List;

public class InputView {

    private static final String PURCHASE_AMOUNT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_LOTTO_WINNING_Bonus_MESSAGE = "보너스 번호를 입력해 주세요.";

    InputValidation inputValidation = new InputValidation();

    public String purchaseAmountMoney(){
        try{
            System.out.println(PURCHASE_AMOUNT_MONEY_MESSAGE);
            String money = Console.readLine();
            inputValidation.validationMoney(money);
            System.out.println();
            return money;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            System.out.println();
            return purchaseAmountMoney();
        }
    }

    public String lottoWinningNumber(){
        try{
            System.out.println(INPUT_LOTTO_WINNING_NUMBER_MESSAGE);
            String lottoNumber = Console.readLine();
            inputValidation.validationLottoWinningNumber(lottoNumber);
            return lottoNumber;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            System.out.println();
            return lottoWinningNumber();
        }
    }

    public String lottoWinningBonus(List<Integer> lottoWinningNumbers) {
        try{
            System.out.println(INPUT_LOTTO_WINNING_Bonus_MESSAGE);
            String bonusNumber = Console.readLine();
            inputValidation.validationLottoWinningBonusNumber(bonusNumber, lottoWinningNumbers);
            return bonusNumber;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            System.out.println();
            return lottoWinningBonus(lottoWinningNumbers);
        }
    }
}
