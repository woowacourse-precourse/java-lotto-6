package lotto.domain;

public class Money {

    private int lottoTickets;
    private String money;

    public Money(String input){
        this.money = input;
        moneyToLottoTicket();
    }

    public int moneyToLottoTicket(){
        return this.lottoTickets=Integer.parseInt(money)/1000;
    }

    public int getLottoTickets(){
        return lottoTickets;
    }
}
