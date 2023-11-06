package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public int inputLottoPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");

        return toInt(Console.readLine());
    }

    public List<Integer> inputLottoWinningNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");

        return toIntList(Console.readLine());
    }

    public int inputLottoBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");

        return toInt(Console.readLine());
    }

    private List<Integer> toIntList(String str){
        return Arrays
                .stream(str.split(","))
                .mapToInt(this::toInt)
                .boxed()
                .toList();
    }
    private int toInt(String str){
        return Integer.parseInt(str);
    }
}
