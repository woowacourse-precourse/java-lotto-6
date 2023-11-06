package lotto.domain;

import java.util.List;

public class WinningBundle {

    private final List<WinningNumber> winningBundle;

    private WinningBundle(List<WinningNumber> winningBundle) {
        this.winningBundle = winningBundle;
    }

    public static WinningBundle from(List<WinningNumber> winningBundle) {
        return new WinningBundle(winningBundle);
    }

}
