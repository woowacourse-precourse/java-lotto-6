package lotto.View;

import lotto.Logic.Lotto;
import lotto.Logic.Member;
import lotto.Logic.Prize;
import lotto.Logic.WinningNumber;

import java.util.ArrayList;
import java.util.List;

public class UI {
    private Member member=new Member();
    private WinningNumber winningNumber=new WinningNumber();


    public UI() {
    }


    public void priceComment(){
        System.out.println("구입금액을 입력해 주세요.");

        priceInput();
    }

    public void priceInput(){
        String price=camp.nextstep.edu.missionutils.Console.readLine();
        System.out.println();

        try{
            member.setPriceValid(price);
            purchaseComment(member.getCount());

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            priceComment();
        }
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
    }


    public void numberInput(){
        String number=camp.nextstep.edu.missionutils.Console.readLine();
        System.out.println();

        try{
            winningNumber.splitValid(number);
            bonusComment();

        } catch (IllegalArgumentException e){

            System.out.println(e.getMessage());
            numberComment();
        }
    }

    public void bonusComment(){
        System.out.println("보너스 번호를 입력해 주세요.");

        bonusInput();
    }

    public void bonusInput(){
        String bonus=camp.nextstep.edu.missionutils.Console.readLine();
        System.out.println();

        try{
            winningNumber.setBonusValid(bonus);
            staticComment();

        }catch (IllegalArgumentException e){

            System.out.println(e.getMessage());
            bonusComment();
        }
    }

    public void staticComment(){
        System.out.println("당첨 통계");
        System.out.println("---");

        winningNumber.calculate(member.getMemberLotto(),member);

        staticOutput(member.prizeResult());
    }

    public void staticOutput(List<Integer> result){

        System.out.println("3개 일치 (5,000원) - "+result.get(4)+"개");
        System.out.println("4개 일치 (50,000원) - "+result.get(3)+"개");
        System.out.println("5개 일치 (1,500,000원) - "+result.get(2)+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+result.get(1)+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+result.get(0)+"개");

        profitOutput();
    }

    public void profitOutput(){
        String profit=member.getProfit();
        String totalProfit="총 수익률은 "+profit+"%입니다.";

        System.out.print(totalProfit);
    }

}
