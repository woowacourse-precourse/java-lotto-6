package lotto;

import java.util.ArrayList;
import java.util.List;
import javax.swing.event.ListDataListener;

public class Customer {
    private final List<Lotto> pocket;

    Customer () {
        this.pocket = new ArrayList<Lotto>();
    }

    Customer (List<Lotto> pocket) {
        this.pocket = pocket;
    }

    public void addPocket(Lotto lotto){
        this.pocket.add(lotto);
    }

    public List<Lotto> getPocket(Customer customer){return customer.pocket;}
}
