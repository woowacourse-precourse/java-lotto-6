package lotto.domain;

import java.util.Arrays;

public enum Rank {
    ONE(6, "6개 일치", 2000000000),
    TWO(5, "5개 일치, 보너스 볼 일치", 30000000),
    THREE(5, "5개 일치", 1500000),
    FOUR(4, "4개 일치", 50000),
    FIVE(3, "3개 일치", 5000),
    NONE(-1, "당첨 X", 0);

    private int shot;
    private String reply;
    private int money;

    Rank(int shot, String reply, int money) {
        this.shot = shot;
        this.reply = reply;
        this.money = money;
    }

    public static Rank getRank(int shot, boolean bonusShot) {
        if (shot == 5 && bonusShot) {
            return Rank.TWO;
        }

        return Arrays.stream(Rank.values()).filter(Rank -> Rank.shot == shot)
                .findAny().orElse(Rank.NONE);
    }
}
