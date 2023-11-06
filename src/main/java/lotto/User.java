package lotto;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final int lottoCount;
    private final List<Lotto> lottos;

    private Lotto userLotto;
    private int bonusNumber;

    private int fifthPlace;
    private int fourthPlace;
    private int thirdPlace;
    private int secondPlace;
    private int firstPlace;

    public User(int price) {
        this.lottoCount = price / Const.PRICE_UNIT;
        this.lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(Lotto.createWinningNumbers());
        }
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void setUserLotto(Lotto lotto) {
        this.userLotto = lotto;
    }

    public Lotto getUserLotto() {
        return userLotto;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setFifthPlace(int count) {
        if (count == 3) {
            fifthPlace++;
        }
    }

    public int getFifthPlace() {
        return fifthPlace;
    }

    public void setFourthPlace(int count) {
        if (count == 4) {
            fourthPlace++;
        }
    }

    public int getFourthPlace() {
        return fourthPlace;
    }

    public void setThirdPlace(int count) {
        if (count == 5) {
            thirdPlace++;
        }
    }

    public int getThirdPlace() {
        return thirdPlace;
    }

    public void setSecondPlace(int count, boolean bonusHit) {
        if (count == 5 && bonusHit) {
            secondPlace++;
        }
    }

    public int getSecondPlace() {
        return secondPlace;
    }

    public void setFirstPlace(int count) {
        if (count == 6) {
            firstPlace++;
        }
    }

    public int getFirstPlace() {
        return firstPlace;
    }
}
