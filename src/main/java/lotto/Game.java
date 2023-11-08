package lotto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Player;
import lotto.domain.Result;
import lotto.view.Input;
import lotto.view.Output;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_PRICE = 1000;

    private final Input input = new Input();
    private final Output output = new Output();
    private final Judge judge = new Judge();
    Lotto winningNumbers;
    int bonusNumber;

    public void start(){
        int quantity = getLottoQuantity();
        output.showNumberOfLotto(quantity);

        Lottos lottos = new Lottos(quantity);
        output.showLottoNumbers(lottos);

        winningNumbers = getWinningNumbers();
        bonusNumber = getBonusNumber();

        Player player = new Player(winningNumbers, bonusNumber, quantity);
        Result result = judge.makeResult(player,lottos);

        output.showResult(result);
    }

    private int getLottoQuantity(){
        try {
            String string = input.getCost();
            validateInput(string);
            int cost = stringToInt(string);
            validateLottoQuantity(cost);
            return cost/LOTTO_PRICE;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getLottoQuantity();
        }
    }

    private Lotto getWinningNumbers(){
        try{
            String string = input.getWinningNumber();
            validateInput(string);
            List<Integer> numbers = splitNumbers(string);
            validateWinningNumbers(numbers);
            validateDuplicate(numbers);
            return new Lotto(numbers);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return getWinningNumbers();
        }
    }

    private int getBonusNumber(){
        try{
            String string = input.getBonusNumber();
            validateInput(string);
            int number = Integer.parseInt(string);
            validateBonusNumber(number);
            return number;
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return getBonusNumber();
        }
    }

    private int stringToInt(String input){
        return Integer.parseInt(input);
    }

    private List<Integer> splitNumbers(String input){
        String[] numbers = input.split(",");
        List<Integer> result = new ArrayList<>();
        for(String string : numbers){
            result.add(Integer.parseInt(string));
        }
        return result;
    }

    private void validateInput(String input){
        if(input.isEmpty()){
            throw new IllegalArgumentException("[ERROR] You should enter input.");
        }
    }

    private void validateLottoQuantity(int cost){
        if(!(cost%LOTTO_PRICE == 0)){
            throw new IllegalArgumentException("[ERROR] Cost should be divided by 1000.");
        }
    }

    private void validateWinningNumbers(List<Integer> numbers){
        if(numbers.size() != LOTTO_NUMBER_COUNT){
            throw new IllegalArgumentException("[ERROR] Lotto numbers should be 6.");
        }
        for(int number : numbers){
            if(!(number>=START_INCLUSIVE && number<=END_INCLUSIVE)){
                throw new IllegalArgumentException("[ERROR] Winning number should be between 1 and 45.");
            }
        }
        if(numbers.size() != numbers.stream().distinct().count()){
            System.out.println(numbers);
            throw new IllegalArgumentException("[ERROR] Numbers shouldn't be duplicated.");
        }
    }

    private void validateBonusNumber(int number){
        if(!(number>=START_INCLUSIVE && number<=END_INCLUSIVE)){
            throw new IllegalArgumentException("[ERROR] Bonus number should be between 1 and 45.");
        }
        if(winningNumbers.getNumbers().contains(number)){
            throw new IllegalArgumentException("[ERROR] Winning Numbers and bonus number shouldn't be same.");
        }
    }

    private void validateDuplicate(List<Integer> numbers){
        if(numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException("[ERROR] Lotto Numbers shouldn't be duplicated. ");
        }
    }
}
