package lotto;

import java.util.List;

public class UI {
    Member member=new Member();
    public UI() {
    }

    public void priceComment(){
        System.out.println("구입금액을 입력해 주세요.");

        priceInput();
    }

    public void priceInput(){
        String price=camp.nextstep.edu.missionutils.Console.readLine();
        System.out.println();

        member.setPrice(price);

        purchaseComment(member.getCount());
    }

    public void purchaseComment(int count){
        String purchase=count+"개를 구매했습니다.";
        System.out.println(purchase);

        //lottoOutput(member.getMemberLotto());
    }

    public void lottoOutput(List<Lotto> memberLotto){

        for(int i=0;i<memberLotto.size();i++){
            System.out.println(memberLotto.get(i));
        }

        System.out.println();
    }
}
