package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.constants.LottoRank;

public class MatchedNumber {
    public static final String BONUS_NUMBER_DUPLICATE = "[ERROR] 입력된 보너스 번호와 중복된 번호가 있습니다.";
    private final Lotto matchedNumber;
    private final LottoNumber bonusNumber;


    public MatchedNumber(Lotto matchedNumber, LottoNumber bonusNumber) {
        validationDuplicate(matchedNumber.getLottoNumbers(), bonusNumber);
        this.matchedNumber = matchedNumber;
        this.bonusNumber = bonusNumber;
    }

    public List<LottoRank> getLottoRanks(List<Lotto> lottos) {
        return lottos.stream().map(lotto -> {
                    int matchedCount = countMatchedNumbers(matchedNumber.getLottoNumbers(), lotto);
                    boolean hasBonus = lotto.getLottoNumbers().contains(bonusNumber);
                    return LottoRank.evaluateLottoRank(matchedCount, hasBonus);
                })
                .collect(Collectors.toList());
    }

    private void validationDuplicate(List<LottoNumber> matchedNumber, LottoNumber bonusLottoNumber) {
        if (matchedNumber.contains(bonusLottoNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE);
        }
    }

    private int countMatchedNumbers(List<LottoNumber> userNumbers, Lotto lotto) {
        return (int) userNumbers.stream()
                .filter(number -> lotto.getLottoNumbers().contains(number))
                .count();
    }
}
