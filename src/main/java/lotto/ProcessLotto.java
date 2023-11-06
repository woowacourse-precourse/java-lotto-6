package lotto;

public class ProcessLotto {
    private OutputView outputView;
    private InputView inputView;

    public ProcessLotto(InputView inputView, OutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void drawLotto(){
        InputValidate inputValidate = new InputValidate();
        AmountProcessing amountProcessing = new AmountProcessing();
        outputView.askBonusNum();
        int cost = inputValidate.validateCost(inputView.getLine());
        int count = amountProcessing.getLottoCount(cost);
        outputView.printNumberPurchase(count);


    }


}
