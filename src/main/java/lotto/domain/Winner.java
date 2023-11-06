package lotto.domain;

import java.util.List;

public class Winner {

    private Lotto lotto;
    private int bonus;
    private LottoResult lottoResult;

    public Winner(String lottoNumbers) {
        lotto = new Lotto(lottoNumbers);
    }

    public List<Integer> noticeLottoWinningNumbers() {
        return lotto.getLottoNumbers();
    }

    public void lottoWinningBonusNumber(String lottoWinningBonus) {
        this.bonus = changeInteger(lottoWinningBonus);
    }

    private int changeInteger(String lottoWinningBonus) {
        return Integer.parseInt(lottoWinningBonus);
    }

    public void compareWithUserLottoAndWinningLotto(User user) {
        lottoResult = new LottoResult();
        List<Lotto> userLottos = user.getLottos();
        for (Lotto userLotto : userLottos) {
            int sameNumberCount = checkUserLottoNumberCount(userLotto);

            lottoResult.addWinningCount(sameNumberCount);
            lottoResult.addTotalWinningMoney(sameNumberCount);
        }
    }

    private int checkUserLottoNumberCount(Lotto userLotto) {
        int sameNumberCount = 0;
        for (Integer lottoNumber : lotto.getLottoNumbers()) {
            if (userLotto.checkUserAndLottoNumbers(userLotto.getLottoNumbers(), lottoNumber)) {
                sameNumberCount += 1;
            }
        }
        if (sameFiveNumbersAndBonus(userLotto, sameNumberCount)) {
            sameNumberCount *= 10;
        }
        return sameNumberCount;
    }

    private boolean sameFiveNumbersAndBonus(Lotto userLotto, int sameNumberCount) {
        return sameNumberCount == 5 && userLotto.checkUserAndLottoNumbers(userLotto.getLottoNumbers(), bonus);
    }
}
