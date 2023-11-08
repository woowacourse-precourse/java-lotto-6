package lotto.service;

import java.util.List;

public interface ValidateService {

    void checkCorrectMoney(String input);

    List<Integer> checkCorrectWinnerNumbers(String input);

    Integer checkIncludeChar(String input);
}
