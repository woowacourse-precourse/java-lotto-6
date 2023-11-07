package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
//        NumberGenerator generator = new NumberGenerator();
//        List<Integer> numbers = new ArrayList<>();
//        numbers = generator.numberGenerator();
//        System.out.println(numbers);
//        Judgement judgement = new Judgement();
        LottoGame lottoGame = new LottoGame();
        lottoGame.play();
    }
}

