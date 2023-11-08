package lotto.controller;

import lotto.message.ErrorMessage;
import lotto.Lotto;
import lotto.model.WinLotto;
import lotto.view.InputView;
import lotto.view.InputViewImpl;

import java.util.ArrayList;
import java.util.List;

public class GetWinLottoImpl implements GetWinLotto{

    InputView inputView;

    public GetWinLottoImpl(InputView inputView){
        this.inputView=inputView;
    }

    public WinLotto getWinLotto(){

        Lotto winNumber = getWinNumber();
        Integer bonusNum = getBonusNumber(winNumber);

        return new WinLotto(winNumber,bonusNum);
    }


    public Lotto getWinNumber(){
        boolean validInput =false;
        Lotto winNumber;
        do {
            try{
                String winNumbers = inputView.inputWinNumbers();
                winNumber=validWinNumber(winNumbers);
                return winNumber;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }while(!validInput);

        return null;
    }

    public Integer getBonusNumber(Lotto winNumber){
        boolean validInput =false;
        int bonusNum;
        do {
            try{
                String bonusNumber = inputView.inputBonusNumber();
                bonusNum = validBonusNumber(bonusNumber,winNumber);
                return bonusNum;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }while(!validInput);

        return null;
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

    public int validBonusNumber(String bonusNumber,Lotto winLotto){
        int bonusNum;
        try{
            bonusNum=Integer.valueOf(bonusNumber);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_NUMBER.toString());
        }
        if(bonusNum<1 | bonusNum>45){
            throw new IllegalArgumentException(ErrorMessage.ERROR_OUT_RANGE.toString());
        }
        if(winLotto.getNumbers().contains(bonusNum)){
            throw new IllegalArgumentException(ErrorMessage.ERROR_DUPLICATE.toString());
        }

        return bonusNum;
    }

}
