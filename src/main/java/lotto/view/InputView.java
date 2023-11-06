package lotto.view;


import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    public InputView() {
    }

    public String removeWhitespace(String input){
        return Stream.of(input)
                .flatMap(userInput -> userInput.chars()
                        .mapToObj(element -> (char) element)
                        .filter(element -> !Character.isWhitespace(element))
                        .map(String::valueOf))
                .collect(Collectors.joining());
    }

}
