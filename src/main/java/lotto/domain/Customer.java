package lotto.domain;

import java.util.List;

public class Customer {

    private int money;
    private List<Lotto> lottos;

    public Customer(String money){
        this.money=Integer.parseInt(money);
    }

    public void pay(int money){
        IssuingMachine issuingMachine=IssuingMachine.turnOn(money);
        lottos=issuingMachine.issueLotto();
    }

    public void validateMoney(){

    }
}
