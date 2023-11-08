package lotto;

import java.util.Arrays;
import java.util.Optional;

public enum WinningPrice {
    FIFTY_HUNDRED("5,000", 3, false),
    FIFTY_THOUSAND("50,000", 4, false),
    ONE_POINT_FIVE_MILLION("1,500,000", 5, false),
    THREE_MILLION("30,000,000", 5, true),
    TWO_BILLION("2,000,000,000", 6, false),
    NONE("0", -1, false);

    private final String price;
    private final Integer correctCount;
    private final Boolean bonus;

    WinningPrice(String price, Integer correctCount, Boolean bonus) {
        this.price = price;
        this.correctCount = correctCount;
        this.bonus = bonus;
    }

    public static Long getPrice(WinningPrice winningPrice){
        return parseToLong(winningPrice.price);
    }

    private static Long parseToLong(String price) {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(price.split(",")).toList().forEach(str -> {
            sb.append(str);
        });

        return Long.parseLong(sb.toString());
    }

    public static WinningPrice getWinningPrice(Integer correctCount, Boolean bonus) {
        return Arrays.stream(values())
                .filter(winningPrice -> winningPrice.correctCount == correctCount)
                .filter(winningPrice -> winningPrice.bonus == bonus)
                .findFirst()
                .orElse(WinningPrice.NONE);
    }

    public static Optional<String> getInfo(WinningPrice winningPrice){
        StringBuilder sb = new StringBuilder();
        sb.append(winningPrice.correctCount+"개 일치");

        if(winningPrice.equals(WinningPrice.NONE)){
            return Optional.empty();
        }

        if(winningPrice.bonus){
            sb.append(", 보너스 볼 일치");
        }

        sb.append(" ("+winningPrice.price+"원) - ");
        return Optional.of(sb.toString());
    }
}
