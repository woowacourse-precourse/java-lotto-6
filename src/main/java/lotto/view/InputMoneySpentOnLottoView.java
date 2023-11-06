package lotto.view;

import java.util.regex.Pattern;

public class InputMoneySpentOnLottoView extends InputView{
    private static final Pattern FORMAT = Pattern.compile("\\d+");
    private static final String INPUT_MESSAGE = "구입금액을 입력해 주세요.";

    public Integer getValue(){
        System.out.println(INPUT_MESSAGE);
        String money = input();
        System.out.println();
        validate(money);
        return Integer.parseInt(money);
    }

    public void validate(String inputValue){
        if(!FORMAT.matcher(inputValue).matches()){
            throw new IllegalArgumentException();
        }
    }
}
