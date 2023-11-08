package lotto.domain.inputOutput.input;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputLotto {
    public Integer inputPayLottoMoney() throws IllegalArgumentException{
        System.out.println("구입금액을 입력해 주세요.");
        String inputMoney = Console.readLine();
        String pattern = "^[0-9]+$";
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(inputMoney);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
        }

        return Integer.parseInt(inputMoney);
    }


}
