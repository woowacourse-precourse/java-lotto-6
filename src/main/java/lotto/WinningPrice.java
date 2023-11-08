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

    /**
     * 구분점이 포함된 상금을 Long 형태로 변환
     * @param price 구분점이 포함된 상금
     * @return 구분점을 제외한 Long형 상금
     */
    private static Long parseToLong(String price) {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(price.split(",")).toList().forEach(str -> {
            sb.append(str);
        });

        return Long.parseLong(sb.toString());
    }

    /**
     * 로또 번호와 일치하는 개수 및 보너스 번호를 이용해 상금 측정
     * @param correctCount 로또 당첨 번호와 일치하는 로또 번호 개수
     * @param bonus 보너스 번호 일치 여부
     * @return 해당 로또의 상금
     */
    public static WinningPrice getWinningPrice(Integer correctCount, Boolean bonus) {
        return Arrays.stream(values())
                .filter(winningPrice -> winningPrice.correctCount == correctCount)
                .filter(winningPrice -> winningPrice.bonus == bonus)
                .findFirst()
                .orElse(WinningPrice.NONE);
    }

    /**
     * 당첨 통계를 출력하기 위한 문구 생성
     * @param winningPrice 해당 로또의 상금
     * @return 로또 상금에 해당하는 당첨 결과 문구
     */
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
