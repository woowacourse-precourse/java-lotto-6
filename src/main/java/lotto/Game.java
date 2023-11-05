package lotto;

import camp.nextstep.edu.missionutils.Randoms;
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
        int cost = stringToInt(input.getCost());
        return cost / 1000;
    }


    private Lotto getWinningNumbers(){
        List<Integer> numbers = splitNumbers(input.getWinningNumber());
        return new Lotto(numbers);
    }
    private int getBonusNumber(){
        return Integer.parseInt(input.getBonusNumber());
    }

    private int stringToInt(String input){
        return Integer.parseInt(input);
    }

    private List<Integer> generateLottoNumbers(){
        return Randoms.pickUniqueNumbersInRange(1,45,6);
    }

    private List<Integer> splitNumbers(String input){
        String[] numbers = input.split(",");
        List<Integer> result = new ArrayList<>();
        for(String string : numbers){
            result.add(Integer.parseInt(string));
        }
        return result;
    }


}
