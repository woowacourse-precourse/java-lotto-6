package lotto.domain;
import lotto.validator.MoneyValidator;

public class Money {

    private int lottoTickets;
    private String money;

    public Money(String input){
        validate(input);
        this.money = input;
        moneyToLottoTicket();
    }

    private void validate(String input) {
        MoneyValidator validator = new MoneyValidator(input);
    }

    public int moneyToLottoTicket(){
        return this.lottoTickets=Integer.parseInt(money)/1000;
    }

    public int getLottoTickets(){
        return lottoTickets;
    }
}
