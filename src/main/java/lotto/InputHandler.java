package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {
    public static int purchaseAmountInput(){
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = Integer.parseInt(Console.readLine());

        return purchaseAmount;
    }

    public static List<Integer> winningNumberInput(){
        System.out.println("당첨번호를 입력해 주세요.");

        String input = Console.readLine();
        String[] winningStringNumbers = input.split(",");

        List<Integer> winningNumbers = new ArrayList<>();

        for(int i=0;i<6;i++){
            winningNumbers.add(Integer.parseInt(winningStringNumbers[i]));
        }

        return winningNumbers;
    }

    public static int bonusNumberInput(){
        System.out.println("보너스 번호를 입력해 주세요.");
        int bounsNumber = Integer.parseInt(Console.readLine());

        return bounsNumber;
    }


}
