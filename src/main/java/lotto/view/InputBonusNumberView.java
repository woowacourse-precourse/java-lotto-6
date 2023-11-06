package lotto.view;

import java.util.regex.Pattern;

public class InputBonusNumberView extends InputView{
    private static final Pattern FORMAT = Pattern.compile("\\d{1,2}");
    private static final String INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public Integer getValue(){
        System.out.println(INPUT_MESSAGE);
        String bonus = input();
        System.out.println();
        validate(bonus);
        return Integer.parseInt(bonus);
    }

    public void validate(String inputValue){
        if(!FORMAT.matcher(inputValue).matches()){
            throw new IllegalArgumentException();
        }
    }
}