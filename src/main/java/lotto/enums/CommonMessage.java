package lotto.enums;

import lotto.Lotto;

import java.util.Comparator;
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

        sb.append(lottos.size()).append("개를 구매했습니다.");
        for(Lotto lotto : lottos) {
            sb.append("[");

            List<Integer> lottoNumbers = lotto.getNumbers();
            for (Integer number : lottoNumbers) {
                sb.append(number).append(", ");
            }
            sb.append("]\n");
        }

        return sb.toString();
    }

    public static String generateLottoResultMsg(Map<LottoRank, Integer> lottoRanks) {
        StringBuilder sb = new StringBuilder();

        sb.append("당첨 통계").append("\n").append("---");

        for(LottoRank lottoRank : lottoRanks.keySet()) {
            sb.append(lottoRank.prizeMsg).append(" - ")
                    .append(lottoRanks.get(lottoRank))
                    .append("개\n");
        }

        return sb.toString();
    }
}
