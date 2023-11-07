package lotto;

import java.util.ArrayList;

public class GameRepository {
    private final ArrayList<Lotto> lottos = new ArrayList<>();
    private Lotto winLottoNumber;

    public void saveNumber(ArrayList<Integer> numbers){
        lottos.add(new Lotto(numbers));
    }

    public void saveWinLottoNumber(ArrayList<Integer> numbers){
        winLottoNumber = new Lotto(numbers);
    }
}
