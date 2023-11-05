package lotto.result;

public class LottoResult {
    private LottoResultType lottoResultType;
    private int money;

    public LottoResult(int money, LottoResultType lottoResultType) {
        this.money = money;
        this.lottoResultType = lottoResultType;
    }

    // 수익률 계산
    public double calculateRateOfReturn() {
        double rateOfReturn = 0;

        Long sum = 0L;
        for (LottoResultType type: LottoResultType.values()) {
            sum += type.getPrice() * type.getCount();
        }

        rateOfReturn = sum / money;

        return rateOfReturn;
    }

    // 당첨 통계 출력
    public void printWinnigStatistics() {
        StringBuilder sb = new StringBuilder();

        sb.append("당첨 통계").append("\n");
        sb.append("---").append("\n");

        for (LottoResultType type: LottoResultType.values()) {
            type.print();
        }

        sb.append("총 수익률은 ").append(String.format("%.2f", calculateRateOfReturn())).append("%입니다.");

        System.out.println(sb);
    }
}
