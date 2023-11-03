package lotto;

import camp.nextstep.edu.missionutils.Console;

public class ExceptionStrategyHandler {

    public void strategy() {
        try {

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
