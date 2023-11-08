package lotto;

import lotto.domain.Buy;
import lotto.domain.Draw;
import lotto.domain.Judgement;
import lotto.domain.Prize;
import lotto.view.PrintGames;

import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Buy buy = new Buy();
        Draw draw = new Draw();
        Judgement judgement = new Judgement(buy, draw);
        PrintGames printGames = new PrintGames();
        // 로또 구매 및 발행
        buy.createGames(printGames);
        // 당첨 번호 뽑기
        draw.winningNumbers();
        // 번호 비교하기
        judgement.correctNumbers(printGames);
    }
}
