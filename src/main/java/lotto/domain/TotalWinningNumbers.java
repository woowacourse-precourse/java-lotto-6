package lotto.domain;

public class TotalWinningNumbers {
    Lotto winningLotto;
    int bonusNumber;

    public TotalWinningNumbers(Lotto lotto, int bonusNumber) throws IllegalArgumentException {
        validateBonusNumber(lotto,bonusNumber);
        this.winningLotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public LottoResult checkLottos(Lottos userLottos) {
        LottoResult lottoResult = new LottoResult();
        userLottos.getLottos()
                .forEach(lotto -> lottoResult.addResult(checkLotto(lotto)));
        return lottoResult;
    }

    private Rank checkLotto(Lotto userLotto) {
        return Rank.decideRank(countCollectNumbers(userLotto), checkBonusNumber(userLotto));
    }

    private void validateBonusNumber(Lotto lotto, int bonusNumber) throws IllegalArgumentException{
        validateNumberBoundary(bonusNumber);
        validateDuplication(lotto, bonusNumber);
    }

    private void validateNumberBoundary(int bonusNumber) throws IllegalArgumentException{
        if(bonusNumber<1 || bonusNumber>45){
            throw new IllegalArgumentException("[ERROR] 보너스 번호의 범위는 1부터 45 사이여야 합니다.");
        }
    }

    private void validateDuplication(Lotto lotto, int bonusNumber) throws IllegalArgumentException{
        if(lotto.getNumbers().contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 중복 됐습니다.");
        }
    }

    private int countCollectNumbers(Lotto userLotto) {
        return (int)winningLotto.getNumbers().stream()
                .filter(userLotto::hasNumber)
                .count();
    }

    private boolean checkBonusNumber(Lotto userLotto) {
        return userLotto.hasNumber(bonusNumber);
    }
}
