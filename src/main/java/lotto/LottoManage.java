package lotto;

import java.util.List;

public class LottoManage {
    //구입한 로또번호 저장
    private List<Lotto> lottos;
    //당첨번호
    private Lotto correct_lotto;
    private int money;

    public LottoManage(String input){
        //입력받은 돈 money에 저장
        this.money=Integer.parseInt(input);
        validate();
        //당첨번호 생성
    }

    //사용자가 입력한 값이 올바른지 판단하는함수
    public void validate(){
        if(money<0||money%1000!=0){
            throw new IllegalArgumentException();
        }
    }
}
