package lotto.view;

import lotto.Lotto;

public class OutputView {
    public void amountMessage(){
        System.out.println("구입 금액을 입력해 주세요.");
    }
    public void countMessage(int count){
        System.out.println(count+"개를 구매했습니다.");
    }
    public  void lottoNumberMessage(String lottoNumber){
        System.out.println(lottoNumber);
    }
}
