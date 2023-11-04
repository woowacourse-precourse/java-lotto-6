package lotto.view.input.Template;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputValidatorTemplate {
    public <T> T InputWithValidation(InputValidatorCallback<T> validator) {
        while (true) {
            try {
                String input = readLine();
                return validator.validate(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
