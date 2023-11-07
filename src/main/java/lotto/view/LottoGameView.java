package lotto.view;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import lotto.Lotto;
import lotto.model.Game;
import lotto.model.LottoGame;

public class LottoGameView implements GameView {
    private final Properties message = new Properties();

    public LottoGameView(String messagePath) {
        try (FileInputStream file = new FileInputStream(messagePath)) {
            message.load(file);
        } catch (IOException e) {
            throw new RuntimeException("[ERROR] 메시지 로드 오류", e);
        }
    }

    @Override
    public void showInputRequiredMessage(String key) {
        System.out.println(message.get(key));
    }

    @Override
    public void showProgressOf(Game game) {
        LottoGame lottoGame = (LottoGame) game;
        System.out.println(lottoGame.getLottoPurchaseAmount() + message.get("purchased"));
        for (Lotto lotto : lottoGame.getPurchasedLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }
}
