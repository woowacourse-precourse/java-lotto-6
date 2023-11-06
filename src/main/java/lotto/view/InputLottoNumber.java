package lotto.view;


import lotto.exception.BlankException;
import lotto.exception.NotNumberException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputLottoNumber {
    private static final String LOTTO_CHOICE_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final InputThings inputThings = new InputThings();

    public void printNotice() {
        System.out.println(LOTTO_CHOICE_MESSAGE);
    }

    public int buyLotto() {
        printNotice();
        String buyLotto = inputThings.inputThings().trim();
        validate(buyLotto);
        getValue(buyLotto);
        return Integer.parseInt(buyLotto);
    }

    public List<Integer> numberConvert(String checkedInput) {
        List<String> getNumbers = getValue(checkedInput);
        List<Integer> lottoNumbers = new ArrayList<>();
        for (String lottoNumber : getNumbers) {
            lottoNumbers.add(Integer.valueOf(lottoNumber));
        }
        return lottoNumbers;
    }

    private List<String> getValue(String checkedInput) {
        return Arrays.asList(checkedInput.split(","));
    }

    public void validate(String buyLotto) {
        blankInput(buyLotto);
        numberValidateLotto(buyLotto);
    }

    private void blankInput(String buyLotto) {
        if (buyLotto == null) {
            throw new BlankException();
        }
    }

    private void numberValidateLotto(String buyLotto) {
        String num = "^[0-9]*$";
        if (!Pattern.matches(buyLotto, num)) {
            throw new NotNumberException();
        }
    }




}


