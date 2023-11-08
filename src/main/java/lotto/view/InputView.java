package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class InputView {

    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(camp.nextstep.edu.missionutils.Console.readLine());
    }

    public List<Integer> inputAnswer() {
        System.out.println("당첨 번호를 입력해 주세요.");
        int[] nums = Stream.of(camp.nextstep.edu.missionutils.Console.readLine()
                .split(",")).mapToInt(Integer::parseInt).toArray();
        List<Integer> answer = new ArrayList<Integer>();
        for(int num:nums){answer.add(num);}
        return answer;
    }

    public int inputBonus() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(camp.nextstep.edu.missionutils.Console.readLine());
    }
}
