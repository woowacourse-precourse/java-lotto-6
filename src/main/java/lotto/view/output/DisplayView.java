package lotto.view.output;

import lotto.utils.Templates;

public class DisplayView {
    // Fields
    StringBuilder cache = new StringBuilder();


    // Subclass Implements
    protected void initializaCache() {
        cache.setLength(0);
    }

    protected void addToCache(String string) {
        cache.append(string);
    }

    protected void addToCache(Templates string) {
        cache.append(string);
    }

    protected void print() {
        System.out.print(cache);
    }

}
