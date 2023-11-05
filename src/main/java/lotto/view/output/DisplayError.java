package lotto.view.output;

import lotto.utils.Templates;

public class DisplayError extends DisplayView {
    // Features
    public void displayBuyError() {
        initializaCache();
        addToCache(Templates.BUY_ERROR_MESSAGE);
        print();
    }

    public void displayWinningError() {
        initializaCache();
        addToCache(Templates.PRIZING_ERROR_MESSAGE);
        print();
    }

    public void displayBonusError() {
        initializaCache();
        addToCache(Templates.BONUS_ERROR_MESSAGE);
        print();
    }

}
