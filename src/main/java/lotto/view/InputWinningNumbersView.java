package lotto.view;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputWinningNumbersView extends InputView{
    private static final Pattern FORMAT = Pattern.compile("(\\d{1,2},){5}\\d{1,2}");
    private static final String INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";

    public List<Integer> getValue(){
        System.out.println(INPUT_MESSAGE);
        String numbers = input();
        System.out.println();
        validate(numbers);
        return Stream.of(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public void validate(String inputValue){
        if(!FORMAT.matcher(inputValue).matches()){
            throw new IllegalArgumentException();
        }
    }
}