package lotto.view;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input extends Exceptions{
    public int getCash() {
        String given = readLine();
        checkType(given);
        return Integer.parseInt(String.valueOf(given));
    }

    public List<Integer> getWinningNums() {
        List<String> splits = Arrays.stream(readLine().split(",")).toList();
        for (String s : splits){
            checkType(s);
        }
        return splits.stream().map(Integer::parseInt).toList();
    }

    public int getBonusNum() {
        String given = readLine();
        checkType(given);
        return Integer.parseInt(given);
    }
}
