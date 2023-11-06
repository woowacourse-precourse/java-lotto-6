package lotto.view;


import java.util.ArrayList;
import java.util.List;

public class InputLottoNumber {
    private static final String LOTTO_CHOICE_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String LOTTO_BONUS_CHOICE_MESSAGE = "보너스 번호를 입력해 주세요.";
    private final List<String> lottoNumber = new ArrayList<>();
    private final InputThings inputThings = new InputThings();

    public void printNotice() {
        System.out.println(LOTTO_CHOICE_MESSAGE);
    }





}


