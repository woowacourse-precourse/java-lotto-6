package lotto;

public class Exception {
    // 입력이 숫자인지
    boolean checkInputIsNumber(String input){
        try{
            Integer.valueOf(input);
            return true;
        }catch(NumberFormatException e){
            System.out.println("[ERROR] 입력이 숫자가 아닙니다.");
            return false;
        }
    }
    // 1~45 사이 인지
    boolean checkInputInRange(String input){
        int change = Integer.valueOf(input);
        if(change<1 || change>45){
            System.out.println("[ERROR] 로또 번호의 숫자는 1에서 45까지입니다.");
            return false;
        }
        return true;
    }
    // 1000 단위인지
    boolean checkValidPurchase(int purchase){
        if(purchase%1000!=0){
            System.out.println("[ERROR] 구입 금액이 1,000원 단위가 아닙니다.");
            return false;
        }
        return true;
    }
    // 6개인지
    boolean checkSizeIsSix(int size){
        if(size != 6){
            return false;
        }
        return true;
    }
    // 중복이 없는지
    boolean checkDuplication(int number,Lotto lotto){
        if(lotto.contain(number)){
            System.out.println("[ERROR] 중복된 숫자가 입력되었습니다.");
            return true;
        }
        return false;
    }
    // 보너스와 숫자간 중복이 없는지
}
