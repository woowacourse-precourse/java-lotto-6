package lotto.engine;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.Lotto;
import lotto.LottoScore;
import lotto.numbergenerator.NumberGenerator;

public class GameEngine {
    public static final int LOTTO_NUMBER_MIN_VALUE = 1;
    public static final int LOTTO_NUMBER_MAX_VALUE = 45;
    public static final int LOTTO_NUMBER_SIZE = 6;
    public static final int LOTTO_PRICE = 1000;
    public static final String ANSWER_LOTTO_NUMBERS_DELMITER = ",";
    public static final int MAKE_PERCENT = 100;
    private final GameEngineValidator gameEngineValidator;
    private final NumberGenerator numberGenerator;
    private List<Lotto> lottos;
    private Lotto answerLotto;
    private int bonusNumber;

    public GameEngine(GameEngineValidator gameEngineValidator, NumberGenerator numberGenerator) {
        this.gameEngineValidator = gameEngineValidator;
        this.numberGenerator = numberGenerator;
    }

    public void createLottos(String readLine) {
        gameEngineValidator.checkPrice(readLine);
        lottos = new ArrayList<>();
        long lottoSize = Long.parseLong(readLine) / LOTTO_PRICE;
        for (long i = 0; i < lottoSize; i++) {
            List<Integer> lottoNumbers = numberGenerator.generateNumbers(LOTTO_NUMBER_MIN_VALUE, LOTTO_NUMBER_MAX_VALUE,
                    LOTTO_NUMBER_SIZE);
            gameEngineValidator.checkLottoNumbers(lottoNumbers);
            lottos.add(new Lotto(lottoNumbers));
        }
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public int getLottoSize() {
        return lottos.size();
    }

    public void createAnswerLotto(String readLine) {
        gameEngineValidator.checkReadLineLottoNumbers(readLine);
        answerLotto = new Lotto(
                Arrays.stream(readLine.split(ANSWER_LOTTO_NUMBERS_DELMITER)).map(Integer::parseInt).toList());
    }

    public void createAnswerBonusNumber(String readLine) {
        gameEngineValidator.checkBonusNumber(readLine);
        bonusNumber = Integer.parseInt(readLine);
    }

    public List<LottoScore> getCalculateScore() {
        List<LottoScore> lottoScores = new ArrayList<>();
        for (Lotto lotto : lottos) {
            long matchLottoNumberCount = getMatchLottoNumberCount(lotto);
            long matchBonusLottoNumberCount = getMatchBonusLottoNumberCount(lotto);
            lottoScores.add(LottoScore.getMatchLottoScore(matchLottoNumberCount, matchBonusLottoNumberCount));
        }
        return lottoScores;
    }

    public double getEarningPercent() {
        BigDecimal originalPrice = new BigDecimal(lottos.size() * LOTTO_PRICE);
        BigDecimal earningPrice = new BigDecimal(getEarningPrice());
        return earningPrice
                .divide(originalPrice)
                .multiply(new BigDecimal(MAKE_PERCENT))
                .doubleValue();
    }

    private long getEarningPrice() {
        return getCalculateScore().stream()
                .mapToLong(LottoScore::getReward)
                .sum();
    }

    private long getMatchLottoNumberCount(Lotto lotto) {
        return lotto.getNumbers().stream()
                .filter(lottoNumber -> answerLotto.getNumbers().contains(lottoNumber))
                .count();
    }

    private long getMatchBonusLottoNumberCount(Lotto lotto) {
        return lotto.getNumbers().stream()
                .filter(lottoNumber -> bonusNumber == lottoNumber)
                .count();
    }
}
