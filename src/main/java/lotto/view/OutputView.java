package lotto.view;

import lotto.domain.Rank;

import java.awt.*;
import java.util.List;

public class OutputView {
    public void printLottoCount(long lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public void printLottoNumbers(List<Integer> lottoNumbers) {
        System.out.println(makeLottoNumberMessage(lottoNumbers));
    }

    public void printLottosResultPrefix(){
        System.out.println("당첨 통계\n---");
    }
    public void printLottosResult(Rank rank, int count){
        if(rank.equals(Rank.SECOND))
            printSecondResult(count);
        printRemainResult(rank, count);
    }

    public void printRateOfReturn(double rateOfReturn){
        System.out.println("총 수익률은 " +rateOfReturn+ "%입니다.");
    }


    private String makeLottoNumberMessage(List<Integer> lottoNumbers) {
        StringBuilder sb = new StringBuilder("[");
        lottoNumbers.stream().forEach(n -> sb.append(n + ", "));
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    private void printSecondResult(int count) {
        System.out.println("5개 일치, 보너스 볼 일치 (" + Rank.SECOND.getPrize()+ ") - " + count +"개");
    }

    private void printRemainResult(Rank rank, int count) {
        System.out.println(rank.getCollectCount() + "개 일치 " + rank.getPrize()+ ") - " + count +"개");
    }

}
