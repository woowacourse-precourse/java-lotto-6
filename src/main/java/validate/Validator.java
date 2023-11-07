package validate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    public enum ErrorMessage {

        ERROR1("[ERROR] 숫자를 입력해주세요"),
        ERROR2("[ERROR] 가격을 천 단위로 입력해주세요"),
        ERROR3("[ERROR] 1부터 45사이의 숫자를 입력해 주세요."),
        ERROR4("[ERROR] 중복된 숫자가 존재합니다.");
        private String message;

        ErrorMessage(String message) {
            this.message = message;
        }
    }

    public void checkNull(String number){
        if (number == null){
            System.out.println(ErrorMessage.ERROR1);
            throw new NullPointerException();
        }
    }

    public int checkInteger(String number){
        try{
            return Integer.parseInt(number);
        }catch (NumberFormatException e){
            System.out.println(ErrorMessage.ERROR1);
            throw new IllegalArgumentException();
        }
    }

    public void checkPrice1000(int price){
        if(price%1000 != 0 ){
            System.out.println(ErrorMessage.ERROR2);
            throw new IllegalArgumentException();
        }
    }

    public void checkLottoRange(List<Integer> lotto){
        for(int num: lotto){
            if(num>45 || num<1){
                System.out.println(ErrorMessage.ERROR3);
                throw new IllegalArgumentException();
            }
        }
    }
    public void checkLottoDuplicate(List<Integer> lotto){
        Set<Integer> lottoSet = new HashSet<>(lotto);
        if(lottoSet.size() != 6){
            System.out.println(ErrorMessage.ERROR4);
            throw new IllegalArgumentException();
        }
    }

}
