package lotto;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class IOGetter {

    public String getMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public String getLottoWinNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public String getLottoBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public void printNLottos(int n){
        System.out.println("\n" + n + "개를 구매했습니다.");
    }

    public void printLottos(String[] message){
        for (int i = 0; i < message.length; i++){
            System.out.println(message[i]);
        }
    }

    public String getWinningLotterNumbers(){
        System.out.println("\n당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public String getBonusNumber(){
        System.out.println("\n" + "보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public void printResult(List<String> args){
        System.out.println("당첨 통계");
        System.out.println("---");
        for (int i = 0; i < args.size()-1; i++){
            System.out.println(args.get(i));
        }
        System.out.println("총 수익률은 " + args.get(args.size()-1) + "%입니다.");
    }
}
