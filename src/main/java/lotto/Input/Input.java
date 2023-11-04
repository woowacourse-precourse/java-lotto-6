package lotto.Input;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {
    public List<Integer> makeAnswerNumber() {
        String ans = readLine();
        List<Integer> answer = new ArrayList<>();
        String[] split = ans.split(",");
        for (int i = 0; i < split.length; i++) {
            answer.add(Integer.parseInt(split[i]));
        }
        return answer;
    }


}
