package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class OutputView {

    private static final OutputView instance = new OutputView();

    public static OutputView getInstance(){
        return instance;
    }
    private OutputView() {
    }

}