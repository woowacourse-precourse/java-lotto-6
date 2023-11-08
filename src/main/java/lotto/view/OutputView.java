package lotto.view;

import lotto.model.Lotto;
import lotto.model.Prize;
import lotto.model.Ticket;

import java.util.EnumMap;

import static lotto.model.constant.LottoConstant.LOTTO_SIZE;

public class OutputView {

    public static void printLottoCount(int lottoCount) {
        System.out.println("\n" + lottoCount + "개를 구매했습니다.");
    }

    public static void printTicket(Ticket ticket) {
        for(Lotto lotto : ticket.getLottos()) {
            printLotto(lotto);
        }
    }

    public static void printLotto(Lotto lotto) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < LOTTO_SIZE; i++) {
            sb.append(lotto.getNumbers().get(i));
            if(i < LOTTO_SIZE - 1)
                sb.append(", ");
        }
        sb.append("]");
        System.out.println(sb);
    }

    public static void printResult(EnumMap<Prize, Integer> result) {
        System.out.println("\n당첨 통계\n---");
        result.forEach((prize, count) -> {
            if (prize == Prize.SECOND) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%,d원) - %d개%n", prize.getMatchCount(), prize.getPrizeMoney(), count);
                return;
            }
            if (prize == Prize.NONE) {
                return;
            }
            System.out.printf("%d개 일치 (%,d원) - %d개%n", prize.getMatchCount(), prize.getPrizeMoney(), count);
        });
    }

}
