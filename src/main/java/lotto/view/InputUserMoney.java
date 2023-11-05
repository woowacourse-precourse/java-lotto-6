package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class InputUserMoney {
    private static final Pattern PATTERN = Pattern.compile("\\d+");

    public Integer getInput(){
        System.out.println("구매금액을 입력해 주세요.");
        String userMoney = Console.readLine();
        checkValidate(userMoney);
        return Integer.parseInt(userMoney);
    }

    private void checkValidate(String userMoney) {
        if (!PATTERN.matcher(userMoney).matches()) {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 입력값입니다. ");
        }
    }
}
