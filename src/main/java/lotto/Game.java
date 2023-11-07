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
        Result result = judge.calculateResult(player,lottos);

        output.showResult(result);
    }

    private int getLottoQuantity(){
        String string = input.getCost();
        int cost = stringToInt(string);
        try {
            if(!(cost%1000 ==0)){
                throw new IllegalArgumentException("[ERROR] Cost should be divided by 1000.");
            }
            return cost/1000;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getLottoQuantity();
        }
    }

    private Lotto getWinningNumbers(){
        try{
            List<Integer> numbers = splitNumbers(input.getWinningNumber());
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
            int number = Integer.parseInt(input.getBonusNumber());
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

    private void validateWinningNumbers(List<Integer> numbers){
        if(numbers.size() != 6){
            throw new IllegalArgumentException("[ERROR] Lotto numbers should be 6.");
        }
        for(int number : numbers){
            if(!(number>=1 && number<=45)){
                throw new IllegalArgumentException("[ERROR] Winning number should be between 1 and 45.");
            }
        }
        if(numbers.size() != numbers.stream().distinct().count()){
            System.out.println(numbers);
            throw new IllegalArgumentException("[ERROR] Numbers shouldn't be duplicated.");
        }
    }

    private void validateBonusNumber(int number){
        if(!(number>=1 && number<=45)){
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
