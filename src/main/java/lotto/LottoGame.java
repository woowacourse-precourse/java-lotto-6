package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoGame {
    public static int purchase = 0;
    void StartGame(){
        System.out.println("구입금액을 입력해 주세요.");
        inputPurchase();
    }

    void inputPurchase(){
        checkValidPurchase(readLine());
    }

    void checkValidPurchase(String input){
        try{
            purchase = Integer.valueOf(input);
        }catch(NumberFormatException e){
            System.out.println("[ERROR] 투입 금액은 숫자여야합니다.");
            inputPurchase();
        }
        if(purchase%1000!=0){
            System.out.println("[ERROR] 투입 금액은 1,000원 단위여야합니다.");
            inputPurchase();
        }
    }

}
