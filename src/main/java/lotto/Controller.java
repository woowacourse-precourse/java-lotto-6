package lotto;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    Generator generator = new Generator();
    Input input = new Input();

    public void run() {
        Messages.priceMessage();
        int ticket = input.ticket();
        Messages.howManyBuy(ticket);


    }

    public List<List<Integer>> createGames(int ticket) {
        List<List<Integer>> games = new ArrayList<>();
        List<Integer> tempLotto;
        for (int i = 0; i < ticket; i++) {
            Lotto lotto = new Lotto(generator.numbersGenerator());
            tempLotto = lotto.getNumbers();
            games.add(tempLotto);
        }
        return games;
    }
}
