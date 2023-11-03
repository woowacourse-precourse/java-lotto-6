package lotto.View;

import lotto.Logic.Lotto;
import lotto.Logic.Member;
import lotto.Logic.WinningNumber;

import java.util.List;

public class UI {
    Member member=new Member();
    WinningNumber winningNumber=new WinningNumber();

    public UI() {
    }

    public void priceComment(){
        System.out.println("구입금액을 입력해 주세요.");

        priceInput();
    }

    public void priceInput(){
        String price=camp.nextstep.edu.missionutils.Console.readLine();
        System.out.println();

        member.setPriceValid(price);

        purchaseComment(member.getCount());
    }

    public void purchaseComment(int count){
        String purchase=count+"개를 구매했습니다.";
        System.out.println(purchase);

        lottoOutput(member.getMemberLotto());
    }

    public void lottoOutput(List<Lotto> memberLotto){

        for(int i=0;i<memberLotto.size();i++){
            Lotto lotto=memberLotto.get(i);
            System.out.println(lotto.toString());
        }

        System.out.println();
        numberComment();
    }
    public void numberComment(){
        System.out.println("당첨 번호를 입력해 주세요.");
        numberInput();

        System.out.println();
        bonusComment();
    }
    public void numberInput(){
        String number=camp.nextstep.edu.missionutils.Console.readLine();
        winningNumber.splitValid(number);
    }
    public void bonusComment(){
        System.out.println("보너스 번호를 입력해 주세요.");
        bonusInput();

        System.out.println();
        staticComment();
    }
    public void bonusInput(){
        String bonus=camp.nextstep.edu.missionutils.Console.readLine();
        winningNumber.setBonusValid(bonus);
    }
    public void staticComment(){
        System.out.println("당첨 통계");
        System.out.println("---");
    }
}
