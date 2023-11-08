package lotto;


import java.util.ArrayList;
import java.util.List;
import static lotto.Utils.RandomNumber.generator;

public class ComputerLotto {
    private final List<Lotto> computerLottos;
    public ComputerLotto(int lottoAmount){
        this.computerLottos = new ArrayList<>();
        generateComputerLottoNumbers(lottoAmount);
    }
    public void generateComputerLottoNumbers(int lottoAmount) {
        for (int i = 0; i < lottoAmount; i++) {
            List<Integer> computerNumbers = generator();
            computerLottos.add(new Lotto(computerNumbers));
        }
    }



}
