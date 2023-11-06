package lotto.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoService {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final LottoRepository lottoRepository;

    public LottoService(LottoRepository lottoRepository){
        this.lottoRepository = lottoRepository;
    }

    public Lottos issueLottos(int number) {
        List<Lotto> tempLottos = new ArrayList<>(number);

        for (int i = 0; i < number; i++) {
            tempLottos.add(new Lotto(createRandomNumberList()));
        }
        return new Lottos(new ArrayList<>(tempLottos));
    }

    private List<Integer> createRandomNumberList(){
        Set<Integer> numberSet = new HashSet<>();

        while (numberSet.size()<6){
            numberSet.add(getRandomNumber());
        }
        return new ArrayList<>(numberSet);
    }

    private int getRandomNumber() {
        return pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }

    public void checkWinningNumbers(){

    }

    public void calculatePrizeMoney(){

    }

}
