package lotto.view;

public class RunLotto {

    private RunLotto() {
    }
    private static class RunLottoHolder{
        private static final RunLotto runLotto = new RunLotto();
    }
    public static RunLotto getInstance(){
        return RunLottoHolder.runLotto;
    }

    public void runLotto(){
        UserOutputView.getInstance().outputPurchaseAmount();
        UserInputView.getInstance().inputPurchaseAmount();

        UserOutputView.getInstance().getBuyLottoTicketsNum();
        UserOutputView.getInstance().getBuyLottoTickets();

        UserOutputView.getInstance().outputWinningNums();
        UserInputView.getInstance().inputWinningNums();

        UserOutputView.getInstance().outputBonusNum();
        UserInputView.getInstance().inputBonusNum();

        UserOutputView.getInstance().winningStatistics();
        UserOutputView.getInstance().winningStatisticsResult();
        UserOutputView.getInstance().winningLottoRateResult();




    }
}
