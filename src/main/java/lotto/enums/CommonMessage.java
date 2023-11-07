package lotto.enums;

import lotto.game.Lotto;

import java.util.List;
import java.util.Map;

public enum CommonMessage {
    READ_PURCHASE_MSG("구매금액을 입력해 주세요."),
    READ_LOTTO_NUMBER_MSG("당첨번호를 입력해 주세요"),
    READ_BONUS_NUMBER_MSG("보너스 번호를 입력해 주세요.");


    private final String message;

    CommonMessage(String message) {
        this.message = message;
    }

    public String message() {
        return this.message;
    }

    public static String generateLottoListMsg(List<Lotto> lottos) {
        StringBuilder sb = new StringBuilder();

        sb.append(lottos.size()).append("개를 구매했습니다.").append("\n");
        for(Lotto lotto : lottos) {
            sb.append("[");

            List<Integer> lottoNumbers = lotto.getNumbers();
            int lastIdx = lottoNumbers.size() - 1;

            for (int idx = 0; idx < lastIdx; idx++) {
                sb.append(lottoNumbers.get(idx)).append(", ");
            }
            sb.append(lottoNumbers.get(lastIdx)).append("]").append("\n");
        }

        return sb.toString();
    }

    public static String generateLottoResultMsg(Map<LottoRank, Integer> lottoRanks) {
        StringBuilder sb = new StringBuilder();

        sb.append("당첨 통계").append("\n").append("---").append("\n");

        for(LottoRank lottoRank : lottoRanks.keySet()) {
            sb.append(lottoRank.prizeMsg).append(" - ")
                    .append(lottoRanks.get(lottoRank))
                    .append("개\n");
        }

        return sb.toString();
    }

    public static String generateBenefitRateMsg(double benefitRate) {
        StringBuilder sb = new StringBuilder();

        sb.append("총 수익률은 ").append(benefitRate).append("%입니다.");
        return sb.toString();
    }
}
