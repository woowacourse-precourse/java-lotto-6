package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.LottoMatchCount;
import lotto.exception.*;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoInfo;
import lotto.model.Lottos;
import lotto.validator.InputPriceValidator;
import lotto.view.LottoInputView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.service.constant.LottoServiceMessage.*;

public class LottoService {
    public LottoService() {
    }

    public static Lottos create(String price) {
        try {
            InputPriceValidator.validatePrice(price);
        } catch (InvalidPriceTypeException | InvalidInputException | EmptyException | InvalidPriceRangeException | InvalidInputPriceException e) {
            return create(LottoInputView.requestInputPrice());
        }
        Integer priceInt = Integer.parseInt(price);
        return new Lottos(getLottosList(priceInt));
    }

    private static List<LottoInfo> getLottosList(Integer priceInt) {
        return IntStream.range(START_INDEX.getValue(), priceInt / DIVIDE_BY.getValue())
                .mapToObj(i -> createRandomLottoInfoDTO())
                .collect(Collectors.toList());
    }

    private static LottoInfo createRandomLottoInfoDTO() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN.getValue(), LOTTO_NUMBER_MAX.getValue(), LOTTO_NUMBER_SIZE.getValue());
        return new LottoInfo(new Lotto(sortingLottoNumbers(numbers)));
    }

    private static List<Integer> sortingLottoNumbers(List<Integer> numbers) {
        return numbers.stream().sorted().collect(Collectors.toList());
    }

    public static LottoMatchCount checkTotalMatchCount(Lottos randomLottos, BonusNumber bonusNumber, Lotto winningLotto) {
        int countOf3 = countMatches(randomLottos,winningLotto, MATCH_COUNT_3.getValue());
        int countOf4 = countMatches(randomLottos,winningLotto, MATCH_COUNT_4.getValue());
        int countOf5 = countMatches(randomLottos,winningLotto, MATCH_COUNT_5.getValue());
        int countOf5AndBonus = countMatchesWithBonus(randomLottos,winningLotto, bonusNumber);
        int countOf6 = countMatches(randomLottos,winningLotto, MATCH_COUNT_6.getValue());
        return new LottoMatchCount(countOf3, countOf4, countOf5, countOf5AndBonus, countOf6);
    }

    private static int countMatches(Lottos randomLottos,Lotto winningLotto, int targetCount) {
        int count = (int) randomLottos.getLottoInfoList().stream()
                .filter(lottoInfo -> hasMatchCount(lottoInfo, winningLotto, targetCount))
                .count();
        randomLottos.getLottoInfoList().forEach(LottoInfo::resetMatchCount);
        return count;
    }

    private static int countMatchesWithBonus(Lottos randomLottos, Lotto winningLotto,BonusNumber bonusNumber) {
        int count = (int) randomLottos.getLottoInfoList().stream()
                .filter(lottoInfo -> hasMatchCount(lottoInfo,winningLotto, MATCH_COUNT_5.getValue()) && lottoInfo.isMatchBonus(bonusNumber))
                .count();
        randomLottos.getLottoInfoList().forEach(LottoInfo::resetMatchCount);
        return count;
    }

    private static boolean hasMatchCount(LottoInfo lottoInfo, Lotto winningLotto, int targetCount) {
        return lottoInfo.countMatch(winningLotto) == targetCount;
    }
}
