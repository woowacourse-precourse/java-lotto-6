package lotto.game.io;

import java.util.List;

public interface Input {

    String line();

    List<String> strings();

    List<String> strings(String regex);

    int number();

    List<Integer> numbers();

    List<Integer> numbers(String regex);

}
