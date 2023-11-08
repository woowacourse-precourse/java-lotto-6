package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        this.lotto = new Lotto(numbers);
        this.bonusNumber = new LottoNumber(bonusNumber);

        validateBonusNumberDuplicated();
    }

    private void validateBonusNumberDuplicated() {
        if (bonusNumberMatches(lotto)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호는 중복될 수 없습니다.");
        }
    }

    public LottoResult result(Customer customer) {
        List<LottoRank> lottoRanks = customer.purchasedLottos().stream()
                .map(this::rank)
                .toList();
        return new LottoResult(lottoRanks);
    }

    private LottoRank rank(Lotto customerLotto) {
        return LottoRank.find(lotto.matchCount(customerLotto), bonusNumberMatches(customerLotto));
    }

    private boolean bonusNumberMatches(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }
}
