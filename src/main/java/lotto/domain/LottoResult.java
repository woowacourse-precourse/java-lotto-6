package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public enum LottoResult {
    FIRST(2000000000, (num) -> num * 2000000000, "6개 일치 (2,000,000,000원) - "),
    SECOND(30000000, (num) -> num * 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(1500000, (num) -> num * 1500000, "5개 일치 (1,500,000원) - "),
    FOURTH(50000, (num) -> num * 50000, "4개 일치 (50,000원) - "),
    FIFTH(5000, (num) -> num * 5000, "3개 일치 (5,000원) - "),
    NONE(0, (num) -> num * 0, "낫싱");

    LottoResult(int grade, Function<Integer, Integer> expression, String message) {
        this.grade = grade;
        this.expression = expression;
        this.message = message;
    }

    private Function<Integer, Integer> expression;

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

    public int calculate(int num) {
        return this.expression.apply(num);
    }

    public int getGrade() {
        return this.grade;
    }

    public String getMessage() {
        return this.message;
    }
}
