package view;

import java.math.BigDecimal;
import java.util.List;

/*
결과를 출력합니다.
 */
public class PrintResult {

  public PrintResult() {
  }

  public void winningDetailPrint(List<Integer> winningDetails) {
    StringBuilder sb = new StringBuilder();
    sb.append("당첨 통계\n").append("---\n");
    sb.append("3개 일치 (5,000원) - ").append(winningDetails.get(5)).append("개\n")
            .append("4개 일치 (50,000원) - ").append(winningDetails.get(4)).append("개\n")
            .append("5개 일치 (1,500,000원) - ").append(winningDetails.get(3)).append("개\n")
            .append("5개 일치, 보너스 볼 일치 (30,000,000원) - ").append(winningDetails.get(2)).append("개\n")
            .append("6개 일치 (2,000,000,000원) - ").append(winningDetails.get(1)).append("개\n");
    System.out.println(sb);
  }

  public void earningRatioPrint(BigDecimal earningRatio) {
    StringBuilder sb = new StringBuilder();
    sb.append("총 수익률은 ").append(earningRatio).append("%입니다.");
    System.out.println(sb);
  }




}
