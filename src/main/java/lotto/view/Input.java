package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public abstract class Input {

    private boolean isValidInput = true;

    public String readLine() {
        String data = "";
        while (isValidInput) {
            try {
                data = Console.readLine();
                validate(data);
                isValidInput = false;
            } catch (IllegalArgumentException ex) {
                System.out.println("Exception in thread \"main\" java.lang.IllegalArgumentException");
                System.out.println("[ERROR]" + ex.getMessage());
            }
        }
        System.out.println();
        return data;
    }

    public abstract void validate(String input);

}
