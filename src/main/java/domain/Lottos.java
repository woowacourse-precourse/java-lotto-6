package domain;

import Constants.LottosConstant;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(int numberOfPurchased){
        lottos = generateLottos(numberOfPurchased);
    }

    public static Lottos create(final int numberOfPurchased){
        return new Lottos(numberOfPurchased);
    }

    public List<Lotto> getLottos(){
        return lottos;
    }

    private List<Lotto> generateLottos(int numberOfPurchased){
        List<Lotto> lottos = new ArrayList<>();
        while(numberOfPurchased-- > 0){
            lottos.add(generateRandomNumbers());
        }
        return lottos;
    }

    private Lotto generateRandomNumbers(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                LottosConstant.MIN_VALUE.getValue(),
                LottosConstant.MAX_VALUE.getValue(),
                LottosConstant.LOTTO_SIZE.getValue());

        return new Lotto(numbers);
    }
}
