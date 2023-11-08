package lotto.view;

import lotto.domain.LottoCondition;
import lotto.global.Prize;

public class Announce {
    public static final String NEW_LINE = "\n";
    public static final String GET_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String GET_WIN_NUMBER = "당첨 번호를 입력해 주세요.";
    public static final String Get_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    public static final String WIN_STATISTIC = "당첨 통계\n---";

    public static String purchaseCount(Integer amount) {
        return amount / LottoCondition.MONEY_UNIT + "개를 구매했습니다.";
    }

    public static String yieldRate(Double percentage) {
        return "총 수익률은 " + percentage + "%입니다.";
    }

    public static String result(Prize prize, Integer count) {
        if (prize == Prize.FIRST) {
            return "6개 일치 (2,000,000,000원) - " + count + "개";
        }
        if (prize == Prize.SECOND) {
            return "5개 일치, 보너스 볼 일치 (30,000,000원) - " + count + "개";
        }
        if (prize == Prize.THIRD) {
            return "5개 일치 (1,500,000원) - " + count + "개";
        }
        if (prize == Prize.FORTH) {
            return "4개 일치 (50,000원) - " + count + "개";
        }
        if (prize == Prize.FIFTH) {
            return "3개 일치 (5,000원) - " + count + "개";
        }
        return "";
    }
}
