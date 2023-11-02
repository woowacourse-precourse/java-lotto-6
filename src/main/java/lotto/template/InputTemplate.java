package lotto.template;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class InputTemplate {

    public String execute(String message, Callback callback) {
        try {
            System.out.println(message);

            String text = Console.readLine();

            System.out.println();

            callback.valid(text);

            return text;
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("값이 존재하지 않습니다.", e);
        }
    }
}
