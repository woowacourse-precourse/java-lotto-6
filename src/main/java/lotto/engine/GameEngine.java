package lotto.engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Lotto;
import lotto.numbergenerator.NumberGenerator;

public class GameEngine {
    public static final int LOTTO_NUMBER_MIN_VALUE = 1;
    public static final int LOTTO_NUMBER_MAX_VALUE = 45;
    public static final int LOTTO_NUMBER_SIZE = 6;
    public static final int LOTTO_PRICE = 1000;
    private final GameEngineValidator gameEngineValidator;
    private final NumberGenerator numberGenerator;
    private List<Lotto> lottos;

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
}
