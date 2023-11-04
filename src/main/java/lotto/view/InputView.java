package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    public int getMoney() {
        System.out.println("구입금액을 입력해 주세요.");

        return Integer.parseInt(Console.readLine());
    }

    public List<Integer> getLottoWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요");
        String numbers = Console.readLine();

        return Stream.of(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

    }

    public int getBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }
}
