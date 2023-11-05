package lotto.template;

import camp.nextstep.edu.missionutils.Console;
import lotto.valid.Valid;

import java.util.List;
import java.util.NoSuchElementException;

public class InputTemplate {

    public String execute(String message, Callback callback) {
        try {
            System.out.println(message);
            String text = Console.readLine();
            callback.valid(text);
            System.out.println();
            return text;
        } catch (NoSuchElementException e) {
            System.out.println("[ERROR] 값이 존재하지 않습니다.");
            return execute(message, callback);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return execute(message, callback);
        }
    }

}
