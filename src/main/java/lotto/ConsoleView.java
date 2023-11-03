package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class ConsoleView {
    public static void print(String output) {
        System.out.println(output);
    }

    public static String getInput() {
        return Console.readLine();
    }

    public static long getLongInput() {
        String _input = getInput();
        try {
            return Long.parseLong(_input);
        } catch (NumberFormatException e) {
            print("[ERROR] 유효하지 않은 숫자입니다.");
            return getLongInput();
        }
    }

    public static List<Integer> getListInput() {
        String _input = getInput();
        List<Integer> parsedOutput = new ArrayList<>();
        for (String s : _input.split(",")) {
            try {
                int number = Integer.parseInt(s);
                if (parsedOutput.contains(number)) {
                    throw new IllegalArgumentException();
                }
                if(number < 1 || number < 45){
                    throw new IllegalArgumentException();
                }
                parsedOutput.add(number);

            } catch (NumberFormatException e) {
                print("[ERROR] 올바르지 못한 숫자");
                return getListInput();
            } catch (IllegalArgumentException e) {
                print("[ERROR] 로또 번호는 중복되면 안됩니다.");
            }
        }
        if(parsedOutput.size()!=6){
            print("[ERROR] 당첨번호는 6개만 입력해주세요.");
            return getListInput();
        }
        return parsedOutput;
    }

}
