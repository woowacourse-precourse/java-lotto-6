package lotto;

import controller.LottoGenerator;
import controller.UserInput;
import model.Lotto;
import model.Lottos;
import model.Purchase;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        run();
    }

    static void run(){
        Purchase purchase = new Purchase();
        Lottos lottos = new Lottos();

        purchase.Number(UserInput.purchasePrice());
        System.out.println(purchase.getPurchaseNumber());

        lottos.initLottos(LottoGenerator.createLottos(purchase.getPurchaseNumber()));
        for(Lotto l : lottos.getLottos()){
            System.out.println(l);
        }
        System.out.println(lottos.getLottos().size());
    }



}
