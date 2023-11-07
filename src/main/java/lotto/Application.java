package lotto;

import java.lang.NumberFormatException;
import camp.nextstep.edu.missionutils.Console;


public class Application {
    public boolean isInteger(String input){
        try{
            Integer.parseInt (input);
            return true;
        }
        catch (NumberFormatException e){
            System.out.println("[ERROR] 입력값은 정수여야 합니다.");
            return false;
        }
    }
    public void cashSanityCheck(int cashInput) {
        if ( (cashInput%10) != 0) {
            System.out.println("[ERROR] 구입 금액은 1,000의 배수여야 합니다.");
            throw new IllegalArgumentException();
        }
    }
    public void numberCheck(int bonusNumber) throws IllegalArgumentException {
        if ( !(1 <= bonusNumber && bonusNumber <= 45) ) {
            System.out.println("[ERROR] 로또 번호는 1에서 45 사이의 정수여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현

    }


}
