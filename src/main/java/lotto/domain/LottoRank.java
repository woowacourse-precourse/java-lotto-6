package lotto.domain;

import java.text.NumberFormat;
import java.util.Locale;

public class LottoRank {
    private LottoRankType lottoRankType;

    public static String getRank(LottoRankType lottoRankType) {
        return lottoRankType.getRank();
    }

    public static Integer getRankPrice(LottoRankType lottoRankType) {
        return lottoRankType.getRankPrice();
    }

    public static String getRankPriceFormat(LottoRankType lottoRankType) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.KOREA);
        return numberFormat.format(lottoRankType.getRankPrice());
    }

    public static String getRankPriceAddUnit(String price) {
        return price + "원";
    }
}
