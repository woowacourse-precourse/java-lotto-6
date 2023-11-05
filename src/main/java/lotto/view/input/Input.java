package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;

public abstract class Input {

    public static String readLine(){
        return Console.readLine();
    }

    public void printErrorMessage(RuntimeException e) {
        System.out.println(e.getMessage());
        System.out.println();
    }

}
