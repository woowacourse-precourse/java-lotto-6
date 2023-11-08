package lotto;

public class Controller {

    private final Ui ui;

    Controller(Ui ui){
        this.ui = ui;
    }

    public void run(){
        Integer amount;
        do {
            ui.print(Notification.start.getMessage());
            String input = ui.input();
            amount = ui.checkPurchaseAmount(input);
        } while(amount == null);




    }
}
