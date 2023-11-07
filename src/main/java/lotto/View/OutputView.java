package lotto.View;

import java.util.List;

public class OutputView {

    public void printPhrase(String phrase) {
        System.out.println(phrase);
    }

    public void printMultiplePhrase(List<String> phrases) {
        for (String phrase : phrases) {
            System.out.println(phrase);
        }
    }
}
