package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class User {

    private int money;
    private int ticketCount;
    private List<Lotto> lottos;

    User(){
        getMoney();
    }

    public void getRandomLotto(){

    }

    private void getMoney(){
        while(true){
            try{
                this.money = Integer.parseInt(Console.readLine());
                this.ticketCount = getTicketCount(money);
                return;
            } catch (IllegalArgumentException e){
                System.out.println(Message.ERROR_MESSAGE + " " + Message.ONE_HUNDRED_DIVIDE);
            }
        }
    }

    /**
     * 천원단위로 나눠 떨어지지 않을 때 예외처리
     * */
    private int getTicketCount(int money){
        if(money % 1000 != 0){
            throw new IllegalArgumentException();
        }
        return money / 1000;
    }

}
