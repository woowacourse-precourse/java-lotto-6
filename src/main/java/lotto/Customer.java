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

    public void printPocket() {
        List<Lotto> pocket = this.getPocket();
        for(int i=0; i<pocket.size(); i++){
            String lotto = pocket.get(i).getNumbers().toString();
            System.out.println(lotto);
        }
    }

    public static Integer moneyValidate(Integer money){
        if(money == 0){
            throw new IllegalArgumentException("[ERROR] 0은 입력할 수 없습니다.");
        }
        if(money % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 천원 단위의 금액만 입력가능합니다.") ;
        }
        return (money / 1000);
    }

    public void buyLottos(){
        try{
            Integer lottoamount = moneyValidate(InputView.buyLottoInput());
            System.out.println(lottoamount+"개를 구매했습니다.");
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
