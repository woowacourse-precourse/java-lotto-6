package ui.input;

import camp.nextstep.edu.missionutils.Console;
import parser.IntegerParser;

import java.util.List;
public class BonusNumbers {
    public static List<Integer> getBonusNumbers() {

        System.out.println("보너스 번호를 입력해 주세요.");
        String BonusNumberInput = Console.readLine();

        IntegerParser parser = new IntegerParser();
        List<Integer> bonusNumbers = parser.parseNumbers(BonusNumberInput);

        return bonusNumbers;
    }
}
