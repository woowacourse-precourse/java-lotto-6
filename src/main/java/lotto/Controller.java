package lotto;

import java.util.List;

public class Controller {

    private final Ui ui;

    private List<Lotto> lottos;

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





    }
}
