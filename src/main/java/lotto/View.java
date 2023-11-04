package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.util.Validator;

public class View {
    public long inputLottoBuyCash(){
        String input=readLine();

        Validator.INSTANCE.numberValidate(input);

        return Long.parseLong(input);
    }
}
