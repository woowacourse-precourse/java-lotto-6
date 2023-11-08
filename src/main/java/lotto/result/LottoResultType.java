package lotto.result;

import java.text.DecimalFormat;
import java.util.Arrays;

public enum LottoResultType {
    THREE(3, 5000L),
    FOUR(4, 50000L),
    FIVE(5, 1500000L),
    FIVE_PLUS_BONUS(5, 30000000L, true),
    SIX(6, 2000000000L);

    private int correctNumber;
    private Long price;
    private boolean useBonus = false;

    public Long getPrice() {
        return price;
    }

    LottoResultType(int correctNumber, Long price) {
        this.correctNumber = correctNumber;
        this.price = price;
    }

    LottoResultType(int correctNumber, Long price, boolean useBonus) {
        this.correctNumber = correctNumber;
        this.price = price;
        this.useBonus = useBonus;
    }

    // 당첨 번호 갯수와 보너스로 타입 검색
    public static LottoResultType findByCorrectNumberAndBonus(int correctNumber, boolean checkBonus) {
        // 당첨 숫자가 5개 일때만 보너스를 체크한다
        if (correctNumber == 5) {
            return Arrays.stream(values())
                    .filter(resultType -> resultType.correctNumber == correctNumber
                            && resultType.useBonus == checkBonus)
                    .findFirst().orElse(null);
        }
        return Arrays.stream(values())
                .filter(resultType -> resultType.correctNumber == correctNumber)
                .findFirst().orElse(null);

    }

    public void print(int count) {
        StringBuilder sb = new StringBuilder();

        sb.append(correctNumber).append("개 일치");

        if (useBonus) {
            sb.append(", 보너스 볼 일치");
        }

        sb.append(" (");
        // 천 단위로 "," 찍는 포맷
        DecimalFormat decFormat = new DecimalFormat("###,###");
        sb.append(decFormat.format(price)).append("원) - ");
        sb.append(count).append("개");

        System.out.println(sb);
    }

}
