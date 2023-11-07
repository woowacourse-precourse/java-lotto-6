package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.function.Consumer;

public final class UserInput {
    // 검증 통과할 때까지 사용자 입력
    public static String getValidInput(Consumer<String> validation) {
        boolean sucess = false;
        String input = null;
        while (!sucess) {
            input = Console.readLine();
            try {
                validation.accept(input);
                sucess = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return input;
    }
}
