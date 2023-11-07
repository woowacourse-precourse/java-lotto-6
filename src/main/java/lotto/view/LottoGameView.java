package lotto.view;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import lotto.Lotto;
import lotto.model.Game;
import lotto.model.LottoGame;
import lotto.model.Winning;

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
        LottoGame lottoGame;
        lottoGame = (LottoGame) game;
        System.out.println(lottoGame.getLottoPurchaseAmount() + message.get("purchased"));
        for (Lotto lotto : lottoGame.getPurchasedLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }

    @Override
    public void showResultOf(Game game) {
        LottoGame lottoGame;
        lottoGame = (LottoGame) game;
        Winning currentRank = Winning.FIFTH;

        while (currentRank != Winning.LOSE) {
            System.out.println(matchingResult(currentRank, lottoGame));
            currentRank = currentRank.minus(1);
        }

        System.out.print(message.get("all-roi-prefix"));
        System.out.print(lottoGame.getReturnOnInvestment());
        System.out.print(message.get("all-roi-postfix"));
    }

    private String matchingResult(Winning rank, LottoGame game) {
        StringBuilder resultMessage;
        resultMessage = new StringBuilder();

        return resultMessage.append(rank.getMatchingNumbers())
                .append(message.get("matching"))
                .append(" (")
                .append(rank.getWinningAmount())
                .append(message.get("unit"))
                .append(") - ")
                .append(game.getWinningLottos().get(rank.getValue()))
                .append(message.get("count"))
                .append("\n");
    }
}
