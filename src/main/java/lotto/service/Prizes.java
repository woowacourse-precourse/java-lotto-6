package lotto.service;

import java.util.Arrays;

public class Prizes {

    FIRST(6,2_000_000_000,"6개 일치 (2,000,000,000원) - "),

    SECOND(5,30_000_000,"5개 일치, 보너스 볼 일치 (30,000,000원) - "),

    THIRD(5,1_500_000,"5개 일치 (1,500,000원) - "),

    FOURTH(4,50_000,"4개 일치 (50,000원) - "),

    FIFTH(3,5_000,"3개 일치 (5,000원) - "),

    MISS(0,0,"");

    private int count_match_numbers;
    private int count_prize_numbers;
    private String prize_message;
    Prizes(int count_match_numbers, int count_prize_numbers, String prize_message) {
        this.count_match_numbers = count_match_numbers;
        this.count_prize_numbers = count_prize_numbers;
        this.prize_message = prize_message;
    }


}
