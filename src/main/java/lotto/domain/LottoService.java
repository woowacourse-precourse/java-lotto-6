package lotto.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static lotto.domain.constants.LottoNumber.MAX_NUMBER;
import static lotto.domain.constants.LottoNumber.MIN_NUMBER;
import static lotto.domain.constants.LottoNumber.NUMBER_COUNT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoService {
    private final static int INITIAL_VALUE = 0;
    private final static int COUNT_FOR_FIRST_RANKING = 6;
    private final static int COUNT_FOR_SECOND_RANKING = 1;
    private final static int COUNT_FOR_THIRD_RANKING = 5;
    private final static int COUNT_FOR_FOURTH_RANKING = 4;
    private final static int COUNT_FOR_FIFTH_RANKING = 3;
    private final static int FIRST_RANKING = 1;
    private final static int SECOND_RANKING = 2;
    private final static int THIRD_RANKING = 3;
    private final static int FOURTH_RANKING = 4;
    private final static int FIFTH_RANKING = 5;

    private final LottoRepository lottoRepository;
    private PurchaseCount purchaseCount;
    private WinningLotto winningLotto;
    private WinningResult winningResult;

    public LottoService(LottoRepository lottoRepository){
        this.lottoRepository = lottoRepository;
    }

    public Lottos findAllLottos(){
        return lottoRepository.findAll();
    }

    public void savePurchaseCount(int purchaseAmount) {
        this.purchaseCount = new PurchaseCount(purchaseAmount);
    }

    public int findPurchaseCount() {
        return purchaseCount.getValue();
    }

    public void saveWinningLotto(List<Integer> numbers, int bonusNumber) {
        this.winningLotto = new WinningLotto(numbers, bonusNumber);
    }

    public WinningLotto findWinningLotto() {
        return winningLotto;
    }

    public void saveWinningResult(List<Integer> totalRankingCount) {
        this.winningResult = new WinningResult(totalRankingCount);
    }

    public WinningResult findWinningResult() {
        return winningResult;
    }

    public void issueLottos(int number) {
        List<Lotto> tempLottos = new ArrayList<>(number);

        for (int i = 0; i < number; i++) {
            tempLottos.add(new Lotto(createRandomNumberList()));
        }

        lottoRepository.saveAll(new Lottos(new ArrayList<>(tempLottos)));
    }

    private List<Integer> createRandomNumberList(){
        Set<Integer> numberSet = new HashSet<>();

        while (numberSet.size()<NUMBER_COUNT.getValue()){
            numberSet.add(getRandomNumber());
        }

        return new ArrayList<>(numberSet);
    }

    private int getRandomNumber() {
        return pickNumberInRange(MIN_NUMBER.getValue(), MAX_NUMBER.getValue());
    }


    public void createWinningResult(Lottos lottos, WinningLotto winningLotto){
        List<Integer> totalRankingCount = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));

        for (Lotto lotto : lottos.getLottos()) {
            int matchingCount = INITIAL_VALUE;
            int matchingBonusCount = INITIAL_VALUE;
            for (int lottoNumber : lotto.getNumbers()) {
                matchingCount = getMatchingCount(winningLotto, lottoNumber, matchingCount);
                matchingBonusCount = getMatchingBonusCount(winningLotto,  lottoNumber, matchingBonusCount);
            }
            int ranking = getRanking(matchingCount, matchingBonusCount);
            putRanking(ranking, totalRankingCount);
        }
        System.out.println(totalRankingCount);
        saveWinningResult(totalRankingCount);
    }

    private static int getMatchingCount(WinningLotto winningLotto, int lottoNumber, int matchingCount) {
        if (winningLotto.getNumbers().contains(lottoNumber)) {
            matchingCount++;
        }
        return matchingCount;
    }

    private static int getMatchingBonusCount(WinningLotto winningLotto, int lottoNumber, int matchingBonusCount) {
        if (winningLotto.getBonusNumber() == lottoNumber) {
            matchingBonusCount++;
        }
        return matchingBonusCount;
    }

    private int getRanking(int matchingCount, int matchingBonusCount){
        if (matchingCount == COUNT_FOR_FIFTH_RANKING){ return FIFTH_RANKING; }
        if (matchingCount == COUNT_FOR_FOURTH_RANKING){ return FOURTH_RANKING; }
        if (matchingCount == COUNT_FOR_THIRD_RANKING){
            if (matchingBonusCount == COUNT_FOR_SECOND_RANKING){ return SECOND_RANKING; }
            return THIRD_RANKING;
        }
        if (matchingCount == COUNT_FOR_FIRST_RANKING){ return FIRST_RANKING; }
        return INITIAL_VALUE;
    }

    private static void putRanking(int ranking, List<Integer> totalRankingCount) {
        if (ranking!=INITIAL_VALUE) {
            int index = ranking - 1;
            int count = totalRankingCount.get(index);
            totalRankingCount.set(index, count + 1);
        }
    }

    public void calculatePrizeMoney(){

    }

}
