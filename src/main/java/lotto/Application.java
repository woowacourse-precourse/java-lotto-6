package lotto;

import lotto.domain.Buy;
import lotto.domain.Draw;
import lotto.domain.Judgement;
import lotto.domain.Prize;

import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Buy buy = new Buy();
        Draw draw = new Draw();
        Judgement judgement = new Judgement(buy, draw);
        // 로또 구매 및 발행
        buy.createGames();
        // 당첨 번호 뽑기
        draw.winningNumbers();
        // 번호 비교하기
        judgement.correctNumbers();
//        Map<String, Integer> tMap = new HashMap<>();
//        tMap.put("test", 10);
//        tMap.put("test", tMap.get("test")+10);
//        System.out.println(tMap);
//        System.out.println(tMap.get("test"));
    }
}
