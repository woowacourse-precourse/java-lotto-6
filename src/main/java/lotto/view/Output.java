package lotto.view;

import java.util.List;

public class Output {
    public void printPurchaseAmount(){
        System.out.println("구매금액을 입력해주세요.");
    }

    public void printRandomLottoNum(List<List<Integer>> lottoNumGather){
        System.out.println(lottoNumGather.size() + "개를 구매했습니다.");
        for(List<Integer> lottoNum : lottoNumGather){
            System.out.println(lottoNum.toString());
        }
    }

    public void printGetLottoAnswer(){
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printGetBonusNum(){
        System.out.println("보너스 번호를 입력해 주세요.");
    }
}
