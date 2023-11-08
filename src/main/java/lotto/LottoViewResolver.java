package lotto;

public class LottoViewResolver {
    OutputView outputView;
    MoneyInputView moneyInputView;
    NumberInputView numberInputView;
    LuckyNumberInputView luckyNumberInputView;
    private int issue;
    LottoTable lottoTable;

    public LottoViewResolver() {
        outputView = new OutputView();
        moneyView();
        lottoTable = lottoTable();
        numbersInput();
    }

    private void moneyView() {
        outputView.moneyInput();
        moneyInputView = new MoneyInputView();
        issue = moneyInputView.getIssueCount();
        outputView.issueNotice(issue);
    }

    private LottoTable lottoTable() {
        LottoTable lottoTable = new LottoTable(issue);
        outputView.getIssues(lottoTable.getLottoTable());
        return lottoTable;
    }

    public void numbersInput() {
        outputView.numbersInput();
        numberInputView = new NumberInputView();
        outputView.luckyInput();
        luckyNumberInputView = new LuckyNumberInputView(numberInputView.getValidNumbers());
    }

    public LottoDispatcher getLottoDispatcher() {
        Lotto lotto = new Lotto(numberInputView.getValidNumbers());
        return new LottoDispatcher(lotto, lottoTable, luckyNumberInputView.getLuckyNumber());
    }
    public void staticsResult(Board board) {
        outputView.staticsResult(board.getGainStatics());
    }
    public void earningResult(Board board) {
        outputView.earningResult(board.getCalculatedProfit());
    }
}
