package lotto;

import java.util.ArrayList;
import java.util.List;

public class ViewOutput {
    private static StringBuilder stringBuilder = new StringBuilder();

    public void showLottoList(List<Lotto> lottoList) {
        for(Lotto lotto : lottoList) {
            stringBuilder.append("[");

            for(int index = 0; index < 6; index++) {
                List<Integer> lottoNumbers = new ArrayList<>();
                stringBuilder.append(lottoNumbers.get(index) + ", ");
            }
            stringBuilder.setLength(stringBuilder.length() - 2);
            stringBuilder.append("]\n");
        }

        System.out.println(stringBuilder);
        stringBuilder.setLength(0);
    }

    public void showWinningStatistics(List<Integer> results) {
        stringBuilder.append("\n당첨 통계\n" + "---\n");
        stringBuilder.append("3개 일치 (5,000원) - " + results.get(0) + "개\n");
        stringBuilder.append("4개 일치 (5,0000원) - " + results.get(1) + "개\n");
        stringBuilder.append("5개 일치 (1,500,000원) - " + results.get(2) + "개\n");
        stringBuilder.append("5개 일치, 보너스 볼 일치 (30,000,000원) - " + results.get(3) + "개\n");
        stringBuilder.append("6개 일치 (2,000,000,000원) - " + results.get(0) + "개\n");

        System.out.println(stringBuilder);
        stringBuilder.setLength(0);
    }

    public void showTotalReturn(int totalReturn) {
        System.out.println("총 수익률은 " + totalReturn + "%입니다.");
    }
}
