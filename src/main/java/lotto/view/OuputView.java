package lotto.view;

import static lotto.utils.OutputMessage.BRACKETS1;
import static lotto.utils.OutputMessage.BRACKETS2;

public class OuputView {
    public void printLotto(String lottoNumber) {
        System.out.println(BRACKETS1.getMessage() + lottoNumber + BRACKETS2.getMessage());
    }
}
