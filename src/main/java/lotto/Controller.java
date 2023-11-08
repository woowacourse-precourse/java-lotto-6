package lotto;

import java.util.ArrayList;
import java.util.List;
import static lotto.PlaceAndPrize.Place.firstPlace;

public class Controller {
    Generator generator = new Generator();
    Input input = new Input();
    Converter converter = new Converter();

    public void run() {
        List<Integer> wins = new ArrayList<>(List.of(0,0,0,0,0,0));

        int price = priceRequest();

        Messages.howManyBuy(price/1000);
        List<List<Integer>> createdGames = generator.createGames(price/1000);
        Messages.winNumberMessage();
        List<Integer> winNumbers = input.inputWinNumbers();
        Messages.bonusNumberMessage();
        int bonusNumber = input.inputBonusNumber(winNumbers);

        wins = judgeWins(winNumbers, bonusNumber, createdGames, wins);

        Messages.winsMessage(wins);
        int prize = converter.carculateWinPrize(wins);
        double earn = ((double) prize / price) * 100;
        Messages.prizeMessage(prize,earn);
    }

    public int priceRequest () {
        Messages.priceMessage();
        return input.inputPrice();
    }

    public List<Integer> judgeWins(List<Integer> winNumbers, int bonusNumber, List<List<Integer>> createdGames, List<Integer> wins) {
        for (List<Integer> createdNumbers : createdGames) {
            int place = judgeNumber(winNumbers, bonusNumber, createdNumbers);
            wins.set(place, wins.get(place) + 1);
        }
        return wins;
    }

    public int judgeNumber(List<Integer> winNumber, int bonusNumber, List<Integer> createdNumber) {
        int count = 0;
        boolean bonusMatch = false;
        for (int value:createdNumber) {
            if (winNumber.contains(value)) {
                count++;
            }
            if (value == bonusNumber) {
                bonusMatch = true;
            }
        }
        return place(count, bonusMatch);
    }

    public int place(int count, boolean bonusMatch) {
        if (count == firstPlace.getMatchPlace()) {
            return 0;
        }
        if (count == firstPlace.getMatchPlace()-1) {
            if (bonusMatch){
                return 1;
            }
            return 2;
        }
        if (count == firstPlace.getMatchPlace()-2) {
            return 3;
        }
        if (count == firstPlace.getMatchPlace()-3) {
            return 4;
        }
        return 5;
    }
}
