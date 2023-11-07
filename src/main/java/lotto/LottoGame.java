package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {


    private RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    private List<Lotto> lottos = new ArrayList<>();
    public void startGame() {


    }


    public List<Lotto> buyLotto(int count) {
        for( int i =0 ; i< count; i++) {
            List<Integer> numbers = randomNumberGenerator.GenerateLottoNumbers();
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        return lottos;
    }





}
