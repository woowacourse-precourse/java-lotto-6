package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> numbers = new ArrayList<>();
        List<Integer> randomNumber = new ArrayList<>();
        Lotto lotto = new Lotto(numbers);
        lotto.playLotto();
    }
}
