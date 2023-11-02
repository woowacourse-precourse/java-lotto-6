package lotto.io;

import camp.nextstep.edu.missionutils.Console;


import java.util.List;

public class Input {

    public int getMoney() {
        return Integer.parseInt(Console.readLine());
    }

    public List<Integer> getWinningNumbers() {
        List<String> numbers = List.of(Console.readLine().split(","));
        return numbers.stream().mapToInt(Integer::parseInt).boxed().toList();
    }

    public int getBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }
}
