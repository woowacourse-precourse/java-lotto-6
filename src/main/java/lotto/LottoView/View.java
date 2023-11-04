package lotto.LottoView;
import camp.nextstep.edu.missionutils.Console;
public class View {
    public int inputMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public String winNumber(){
        System.out.println("당첨 번호를 입력해 주세요");
        return Console.readLine();
    }

    public int bonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요");
        return Integer.parseInt(Console.readLine());
    }

    public void showTickets(){
        System.out.println("개를 구매했습니다.");
    }

    public void showResult(){
        System.out.println("당첨 통계\n---");
    }
}
