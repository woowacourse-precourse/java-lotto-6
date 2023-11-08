package lotto.view;

import java.util.InputMismatchException;
import java.util.regex.Pattern;
import lotto.exception.WrongFormatException;

public class InputMoneySpentOnLottoView extends InputView{
    private static final Pattern FORMAT = Pattern.compile("\\d+");
    private static final String INPUT_MESSAGE = "구입금액을 입력해 주세요.";

    public Integer getValue(){
        while(true) {
            try {
                System.out.println(INPUT_MESSAGE);
                String money = input();
                System.out.println();
                validate(money);
                return Integer.parseInt(money);
            } catch (WrongFormatException e) {}
        }
    }

    public void validate(String inputValue){
        if(!FORMAT.matcher(inputValue).matches()){
            throw new WrongFormatException();
        }
    }
}
