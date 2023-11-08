package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private List<Lotto> lottos;
    private static int START_NUMBER = 1;
    private static int LAST_NUMBER = 45;
    private static int LOTTO_SIZE = 6;

    public Lottos(int numberOfLotto){
        lottos = new ArrayList<>();
        createLottos(numberOfLotto);
    }

    public List<Lotto> getLottos(){
        return lottos;
    }

    private void createLottos(Integer numberOfLotto){
        for(int i=0;i<numberOfLotto;i++){
            List<Integer> oneLotto = createLotto();
            oneLotto = oneLotto.stream()
                    .sorted()
                    .collect(Collectors.toList());
            lottos.add(new Lotto(oneLotto));
        }
    }

    public List<Integer> createLotto(){
        return Randoms.pickUniqueNumbersInRange(START_NUMBER, LAST_NUMBER, LOTTO_SIZE);
    }
}
