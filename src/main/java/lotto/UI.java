package lotto;

import java.util.List;

public class UI {
    Member member=new Member();
    public UI() {
    }

    public void priceInput(){
        System.out.println("구입금액을 입력해 주세요.");
        String price=camp.nextstep.edu.missionutils.Console.readLine();

        member.setPrice(price);

        purchaseCount(member.getCount());
    }

    public void purchaseCount(int count){
        String purchase=count+"개를 구매했습니다.";
        System.out.println(purchase);

        lottoOutput(member.getMemberLotto());
    }

    public void lottoOutput(List<Lotto> memberLotto){

        for(int i=0;i<memberLotto.size();i++){
            System.out.println(memberLotto.get(i));
        }

        System.out.println();
    }
}
