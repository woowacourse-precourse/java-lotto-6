package lotto;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private final Ui ui;

    private List<Lotto> lottos = new ArrayList<>();
    private Integer numOfLotto;

    Controller(Ui ui){
        this.ui = ui;
    }

    public void run(){
        do {
            ui.print(Notification.start.getMessage());
            String input = ui.input();
            numOfLotto = ui.checkPurchaseAmount(input);
        } while(numOfLotto == null);

        for(int i=0;i<numOfLotto;i++){
            List<Integer> numbers = Lotto.makeLotto();
            try{
                lottos.add(new Lotto(numbers));
            } catch(IllegalArgumentException e){
                ui.print(ExceptionMessage.lottoNumber.getMessage());
                i--;
            }
        }

        ui.print(numOfLotto+Notification.buy.getMessage());
        for(int i=0;i<numOfLotto;i++){
            ui.print(lottos.get(i).toString());
        }



    }

}
