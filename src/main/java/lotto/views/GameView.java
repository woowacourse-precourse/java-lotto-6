package lotto.views;

public class GameView {
    private InputView inputView;
    private OutputView outputView;
    public GameView(){
        inputView = new InputView();
        outputView = new OutputView();
    }

    public int purchaseAmountView(){
        outputView.printGetPurchaseAmount();
        while(true){
            try{
                String input = inputView.readPurchaseAmount();
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
