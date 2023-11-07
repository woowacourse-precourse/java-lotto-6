package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public abstract class Input {

    private static final String ERROR = "[ERROR]";
    private boolean isValidInput = false;

    public String readLine() {
        String data = "";
        while (!isValidInput) {
            try {
                data = Console.readLine();
                validate(data);
                isValidInput = true;
            } catch (IllegalArgumentException ex) {
                System.out.println(ERROR + ex.getMessage());
            }
        }
        System.out.println();
        return data;
    }

    public abstract void validate(String input);

}
