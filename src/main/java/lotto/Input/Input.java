package lotto.Input;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto.Lotto;
import lotto.Print.ErrorMessage;
import lotto.Print.Print;
import lotto.Validator.Validator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Input {
    //입력받은 구입 금액으로 로또 개수 구하기
    public static int getLottoBuyCount() {
        try{
            Print.printBuyLotto();
            String inputValue = Console.readLine();
            int buyPrice = Validator.checkLottoBuyPrice(inputValue);
            return buyPrice / 1000;
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return getLottoBuyCount();
        }
    }

    public static Lotto getWinningLottoNumbers(){
        try{
            Print.printWinningLottoNumber();
            String inputValue = Console.readLine();
            List<Integer> winningLottoNumbers = new ArrayList<Integer>();
            String[] values = inputValue.split(",");
            for(String value : values) {
                try{
                    winningLottoNumbers.add(Integer.parseInt(value));
                }catch(NumberFormatException exception){
                    throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT);
                }
            }
            return new Lotto(winningLottoNumbers);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return getWinningLottoNumbers();
        }
        //Collections.sort(winningLottoNumbers);
    }

    public static int getBonusNumber(){
        try {
            Print.printBonusNumber();
            String inputValue = Console.readLine();
            try {
                return Integer.parseInt(inputValue);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT);
            }
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return getBonusNumber();
        }
    }

}