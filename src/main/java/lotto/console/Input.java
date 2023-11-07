package lotto.console;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Asset;
import lotto.domain.Lotto;
import lotto.service.Utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
    public static Asset askMoney(){
        try{
            System.out.println("구입금액을 입력해 주세요.");
            Double money = Utils.convertInput(Console.readLine());
            return new Asset(money);
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] :" + e.getMessage());
            return askMoney();
        }
    }

    public static Lotto askWinningNum(){
        try{
            System.out.println("당첨 번호를 입력해 주세요.");
            String inputString = Console.readLine();

            List<Integer> numbers = Arrays.stream(inputString.split(","))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());

            return new Lotto(numbers);
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] : " + e.getMessage());
            return askWinningNum();
        }
    }

    public static Integer askBonusNum(){
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.valueOf(Console.readLine());
    }
}
