package lotto;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();

        outputView.moneyInput();
        MoneyInputView moneyInputView = new MoneyInputView();
        outputView.issueNotice(moneyInputView.getIssueCount());

        LottoTable lottoTable = new LottoTable(moneyInputView.getIssueCount());
        outputView.getIssues(lottoTable.getLottoTable());

        outputView.numbersInput();
        NumberInputView numberInputView = new NumberInputView();

        outputView.luckyInput();
        LuckyNumberInputView luckyNumberInputView = new LuckyNumberInputView(numberInputView.getValidNumbers());

        Lotto lotto = new Lotto(numberInputView.getValidNumbers());
        LottoDispatcher lottoDispatcher = new LottoDispatcher(
                lotto,
                lottoTable,
                luckyNumberInputView.getLuckyNumber()
        );
        Board board = new Board(lottoDispatcher);
        outputView.staticsResult(board.getGainStatics());
        outputView.earningResult(board.getCalculatedProfit());
    }
}