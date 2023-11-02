package lotto.service;

import java.util.List;

public interface ValidateService {

    void checkCorrectMoneyInput(String input);

    List<Integer> checkCorrectWinnerNumbersInput(String input);
}
