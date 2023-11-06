package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        int lotto_purchase_amount;
        List<Lotto> lottos;
        
        lotto_purchase_amount = inputLottoPurchase();
        lottos = lottoIssuance(lotto_purchase_amount / 1000);
        System.out.println(lottos);
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
        ArrayList<Lotto> lottos = new ArrayList<Lotto>();
        for (int i =0; i < purchase_amount; i++){
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottos;
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
