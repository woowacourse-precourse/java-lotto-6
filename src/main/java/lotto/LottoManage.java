package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoManage {
    //구입한 로또번호 저장
    private List<Lotto> lottos;
    //당첨번호
    private Lotto correct_lotto;
    private int bonus;
    private int money;

    public LottoManage(String input){
        //입력받은 돈 money에 저장
        this.money=Integer.parseInt(input);
        validate();
        money/=1000;

        //로또 번호 생성
        lottos=new ArrayList<>();
        for (int i=0;i<money;i++){
            buy_Lotto();
        }
    }

    //사용자가 입력한 돈이 올바른지 판단하는함수
    private void validate(){
        if(money<0||money%1000!=0){
            throw new IllegalArgumentException();
        }
    }

    //correct_lotto와 bonus를 저장하는 함수
    public void setCorrect_lotto(List<Integer> input){
        this.correct_lotto=new Lotto(input);
    }
    public void setBonus(int input){
        this.bonus=input;
    }

    //money값에 따라 lotto를 생성하는 함수
    private void buy_Lotto(){
        List<Integer> numbers=Randoms.pickUniqueNumbersInRange(1,45,6);
        lottos.add(new Lotto(numbers));
    }

    //보유한 로또의 수량과 내용을 출력하는 함수
    public void print_lottos(){
        System.out.println(lottos.size()+"개를 구매했습니다.");
        for (Lotto lotto:lottos){
            lotto.print_lotto();
        }
    }

}
