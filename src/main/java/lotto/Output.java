package lotto;

import java.util.List;

public class Output {

    public void instructInputMoney(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void instructInputWinningNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void instructInputBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void showStats(){
        System.out.println("당첨 통계");
    }

    public void showLottoPurchaseCount(int lottoCount){
        System.out.println(lottoCount+"개를 구매했습니다.");
    }

    public void showPurchaseLottoNumber(List<Lotto> lottoList){
        for(Lotto lotto:lottoList){
            System.out.println(lotto.getLottoNumbers());
        }
    }

    public void showStatsIn(int[] results){
        System.out.println("3개 일치 (5,000원) - "+results[5]+"개");
        System.out.println("4개 일치 (50,000원) - "+results[4]+"개");
        System.out.println("5개 일치 (1,500,000원) - "+results[3]+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+results[2]+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+results[1]+"개");
    }

    public void showRateOfReturn(double rate){
        String result = String.format("%.1f", rate);
        System.out.println("총 수익률은 "+rate+"%입니다.");
//        System.out.println("총 수익률은 "+result+"%입니다.");
    }


}
