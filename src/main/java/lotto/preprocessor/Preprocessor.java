package lotto.preprocessor;

import camp.nextstep.edu.missionutils.Console;

public abstract class Preprocessor<T> {
    public String receive() {
        String userInput = Console.readLine();
        return userInput;
    }

    public T process(String message) {
        String userInput;
        do {
            System.out.println(message);
            userInput = receive();
        } while (isInvalid(userInput));
        return convert(userInput);
    }

    public abstract boolean isInvalid(String userInput);
    public abstract T convert(String userInput);
}
