package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.dao.LottoRepository;
import lotto.dto.LottoDto;
import lotto.dto.LottoProfitResult;
import lotto.exception.LottoErrorCode;

import java.util.*;
import java.util.stream.IntStream;

import static lotto.constants.LottoConstants.*;

public class LottoService {

    private final LottoRepository lottoRepository;

    public LottoService(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
    }


    public String buyLotto(final int moneyToBuy) {
        validateMoney(moneyToBuy);
        final int availableLotto = moneyToBuy / LOTTO_PRICE;

        final List<Lotto> lottos = IntStream.range(0, availableLotto)
                .mapToObj(i -> issue())
                .toList();

        final String buyerKey = UUID.randomUUID().toString();
        lottoRepository.save(buyerKey, lottos);

        return buyerKey;
    }

    public List<LottoDto> getLottos(final String buyerKey) {
        return lottoRepository.findByKey(buyerKey)
                .orElseThrow(() -> new NoSuchElementException(LottoErrorCode.NOT_FOUND_KEY.getMessage()))
                .stream()
                .map(Lotto::toDto)
                .toList();
    }

    public LottoProfitResult checkProfit(final String buyerKey, final Lotto goal, final Integer bonusNumber) {
        final List<Lotto> boughtLottos = findOrThrow(buyerKey);
        return calculate(boughtLottos, goal, bonusNumber);
    }

    public void validateMoney(final int moneyToBuy) {
        if (moneyToBuy < LOTTO_PRICE) {
            throw new IllegalArgumentException(LottoErrorCode.NOT_ENOUGH_MONEY.getMessage());
        }
        if (moneyToBuy % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(LottoErrorCode.WRONG_PRICE.getMessage());
        }
    }

    private List<Lotto> findOrThrow(final String key) {
        return lottoRepository.findByKey(key)
                .orElseThrow(() -> new NoSuchElementException(LottoErrorCode.NOT_FOUND_KEY.getMessage()));

    }


    private LottoProfitResult calculate(final List<Lotto> lottos, final Lotto goal, final Integer bonusNumber) {
        final List<Prize> matches = lottos.stream()
                .map(lotto -> {
                    int match = lotto.matchCount(goal);
                    boolean withBonus = goal.contains(bonusNumber);
                    return Prize.findPrizeByMatch(match, withBonus);
                })
                .toList();

        final List<LottoProfitResult.Info> results = getResults(matches);

        final int totalProfit = matches.stream().mapToInt(Prize::getProfit).sum();

        return new LottoProfitResult(results, (double) totalProfit / (lottos.size() * LOTTO_PRICE) * 100.0);
    }

    private List<LottoProfitResult.Info> getResults(List<Prize> matches) {

        return Arrays.stream(Prize.values())
                .filter(Prize::gotPrize)
                .map(prize -> {
                    int count = (int) matches.stream().filter(f -> f.equals(prize)).count();
                    return LottoProfitResult.Info.from(prize, count);
                })
                .sorted(byRank)
                .toList();
    }

    private static final Comparator<LottoProfitResult.Info> byRank =
            Comparator.comparing(LottoProfitResult.Info::rank)
                    .thenComparing(LottoProfitResult.Info::withBonus);


    private Lotto issue() {
        final List<Integer> numbers = generateUniqueLottoNumbers().stream()
                .sorted().toList();
        return new Lotto(numbers);
    }


    private List<Integer> generateUniqueLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN, LOTTO_MAX, LOTTO_LENGTH);
    }

}
