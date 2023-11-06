package lotto.view;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {
    public int getCash() {
        String given = readLine();
        return Integer.parseInt(String.valueOf(given));
    }

    public List<Integer> getWinningNums() {
        return Arrays.stream(readLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int getBonusNum() {
        return Integer.parseInt(readLine());
    }
}
