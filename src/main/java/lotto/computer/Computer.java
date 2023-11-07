package lotto.computer;

import java.util.List;
import lotto.lotto.Lotto;
import lotto.lotto.Lottos;

public class Computer {

    private final RandomLottoGenerator randomLottoGenerator;
    private final ResultGenerator resultGenerator;

    public Computer(RandomLottoGenerator randomLottoGenerator, ResultGenerator resultGenerator) {
        this.randomLottoGenerator = randomLottoGenerator;
        this.resultGenerator = resultGenerator;
    }

    public Lottos createUserLottos() {
        return randomLottoGenerator.createUserLottos();
    }

    public Result createResult(Lottos lottos) {
        return resultGenerator.createResult(lottos);
    }

    public void setMoney(int money) {
        randomLottoGenerator.setMoney(money);
    }

    public void setLottoNumber(List<Integer> numbers) {
        resultGenerator.setWinningLotto(new Lotto(numbers));
    }

    public void setBonusNumber(int bonusNumber) {
        resultGenerator.setBonusNumber(bonusNumber);
    }
}
