package lotto.ui;

import java.util.List;

public interface Input {
    int getPrice();

    List<Integer> getWinningNumbers();

    Integer getBonusNumbers();
}
