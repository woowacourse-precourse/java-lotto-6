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

    public List<Lotto> getPocket(){return this.pocket;}

    public void buyLottos(){
        try{
            Integer lottoamount = InputView.moneyValidate(InputView.buyLottoInput());
            for(int i=0; i<lottoamount; i++){
                Lotto singleLotto = Lotto.makingSingleLotto();
                this.addPocket(singleLotto);
            }
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            this.buyLottos();
        }
    }
}
