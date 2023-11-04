package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.regex.Pattern;

public class User {

    private List<Lotto> lottos;

    public Integer inputMoney(){
        String money = Console.readLine();
        validate(money);
        return Integer.parseInt(money);
    }

    private void validate(String money){
        validateFormat(money);
    }

    private void validateFormat(String money){
        if (!Pattern.compile("\\d+").matcher(money).matches()) {
            throw new IllegalArgumentException();
        }
    }
}
