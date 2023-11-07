package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class UserInput {
    public int inputLottoBuyPrice() {
         int number = Integer.parseInt(Console.readLine());
         return number;
    }
    public List<Integer> inputWinnerNumber(){
        List<Integer> realLotto = new ArrayList<>();

        String lottoStr = Console.readLine();
        String[] lottoStrArr = lottoStr.split(",");
        for(int i=0; i<lottoStrArr.length; i++){
            realLotto.add(Integer.parseInt(lottoStrArr[i]));
        }
        realLotto.add(Integer.parseInt(Console.readLine()));

        return realLotto;
    }
}
