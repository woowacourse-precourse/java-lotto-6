package lotto;

public class PrintWinningResult {
    private static int[] lottoResult;

    public PrintWinningResult(int[] lottoResult) {
        PrintWinningResult.lottoResult = lottoResult;
    }

    public String printLottoResult() {
        int[] result = lottoResult;
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("3개 일치 (5,000원) - ").append(result[1]).append("개\n");
        stringBuilder.append("4개 일치 (50,000원) - ").append(result[2]).append("개\n");
        stringBuilder.append("5개 일치 (1,500,000원) - ").append(result[3]).append("개\n");
        stringBuilder.append("5개 일치, 보너스 볼 일치 (30,000,000원) - ").append(result[4]).append("개\n");
        stringBuilder.append("6개 일치 (2,000,000,000원) - ").append(result[5]).append("개\n");

        return stringBuilder.toString();

    }

    public String printProfitResult(double profitPercentage) {
        return "총 수익률은 " + profitPercentage + "%입니다.";
    }
}
