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

    public static int getIntInput(){
        String _input=getInput();
        try{
            int val=Integer.parseInt(_input);
            validateInRange(val);
            return val;
        }catch (IllegalArgumentException e){
            print("[ERROR] 1 이상 45 이하의 보너스 숫자를 입력해 주세요.");
            return getIntInput();
        }
    }

    public static List<Integer> getListInput() {
        String _input = getInput();
        try {
            List<Integer> parsedOutput = toIntegerList(_input);
            validate6Length(parsedOutput);
            return parsedOutput;
        } catch (NumberFormatException e) {
            print("[ERROR] 올바르지 못한 숫자");
        } catch (IllegalArgumentException e) {
            print("[ERROR] 로또 번호는 1 이상 45 사이 숫자 중 중복 없이 6개를 골라야 합니다.");
        }
        return getListInput();
    }

    private static List<Integer> toIntegerList(String _input) throws NumberFormatException, IllegalArgumentException {
        List<Integer> parsedOutput = new ArrayList<>();
        for (String s : _input.split(",")) {
            int number = Integer.parseInt(s);
            validateDuplicate(parsedOutput, number);
            validateInRange(number);
            parsedOutput.add(number);
        }
        return parsedOutput;
    }

    private static void validateInRange(int number) throws IllegalArgumentException {
        if (number < 1) {
            throw new IllegalArgumentException();
        }
        if (number > 45) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateDuplicate(List<Integer> parsedOutput, int number) throws IllegalArgumentException {
        if (parsedOutput.contains(number)) {
            throw new IllegalArgumentException();
        }
    }

    private static void validate6Length(List<Integer> parsedOutput) {
        if (parsedOutput.size() != 6) {
            throw new IllegalArgumentException();
        }
    }


}
