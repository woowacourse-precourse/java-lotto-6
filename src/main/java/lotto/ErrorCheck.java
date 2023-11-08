package lotto;

import java.util.HashSet;
import java.util.List;

public class ErrorCheck {
//    ERROR("[ERROR] "),
//    AMOUNT_WRONG("구매 금액은 1,000원 단위여야 합니다."),
//    WINNING_NUMBER_WRONG("당첨 번호는 1부터 45 사이의 6개의 숫자여야 합니다."),
//    BONUS_NUMBER_WRONG("보너스 번호는 당첨번호와 다른 1부터 45 사이의 1개의 숫자여야 합니다.");

    public static boolean wonCheck(String input){
        try {
            int money = Integer.parseInt(input);
            if (money%1000!=0) {
                throw new IllegalArgumentException();
            }
            return true;
        } catch (IllegalArgumentException e){
            System.out.println("[ERROR] 입력 금액은 1000원 단위여야 합니다.");
        }
        return false;
    }

    public static boolean userLottoCheck(List<Integer> list){
        try{
            if(list.size()!=6){
                throw new IllegalArgumentException();
            }
            for(Integer i:list){
                if(i<1 || i>45){
                    throw new IllegalArgumentException();
                }
            }
            return true;
        }catch(IllegalArgumentException e){
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
       }
        return false;
    }

    public static boolean isDuplicated(List<Integer> list){
        try {
            checkForDuplicates(list);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 로또 번호에 중복된 값이 있습니다.");
        }
        return false;
    }

    public static void checkForDuplicates(List<Integer> list) {
        HashSet<Integer> set = new HashSet<>();
        for (Integer value : list) {
            if (!set.add(value)) {
                throw new IllegalArgumentException();
            }
        }
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
