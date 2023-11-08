package lotto.view;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import lotto.domain.Rank;

public enum RankOutputTemplate {
    SIX("%d개 일치 (%,d원) - %d개", Rank.SIX),
    FIVE_BONUS("%d개 일치, 보너스 볼 일치 (%,d원) - %d개", Rank.FIVE_BONUS),
    FIVE("%d개 일치 (%,d원) - %d개", Rank.FIVE),
    FOUR("%d개 일치 (%,d원) - %d개", Rank.FOUR),
    THREE("%d개 일치 (%,d원) - %d개", Rank.THREE);

    private final String template;
    private final Rank rank;

    RankOutputTemplate(String template, Rank rank) {
        this.template = template;
        this.rank = rank;
    }

    public String format(Integer count) {
        return String.format(template, rank.getCount(), rank.toPriceInt(), count);
    }

    public boolean equals(Rank rank){
        return this.rank.equals(rank);
    }

    public static Optional<RankOutputTemplate> find(Rank rank) {
        return Arrays.stream(values()).filter(rankOutputTemplate -> rankOutputTemplate.equals(rank)).findFirst();
    }

    public static List<RankOutputTemplate> toList() {
        return Arrays.stream(values()).sorted(Comparator.reverseOrder()).toList();
    }

}
