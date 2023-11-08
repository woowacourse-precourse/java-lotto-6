package lotto;

import java.util.HashSet;
import java.util.List;

public class ErrorCheck {

    public static boolean checkWon(String input){
        try {
            int money = Integer.parseInt(input);
            if (money%1000!=0) {
                throw new IllegalArgumentException();
            }
            return true;
        }
        catch(NumberFormatException e){
            System.out.println("[ERROR] 숫자를 입력하세요");
        }
        catch (IllegalArgumentException e){
            System.out.println("[ERROR] 입력 금액은 1000원 단위여야 합니다.");
        }
        return false;
    }


    private static boolean isSizeValid(List<Integer>list){
        return list.size()==6;
    }

    private static boolean isNumberRangeValid(List<Integer>list){
        for(Integer i:list){
            if(i<1 || i>45){
                return false;
            }
        }
        return true;
    }

    public static boolean userLottoCheck(List<Integer> list){
        try{
            if(!isSizeValid(list)){
                throw new IllegalArgumentException();
            }
            if(!isNumberRangeValid(list)){
                throw new IllegalArgumentException();
            }
            if(!isNumDuplicated(list)){
                throw new IllegalArgumentException();
            }
            return true;
        }catch(IllegalArgumentException e){
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
       }
        return false;
    }

    public static boolean isNumDuplicated(List<Integer> list) {
        HashSet<Integer> set = new HashSet<>();
        for (Integer value : list) {
            if (!set.add(value)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isBonusNumDuplicated(List<Integer> list, int bonusNum){
        try{
            if(list.contains(bonusNum)){
                throw new IllegalArgumentException();
            }
            return true;
        }catch(IllegalArgumentException e){
            System.out.println("[ERROR] 보너스 번호가 로또 번호에 중복됩니다.");
        }
        return false;
    }


    public static boolean bonusNumCheck(int bonusNum){
        try{
            if(bonusNum<1 || bonusNum>45){
                throw new IllegalArgumentException();
            }
            return true;
        }catch(IllegalArgumentException e){
            System.out.println("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        return false;
    }
}
