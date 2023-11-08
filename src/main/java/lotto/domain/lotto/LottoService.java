package lotto.domain.lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.number.LottoNumber;
import lotto.domain.number.LottoNumberService;

import java.util.List;
import lotto.domain.user.User;
import lotto.global.enums.LottoPrize;

public class LottoService {
    private final LottoNumberService lottoNumberService;
    public static final int LOTTO_PRICE = 1000;

    public LottoService(LottoNumberService lottoNumberService){
        this.lottoNumberService = lottoNumberService;
    }

    public List<LottoResultResponse> getLottoStatistics(final User user, final Lotto raffledLotto) {
        Map<LottoPrize, Long> countedPrizes = countPrize(user, raffledLotto);
        return countedPrizes.entrySet().stream()
                .map(entry -> LottoResultResponse.from(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    public Lotto buyLotto(){
        return Lotto.forUserLotto(lottoNumberService.pickAutoNumbers());
    }

    public RaffleLottoResponse raffleLotto(final List<LottoNumber> lottoNumbers){
        return new RaffleLottoResponse(Lotto.raffle(lottoNumbers));
    }

    public RaffleLottoResponse addBonusNumber(final Lotto lotto, final LottoNumber lottoNumber){
        lotto.addBonusNumber(lottoNumber);
        return new RaffleLottoResponse(lotto);
    }
    private Map<LottoPrize, Long> countPrize(final User user, final Lotto raffledLotto) {
        Map<LottoPrize, Long> prizeCount = initPrizeCount();

        user.getMyLotto().forEach(lotto -> {
            int matchedNormalCount = countMatchedNormalNumber(lotto, raffledLotto);
            int bonusNumberCount = checkMatchedBonusNumber(lotto, raffledLotto.getBonusNumber()) ? 1 : 0;
            LottoPrize determinedPrize = LottoPrize.determinePrize(matchedNormalCount, bonusNumberCount);

            if (determinedPrize != LottoPrize.NONE) {
                user.addPrize(determinedPrize.getPrize());
                prizeCount.put(determinedPrize, prizeCount.get(determinedPrize) + 1);
            }
        });

        return prizeCount;
    }

    private Map<LottoPrize, Long> initPrizeCount(){
        List<LottoPrize> prizeList = Arrays.asList(LottoPrize.values());
        Collections.reverse(prizeList);
        return prizeList.stream()
                .filter(prize -> prize != LottoPrize.NONE)
                .collect(Collectors.toMap(prize -> prize, prize -> 0L, (a, b) -> b, LinkedHashMap::new));
    }

    private int countMatchedNormalNumber(final Lotto userLotto, final Lotto raffledLotto){
        List<LottoNumber> userNumbers = userLotto.getNumbers();
        List<LottoNumber> raffledNumbers = raffledLotto.getNumbers();

        return (int) userNumbers.stream().filter(number -> !number.isBonus())
                .filter(userNumber -> raffledNumbers.stream()
                        .anyMatch(raffledNumber -> raffledNumber.equals(userNumber) && !raffledNumber.isBonus()))
                .count();
    }

    private boolean checkMatchedBonusNumber(final Lotto userLotto, final LottoNumber bonusNumber){
        return userLotto.getNumbers().contains(bonusNumber);
    }

}
