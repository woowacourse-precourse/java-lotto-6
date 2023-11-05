package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Player;
import lotto.view.Input;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Input input = new Input();

    public void start(){
        int quantity = getLottoQuantity();
        Lottos lottos = new Lottos(quantity);
        Player player = new Player(getWinningNumbers(),getBonusNumber(),getBonusNumber());


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
