package lotto.view;

import lotto.domain.Lotto;
import lotto.lottoenum.LottoRanking;

import java.util.List;

public class Output {
    public void printPurchaseAmount(){
        System.out.println("구매금액을 입력해주세요.");
    }

    public void printRandomLottoNum(List<Lotto> lotto){
        System.out.println(lotto.size() + "개를 구매했습니다.");
        for(Lotto lottoNum : lotto){
            System.out.println(lottoNum.getLottoDetail().toString());
        }
    }

    public void printGetLottoAnswer(){
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printGetBonusNum(){
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printResult(List<LottoRanking> lottoRanking){
        System.out.println("당첨 통계\n---");
        fifthRanking(lottoRanking);
        fourthRanking(lottoRanking);
        thirdRanking(lottoRanking);
        secondRanking(lottoRanking);
        firstRanking(lottoRanking);
    }
    public void printCalculation(float calculation){
        System.out.println("총 수익률은 " + calculation + "%입니다.");
    }

    private Long countLottoRanking(List<LottoRanking> lottoRankings, LottoRanking lottoRanking){
        return lottoRankings.stream()
                .filter(item -> item == lottoRanking)
                .count();
    }

    private void fifthRanking(List<LottoRanking> lottoRankings){
        System.out.print("3개 일치 (5,000원) - ");
        System.out.println(countLottoRanking(lottoRankings, LottoRanking.FIFTH)+"개");
    }
    private void fourthRanking(List<LottoRanking> lottoRankings){
        System.out.print("4개 일치 (50,000원) - ");
        System.out.println(countLottoRanking(lottoRankings, LottoRanking.FOURTH)+"개");
    }
    private void thirdRanking(List<LottoRanking> lottoRankings){
        System.out.print("5개 일치 (1,500,000원) - ");
        System.out.println(countLottoRanking(lottoRankings, LottoRanking.THIRD)+"개");
    }
    private void secondRanking(List<LottoRanking> lottoRankings){
        System.out.print("5개 일치, 보너스 볼 일치 (30,000,000원) - ");
        System.out.println(countLottoRanking(lottoRankings, LottoRanking.SECOND)+"개");
    }
    private void firstRanking(List<LottoRanking> lottoRankings){
        System.out.print("6개 일치 (2,000,000,000원) - ");
        System.out.println(countLottoRanking(lottoRankings, LottoRanking.FIRST)+"개");
    }
}
