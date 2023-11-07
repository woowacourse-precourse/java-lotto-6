package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class UserInput {

    private final String startStr = "구입금액을 입력해 주세요.";
    private final String numStr = "당첨 번호를 입력해 주세요.";
    private final String bonusStr = "\n보너스 번호를 입력해 주세요.";
    private String inputString = "";


    public UserInput() {
    }

    protected int inputPrice() {
        int price = 0;

        System.out.println(startStr);
        inputString = Console.readLine();

        for(int i = 0; i < inputString.length(); i++) {
            checkDigit(i);
        }

        price = Integer.parseInt(inputString);

        if((price % 1000) != 0) {
            System.err.println("[ERROR] 구입 금액은 1000 단위로 나누어 떨어지는 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
        return price;
    }

    protected List<Integer> inputAnswer() {
        List<Integer> answerList = new ArrayList<>();

        System.out.println(numStr);
        inputString = Console.readLine();

        answerList = splitComma(inputString);

        return answerList;
    }

    protected int inputBonus(List<Integer> answer) {
        int bonus = 0;

        System.out.println(bonusStr);
        inputString = Console.readLine();

        try {
            bonus = Integer.parseInt(inputString);
        } catch (NumberFormatException ex) {
            System.err.println("[ERROR] 보너스 번호는 숫자로만 입력해야 합니다.");
            throw new IllegalArgumentException();
        }

        validate(bonus, answer);
        return bonus;
    }

    private void checkDigit(int i) {
        if(!Character.isDigit(inputString.charAt(i))) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자로만 입력해야 합니다.");
        }
    }

    private void validate(int num, List<Integer> answer) {
        if(num > 45 || num < 1) {
            System.err.println("[ERROR] 보너스 번호는 1~45 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
        if(Collections.frequency(answer, num) != 0) {
            System.err.println("[ERROR] 보너스 번호는 당첨 번호와 중복되면 안됩니다.");
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> splitComma(String input) {
        List<Integer> splitResult = new ArrayList<>();
        String[] temp = input.split(",");
        int number = 0;

        for(int i = 0; i < temp.length; i++) {
            try {
                number = Integer.parseInt(temp[i]);
            } catch (NumberFormatException ex) {
                System.err.println("[ERROR] 당첨 번호는 숫자로만(쉼표 제외) 입력해야 합니다.");
                throw new IllegalArgumentException();
            }
            splitResult.add(number);
        }
        return splitResult;
    }
}
