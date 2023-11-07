package lotto.view;

import lotto.Lotto;

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
}
