package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class UserInput {
    public int inputLottoBuyPrice() {
        System.out.println("구입 금액을 입력해주세요");
         int number = Integer.parseInt(Console.readLine());
         return number;
    }
    public List<Integer> inputWinnerNumber(){
        List<Integer> winnerNumber = new ArrayList<>();

        String lottoStr = Console.readLine();
        String[] lottoStrArr = lottoStr.split(",");
        for(int i=0; i<lottoStrArr.length; i++){
            winnerNumber.add(Integer.parseInt(lottoStrArr[i]));
        }
        return winnerNumber;
    }
    public Integer inputBonusNumber(){
        System.out.println("보너스 번호를 입력하세요");
        Integer bonusNumber = Integer.valueOf(Console.readLine());
        return bonusNumber;
    }
}
