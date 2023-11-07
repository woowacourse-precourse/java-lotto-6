package lotto.view;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.controller.dto.ResultDto;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.Rank;

public class OutputView {

    public static void renderingPurchaseHistory(List<Lotto> list) {
        print(String.format("%d개를 구매했습니다.", list.size()));
        for (Lotto lotto : list) {
            List<LottoNumber> lottoNumbers = lotto.toIntegerList();
            print(lottoNumbers.stream().map(LottoNumber::getNumber).sorted().toList().toString());
        }
    }

    public static void renderingResult(ResultDto resultDto) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        print("당첨 통계");
        print("---");
        for(Rank rank: Arrays.stream(Rank.values()).sorted(Collections.reverseOrder()).toList()){
            String patten = generatePatten(rank);
            print(String.format(patten,rank.getCount(),decimalFormat.format(rank.getMoney().getMoney()),resultDto.findCount(rank)));
        }
        print(String.format("총 수익률은 %.1f%%입니다.",resultDto.getProfitRate()));
    }

    public static void renderingError(String message) {
        print("[ERROR] "+message);
    }

    private static String generatePatten(Rank rank) {
        StringBuilder patten=new StringBuilder("%d개 일치");
        if(rank.equals(Rank.FIVE_BONUS)){
            patten.append(", 보너스 볼 일치");
        }
        patten.append(" (%s원) - %d개");
        return patten.toString();
    }

    private static void print(String message) {
        System.out.println(message);
    }
}
