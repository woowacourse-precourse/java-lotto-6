package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;

public interface Input {

    static String readLine(){
        return Console.readLine();
    }

    default void printErrorMessage(RuntimeException e) {
        System.out.println(e.getMessage());
        System.out.println();
    }

}
