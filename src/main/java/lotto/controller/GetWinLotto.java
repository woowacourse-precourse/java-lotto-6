package lotto.controller;

import lotto.ErrorMessage;
import lotto.Lotto;
import lotto.model.WinLotto;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class GetWinLotto {

    InputView inputView = new InputView();

    public WinLotto getWinLotto(){
        String winNumbers = inputView.inputWinNumbers();
        String bonusNumber = inputView.inputBonusNumber();

        return validWinLotto(winNumbers,bonusNumber);
    }

    public WinLotto validWinLotto(String winNumbers, String bonusNumber){

        Lotto winLotto = validWinNumber(winNumbers);
        int bonusNum = validBonusNumber(bonusNumber);

        return new WinLotto(winLotto,bonusNum);
    }

    public Lotto validWinNumber(String winNumbers){
        String[] numbers = winNumbers.split(",");

        List<Integer> nums = new ArrayList<>();
        int num;

        for (String number : numbers) {
            try {
                num=Integer.valueOf(number);
                nums.add(num);
            }catch(NumberFormatException e){
                throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_NUMBER.toString());
            }
        }

        return new Lotto(nums);
    }

    public int validBonusNumber(String bonusNumber){
        int bonusNum;
        try{
            bonusNum=Integer.valueOf(bonusNumber);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_NUMBER.toString());
        }
        if(bonusNum<1 | bonusNum>45){
            throw new IllegalArgumentException(ErrorMessage.ERROR_OUT_RANGE.toString());
        }

        return bonusNum;
    }

}
