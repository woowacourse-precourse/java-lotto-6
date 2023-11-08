package lotto.view.output;

import lotto.utils.Templates;

public class DisplayError extends DisplayView {
    // Features
    public void displayBuyError() {
        initializeCache();
        addToCache(Templates.BUY_ERROR_MESSAGE);
        print();
    }

    public void displayWinningError() {
        initializeCache();
        addToCache(Templates.PRIZING_ERROR_MESSAGE);
        print();
    }

    public void displayBonusError() {
        initializeCache();
        addToCache(Templates.BONUS_ERROR_MESSAGE);
        print();
    }

}
