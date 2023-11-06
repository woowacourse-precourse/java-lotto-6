package lotto.Constant;

public enum ConstLottoResult {
    LOTTO_MATCH_COUNT_RESULT("%d개 일치 (%s원) - %d개\n"),
    LOTTO_MATCH_COUNT_FIVE_WITH_BONUS_RESULT("5개 일치, 보너스 볼 일치 (%s원) - %d개\n"),
    LOTTO_RESULTS_STATISTICS("총 수익률은 %.1f%%입니다.");

    private final String printResult;

    ConstLottoResult(String printResult){
        this.printResult = printResult;
    }

    public String getPrintResult(){
        return printResult;
    }
}
