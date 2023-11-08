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


}
