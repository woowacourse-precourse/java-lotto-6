package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoController {
    static final int MONEY_UNIT = 1000;
    public void run(){
        try{
            int userMoney= getMoney();
        } catch(IllegalArgumentException e){

        }

    }

    private int getMoney() throws IllegalArgumentException{
        System.out.println("구입금액을 입력해주세요.");

        int money = Integer.parseInt(Console.readLine());

        if(money % MONEY_UNIT != 0){
            System.out.println("[ERROR] 돈은 1000단위로 입력해야 합니다.");

            throw new IllegalArgumentException();
        }

        return money;
    }
}
