package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum LottoResult {
    FIRST(2000000000, "6개 일치 (2,000,000,000원) - "),
    SECOND(30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(1500000, "5개 일치 (1,500,000원) - "),
    FOURTH(50000, "4개 일치 (50,000원) - "),
    FIFTH(5000, "3개 일치 (5,000원) - "),
    NONE(0, "낫싱");

    LottoResult(int grade, String message) {
        this.grade = grade;
        this.message = message;
    }

    private String message;
    private int grade;

    public static LottoResult initiateLottoResult(int size) {
        Map<Integer, LottoResult> sizeToLottoResult = new HashMap<>();
        sizeToLottoResult.put(6, FIRST);
        sizeToLottoResult.put(5, THIRD);
        sizeToLottoResult.put(4, FOURTH);
        sizeToLottoResult.put(3, FIFTH);
        sizeToLottoResult.put(10, SECOND);

        return sizeToLottoResult.getOrDefault(size, NONE);
    }

    public static void calculateGradeWithCount(Map<LottoResult, Integer> map) {
        System.out.println(LottoResult.FIFTH.getMessage() + map.getOrDefault(LottoResult.FIFTH, 0) + "개");
        System.out.println(LottoResult.FOURTH.getMessage() + map.getOrDefault(LottoResult.FOURTH, 0) + "개");
        System.out.println(LottoResult.THIRD.getMessage() + map.getOrDefault(LottoResult.THIRD, 0) + "개");
        System.out.println(LottoResult.SECOND.getMessage() + map.getOrDefault(LottoResult.SECOND, 0) + "개");
        System.out.println(LottoResult.FIRST.getMessage() + map.getOrDefault(LottoResult.FIRST, 0) + "개");
    }

    public int getGrade() {
        return this.grade;
    }

    public String getMessage() {
        return this.message;
    }
}
