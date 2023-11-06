package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final InputView instance = new InputView();

    public static InputView getInstance(){
        return instance;
    }
    private InputView() {
    }

}