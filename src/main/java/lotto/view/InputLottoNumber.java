package lotto.view;


import lotto.exception.BlankException;

import java.util.ArrayList;
import java.util.List;

public class InputLottoNumber {
    private static final String LOTTO_CHOICE_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final InputThings inputThings = new InputThings();

    public void printNotice() {
        System.out.println(LOTTO_CHOICE_MESSAGE);
    }

    public Integer buyLotto() {
        printNotice();
        String buyLotto = inputThings.inputThings().trim();
        validate(buyLotto);
        return Integer.parseInt(buyLotto);
    }

    public void validate(String buyLotto) {
        blankInput(buyLotto);
    }

    private void blankInput(String buyLotto) {
        if (buyLotto == null) {
            throw new BlankException();
        }
    }




}


