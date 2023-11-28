package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public String inputPurchaseMoney(){
        return Console.readLine();
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return List.of(Console.readLine().split(","))
                .stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
    }

    public int inputBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
