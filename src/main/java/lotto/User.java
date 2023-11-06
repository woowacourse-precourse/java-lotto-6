package lotto;

import camp.nextstep.edu.missionutils.Console;

public class User {

    private int money;
    private int tickets;

    User(){
        getMoney();
    }

    private void getMoney(){
        while(true){
            try{
                this.money = Integer.parseInt(Console.readLine());
                tickets = getTickets(money);
                return;
            } catch (IllegalArgumentException e){
                System.out.println("[ERROR] 구매 금액은 천원 단위로 입력해주세요.");
            }
        }
    }

    /**
     * 천원단위로 나눠 떨어지지 않을 때 예외처리
     * */
    private int getTickets(int money){
        if(money % 1000 != 0){
            throw new IllegalArgumentException();
        }
        return money / 1000;
    }

}
