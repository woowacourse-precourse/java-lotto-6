package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class InputBonus {

    private static final String INPUT_BONUS_MESSAGE = "보너스 번호를 입력해 주세요.";


    private int getBonus() {
        System.out.println(INPUT_BONUS_MESSAGE);
        String bonus = Console.readLine();
        System.out.println();
        validate(bonus);
    }

    private void validate(String bonus) {
        if (!Pattern.compile("\\d+").matcher(bonus).matches()) {
            throw new IllegalArgumentException();
        }
    }

}
