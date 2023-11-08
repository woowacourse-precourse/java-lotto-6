package lotto.view;

import java.util.regex.Pattern;
import lotto.exception.WrongFormatException;

public class InputBonusNumberView extends InputView{
    private static final Pattern FORMAT = Pattern.compile("\\d{1,2}");
    private static final String INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public Integer getValue(){
        while(true) {
            try {
                System.out.println(INPUT_MESSAGE);
                String bonus = input();
                System.out.println();
                validate(bonus);
                return Integer.parseInt(bonus);
            } catch (IllegalArgumentException e) {}
        }
    }

    public void validate(String inputValue){
        if(!FORMAT.matcher(inputValue).matches()){
            throw new WrongFormatException();
        }
    }
}