package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public static String inputPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        // 공백처리
        return Console.readLine().trim();
    }

    public static List<String> inputWinningNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] input = Console.readLine().trim().split("\\s*,\\s*");
        List<String> filteredInput = new ArrayList<>();
        for (String s : input){
            if (!s.isEmpty()){
                filteredInput.add(s);
            }
        }
        return filteredInput;

//        return input.trim().split("\\s*,\\s*");
    }

    public static String inputBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine().trim();
    }

}
