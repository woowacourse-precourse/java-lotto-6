package lotto;

public class User {

    private int money;
    private int canGetTickets;

    User(int money){
        this.money = money;
        while(true){
            try{

            } catch (IllegalArgumentException e){

            }
        }
    }

    /**
     * 천원단위로 나눠 떨어지지 않을 때 예외처리
     * */
    private int canGetTickets(int money){
        if(money % 1000 != 0){
            throw new IllegalArgumentException();
        }
        return money / 1000;
    }

}
