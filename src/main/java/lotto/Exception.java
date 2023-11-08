package lotto;

public class Exception {
    boolean checkInputIsNumber(String input){
        try{
            Integer.valueOf(input);
            return true;
        }catch(NumberFormatException e){
            System.out.println("[ERROR] 입력이 숫자가 아닙니다.");
            return false;
        }
    }

    boolean checkInputInRange(String input){
        int change = Integer.valueOf(input);
        if(change<1 || change>45){
            System.out.println("[ERROR] 로또 번호의 숫자는 1에서 45까지입니다.");
            return false;
        }
        return true;
    }

    boolean checkValidPurchase(int purchase){
        if(purchase%1000!=0){
            System.out.println("[ERROR] 구입 금액이 1,000원 단위가 아닙니다.");
            return false;
        }
        return true;
    }

    boolean checkSizeIsSix(int size){
        if(size != 6){
            System.out.println("[ERROR] 입력된 숫자가 6개가 아닙니다.");
            return false;
        }
        return true;
    }

    boolean checkDuplication(int number, Lotto lotto){
        if(lotto.contain(number)){
            System.out.println("[ERROR] 당첨 로또와 중복된 숫자가 입력되었습니다.");
            return true;
        }
        return false;
    }
}
