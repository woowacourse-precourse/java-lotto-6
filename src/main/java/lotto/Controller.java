package lotto;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    final int firstPlace = 6;
    Generator generator = new Generator();
    Input input = new Input();
    Converter converter = new Converter();

    public void run() {
        List<Integer> winNumbers;
        List<Integer> wins = new ArrayList<>(List.of(0,0,0,0,0,0));
        int bonusNumber;

        Messages.priceMessage();
        int price = input.inputPrice();
        int ticket = price / 1000;
        Messages.howManyBuy(ticket);

        winNumbers = generator.numbersGenerator();
        bonusNumber = generator.bonusNumberGenerator(winNumbers);

        for (int i =0; i < ticket; i++) {
            Lotto lotto = new Lotto(generator.numbersGenerator());
            System.out.println(lotto.getNumbers());
            List<Integer> createdNumber = lotto.getNumbers();
            int place = judgeNumber(winNumbers, bonusNumber, createdNumber);
            wins.set(place,wins.get(place)+1);
        }

        Messages.winsMessage(wins);
        int prize = converter.carculateWinPrize(wins);
        double earn = ((double) prize / price) * 100;
        Messages.prizeMessage(prize,earn);

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

    private int place(int count, boolean bonusMatch) {
        if (count == firstPlace) {
            return 0;
        }
        if (count == firstPlace-1) {
            if (bonusMatch){
                return 1;
            }
            return 2;
        }
        if (count == firstPlace-2) {
            return 3;
        }
        if (count == firstPlace-3) {
            return 4;
        }
        return 5;
    }

}
