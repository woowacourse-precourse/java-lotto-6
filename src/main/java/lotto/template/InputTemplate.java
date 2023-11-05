package lotto.template;

import camp.nextstep.edu.missionutils.Console;
import lotto.valid.Valid;

import java.util.List;
import java.util.NoSuchElementException;

public class InputTemplate {

    public String execute(String message, Callback callback) {
        while (true) {
            try {
                System.out.println(message);
                String text = Console.readLine();
                callback.valid(text);
                System.out.println();
                return text;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

}
