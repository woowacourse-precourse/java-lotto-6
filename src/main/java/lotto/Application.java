package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        int lotto_purchase_amount = inputLottoPurchase();
        List<Lotto> a = new ArrayList<Lotto>();
        
    }

    static int inputLottoPurchase(){
        int lotto_purchase_amount;

        System.out.println("구입금액을 입력해 주세요");
        while(true){
            try {
                lotto_purchase_amount = stringToInt(Console.readLine());
                checkMultiple1000(lotto_purchase_amount);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return lotto_purchase_amount;
    }

    static ArrayList<Lotto> lottoIssuance(int purchase_amount){
        return new ArrayList<Lotto>();
    }

    static int stringToInt(String value) throws IllegalArgumentException{
        int num;
        try {
            num = Integer.parseInt(value);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자 값을 입력해야 합니다.");
        }
        return num;
    }

    static void checkMultiple1000(int num) throws IllegalArgumentException{
        if (num % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 1000의 배수를 입력해야 합니다.");
        }
    }
}
