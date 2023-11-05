package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final int numberOfLottoTicket;
    private final int money;
    private List<Lotto> purchasedLottos = new ArrayList<>();

    public Customer(int money,int numberOfLottoTicket ) {
        this.money = money;
        this.numberOfLottoTicket = numberOfLottoTicket;

    }
    public int getNumberOfLottoTicket(){
        return numberOfLottoTicket;
    }
    public void purchaseLotto(Lotto lotto){
        purchasedLottos.add(lotto);
    }
    public List<Lotto> getLottos(Customer customer){
        return customer.purchasedLottos;
    }
}
