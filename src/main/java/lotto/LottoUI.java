package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class LottoUI {
    public enum PrintMessage{
        INPUT_MONEY("구입금액을 입력해 주세요."),
        INPUT_WIN_NUMBER("당첨 번호를 입력해 주세요."),
        INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요.");
        private final String message;

        PrintMessage(String message){
            this.message = message;
        }

        public String getMessage(){
            return message;
        }
    }
    public String userInput(){
        return Console.readLine();
    }

    public void userPrint(String message){
        System.out.println(message);
    }

    public void userPrint(List<Integer> number) {
        System.out.println(number);
    }

    public void buyLottoNumbersPrint(ArrayList<Lotto> buyLottoNumbers){
        for (Lotto number : buyLottoNumbers){
            userPrint(number.getLottoNumbers());
        }
    }

    public void winnerLottoNumberPrint(int[] winLotto, double rateOfReturn){
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(String.format("3개 일치 (5,000원) - %d개", winLotto[0]));
        System.out.println(String.format("4개 일치 (50,000원) - %d개", winLotto[1]));
        System.out.println(String.format("5개 일치 (1,500,000원) - %d개", winLotto[2]));
        System.out.println(String.format("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", winLotto[3]));
        System.out.println(String.format("6개 일치 (2,000,000,000원) - %d개", winLotto[4]));
        System.out.println(String.format("총 수익률은 %.1f",  rateOfReturn)+"%입니다.");
    }

    public void buyLottoCountPrint(int buyCount){
        System.out.println(buyCount+"개를 구매했습니다.");
    }
}
