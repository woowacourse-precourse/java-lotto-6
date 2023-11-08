package lotto.view;

public class RunLotto {

    private final UserOutputView userOutputView = UserOutputView.getInstance();
    private final UserInputView userInputView = UserInputView.getInstance();

    private RunLotto() {
    }
    private static class RunLottoHolder{
        private static final RunLotto runLotto = new RunLotto();
    }
    public static RunLotto getInstance(){
        return RunLottoHolder.runLotto;
    }

    public void runLotto(){
        userOutputView.outputPurchaseAmount();
        userInputView.inputPurchaseAmount();

        userOutputView.getBuyLottoTicketsNum();
        userOutputView.getBuyLottoTickets();

        userOutputView.outputWinningNums();
        userInputView.inputWinningNums();

        userOutputView.outputBonusNum();
        userInputView.inputBonusNum();

        userOutputView.winningStatistics();
        userOutputView.winningStatisticsResult();
        userOutputView.winningLottoRateResult();




    }
}
