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

    public void start(){
        int quantity = getLottoQuantity();
        output.showNumberOfLotto(quantity);

        Lottos lottos = new Lottos(quantity);
        output.showLottoNumbers(lottos);

        Player player = new Player(getWinningNumbers(),getBonusNumber(),quantity);
        Result result = judge.calculateWinning(player,lottos);
        output.showStatistic(result);

        result.setEarningRate(judge.calculateEarningRate(result,quantity));
        output.showEarningLate(result.getEarningRate());
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
            System.out.println("Cost should be divided by 1000.");
            return getLottoQuantity();
        }
    }

    private Lotto getWinningNumbers(){
        List<Integer> numbers = splitNumbers(input.getWinningNumber());
        try{
            validateWinningNumbers(numbers);
            validateDuplicate(numbers);
            return new Lotto(numbers);
        } catch (IllegalArgumentException e){
            getWinningNumbers();
            return getWinningNumbers();
        }
    }

    private int getBonusNumber(){
        int number = Integer.parseInt(input.getBonusNumber());
        try{
            validateBonusNumber(number);
            return number;
        } catch (IllegalArgumentException e){
            getBonusNumber();
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
    }

    private void validateDuplicate(List<Integer> numbers){
        if(numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException("[ERROR] Lotto Numbers shouldn't be duplicated. ");
        }
    }
}
