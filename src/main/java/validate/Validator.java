package validate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {


    public void checkNull(String number){
        if (number == null||number.equals("0")){
            System.out.println(ErrorMessageenum.ERROR1.getMessage());
            throw new NullPointerException();
        }
    }

    public int checkInteger(String number){
        try{
            return Integer.parseInt(number);
        }catch (NumberFormatException e){
            System.out.println(ErrorMessageenum.ERROR1.getMessage());
            throw new IllegalArgumentException();
        }
    }

    public void checkPrice1000(int price){
        if(price%1000 != 0 ){
            System.out.println(ErrorMessageenum.ERROR2.getMessage());
            throw new IllegalArgumentException();
        }
    }

    public void checkLottoRange(List<Integer> lotto){
        for(int num: lotto){
            if(num>45 || num<1){
                System.out.println(ErrorMessageenum.ERROR3.getMessage());
                throw new IllegalArgumentException();
            }
        }
    }
    public void checkWinningDuplicate(List<Integer> lotto,int bonus){
        Set<Integer> lottoSet = new HashSet<>(lotto);
        if(lottoSet.contains(bonus)){
            System.out.println(ErrorMessageenum.ERROR5.getMessage());
            throw new IllegalArgumentException();
        }
    }

    public void checkDuplicate(List<Integer> lotto){
        Set<Integer> lottoSet = new HashSet<>(lotto);
        if(lottoSet.size() != 6){
            System.out.println(ErrorMessageenum.ERROR4.getMessage());
            throw new IllegalArgumentException();
        }
    }
}
