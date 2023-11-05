package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Templates;

public class InputView {
    // Fields
    StringBuilder cache = new StringBuilder();


    // Features
    public String getUserBuyAmount() {
        initializaCache();
        addToCache(Templates.BUY_MESSAGE);
        print();

        String amount = Console.readLine();
        return amount;
    }

    public String getPrizingNumbers() {
        initializaCache();
        addToCache(Templates.GET_PRIZING_NUMBERS_MESSAGE);
        print();

        String numbers = Console.readLine();
        return numbers;
    }

    public String getBonusNumbers() {
        initializaCache();
        addToCache(Templates.GET_BONUS_NUMBER_MESSAGE);
        print();

        String bonus = Console.readLine();
        return bonus;
    }


    // Internal Implements
    private void initializaCache() {
        cache.setLength(0);
    }

    private void addToCache(Templates string) {
        cache.append(string);
    }

    private void print() {
        System.out.print(cache);
    }

}
