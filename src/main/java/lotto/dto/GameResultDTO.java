package lotto.dto;

import lotto.constant.PrizeMoney;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Map;

public class GameResultDTO {
    private final Map<String, Integer> prize;
    private String gameResult;

    public GameResultDTO(Map<String, Integer> prize) {

        this.prize = prize;

        makeGameResultDTO();
    }

    private void makeGameResultDTO() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("3개 일치 (").append(PrizeMoney.FIFTH)
                     .append("원) - ").append(prize.get("5등")).append("개\n")
                     .append("4개 일치 (").append(PrizeMoney.FORTH)
                     .append("원) - ").append(prize.get("4등")).append("개\n")
                     .append("5개 일치 (").append(PrizeMoney.THIRD)
                     .append("원) - ").append(prize.get("3등")).append("개\n")
                     .append("5개 일치, 보너스 볼 일치 (").append(PrizeMoney.SECOND)
                     .append("원) - ").append(prize.get("2등")).append("개\n")
                     .append("6개 일치 (").append(PrizeMoney.FIRST)
                     .append("원) - ").append(prize.get("1등")).append("개\n");

        gameResult = stringBuilder.toString();
    }

    @Override
    public String toString() {

        return gameResult;
    }
}
