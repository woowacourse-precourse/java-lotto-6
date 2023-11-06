package lotto;
public class Output {
    public enum Statement {
        BUY_AMOUNT("구입금액을 입력해 주세요."),
        BUY_COUNT("%d개를 구매했습니다."),
        LOTTO_WIN_NUMBER("당첨 번호를 입력해 주세요."),
        LOTTO_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
        WIN_STATISTICS("당첨 통계"),
        SEPERATION_LINE("---"),
        TOTAL_PROFIT_RATING("총 수익률은 %f%입니다.");

        private final String statement;
        Statement(String statement) {this.statement = statement;}
    }

    private static final void printStatement(String statement) {
        System.out.println(statement);
    }

    public static final void printBuyAmount(){
        printStatement(Statement.BUY_AMOUNT.statement);
    }

    public static final void printBuyCount(Integer count) {
        System.out.printf(Statement.BUY_COUNT.statement, count);
    }

    public static final void printLottoWinNumber() {
        printStatement(Statement.LOTTO_WIN_NUMBER.statement);
    }

    public static final void printLottoBonusNumber() {
        printStatement(Statement.LOTTO_BONUS_NUMBER.statement);
    }

    public static final void printWinStatistics() {
        printStatement(Statement.WIN_STATISTICS.statement);
    }

    public static final void printSeperationLine() {
        printStatement(Statement.SEPERATION_LINE.statement);
    }

    public static final void printTotalProfitRating(Double rating) {
        System.out.printf(Statement.TOTAL_PROFIT_RATING.statement, rating);
    }
}

