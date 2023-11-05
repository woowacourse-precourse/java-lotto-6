package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Draw {

    private void getWinningLottoNumsList() {
        printWinningLottoNumsEnterGuideStatement();
        String input = Console.readLine();
        String[] strings = input.split(",");
    }

    List<Integer> toIntList(String[] strings) {

        List<Integer> nums = new ArrayList<>();

        for (String str : strings) {
            nums.add(toInt(str));
        }

        return nums;
    }

    int toInt(String str) {
        isInt(str);
        return Integer.parseInt(str);
    }

    void isInt(String str) {
        String regex = "^[0-9]+$";
        if (!str.matches(regex)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자여야 합니다.");
        }
    }

    private void printWinningLottoNumsEnterGuideStatement() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }
}
