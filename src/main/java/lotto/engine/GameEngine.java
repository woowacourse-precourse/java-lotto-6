package lotto.engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Lotto;
import lotto.numbergenerator.NumberGenerator;

public class GameEngine {
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
        long lottoSize = Long.parseLong(readLine) / 1000;
        for (long i = 0; i < lottoSize; i++) {
            List<Integer> lottoNumbers = numberGenerator.generateNumbers(1, 45, 6);
            gameEngineValidator.checkLottoNumbers(lottoNumbers);
            lottos.add(new Lotto(lottoNumbers));
        }
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
