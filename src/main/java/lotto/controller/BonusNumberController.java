package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.Errors;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.view.LottoView;

public class BonusNumberController {

    private LottoView lottoView = new LottoView();

    public Bonus runBonusNumber(Lotto winningNumber){
        int bonusNum;
        while(true){
            try{
                bonusNum = getBonusNumber();
                winningNumber.validateBonusNumber(bonusNum);
                Bonus bonus = new Bonus(bonusNum);
                return bonus;
            } catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public int getBonusNumber(){
        int bonusNumber;
        lottoView.printInputBonusNumber();
        try{
            bonusNumber = parseBonusNumber(Console.readLine());
            return bonusNumber;
        } catch(IllegalArgumentException e){
            throw new IllegalArgumentException(Errors.BONUS_NUMBER_NOT_INTEGER_MESSAGE.getErrorMessage());
        }
    }

    public int parseBonusNumber(String input){
        return Integer.parseInt(input);
    }
}
