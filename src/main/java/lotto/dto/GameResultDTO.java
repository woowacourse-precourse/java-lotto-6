package lotto.dto;

import java.util.Map;

public class GameResultDTO {

    private final Map<String, Integer> prize;

    public GameResultDTO(Map<String, Integer> prize) {

        this.prize = prize;
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("3개 일치 (5,000원) - ").append(prize.get("5등")).append("개\n")
                .append("4개 일치 (50,000원) - ").append(prize.get("4등")).append("개\n")
                .append("5개 일치 (1,500,000원) - ").append(prize.get("3등")).append("개\n")
                .append("5개 일치, 보너스 볼 일치 (30,000,000원) - ").append(prize.get("2등")).append("개\n")
                .append("6개 일치 (2,000,000,000원) - ").append(prize.get("1등")).append("개\n");

        return stringBuilder.toString();
    }
}
