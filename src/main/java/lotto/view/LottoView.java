package lotto.view;

import static lotto.domain.LottoPrize.SECOND;
import static lotto.view.LottoViewMessage.ASK_BONUS_NUM;
import static lotto.view.LottoViewMessage.ASK_BUY_LOTTO;
import static lotto.view.LottoViewMessage.ASK_WINNING_NUM;
import static lotto.view.LottoViewMessage.RESULT_CONTOUR;
import static lotto.view.LottoViewMessage.RESULT_PREFIX_MSG;

import camp.nextstep.edu.missionutils.Console;
import java.text.NumberFormat;
import java.util.EnumMap;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoPrize;
import lotto.dto.LottoRepositoryDto;
import lotto.dto.LottoResultDto;
import lotto.dto.Money;

public class LottoView {
    public Money requestBuyLotto(){
        printMessage(ASK_BUY_LOTTO);
        return new Money(Console.readLine());
    }
    public void printLottoRepository(LottoRepositoryDto lottoRepositoryDto){
        println();
        System.out.println(lottoRepositoryDto.getLottos().size()+"개를 구매했습니다.");
        for (Lotto lotto:lottoRepositoryDto.getLottos()){
            System.out.println(lotto.getNumbers());
        }
        println();
    }

    public void printResultMsg(LottoResultDto lottoResultDto){
        println();
        printMessage(RESULT_PREFIX_MSG);
        printMessage(RESULT_CONTOUR);
        NumberFormat numberFormatter = NumberFormat.getInstance();
        EnumMap<LottoPrize, Integer> prizeCount = lottoResultDto.getPrizeCount();
        for (LottoPrize prize : LottoPrize.lowestPrizeOrder()) {
            int count = prizeCount.get(prize);
            String formattedAmount = numberFormatter.format(prize.getPrizeAmount());
            String bonus = " ";
            if (prize == SECOND){
                bonus = ", 보너스 볼 일치 ";
            }
            System.out.println(prize.getMatchingNumber() + "개 일치" +bonus+
                    "(" + formattedAmount + "원) - " + count + "개");
        }
        System.out.println("총 수익률은 " + lottoResultDto.getProfitRatio()+ "%입니다.");
    }
    
    public String requestWinningLotto(){
        printMessage(ASK_WINNING_NUM);
        return Console.readLine();
    }
    public String requestBonusNum(){
        printMessage(ASK_BONUS_NUM);
        return Console.readLine();
    }

    public void printMessage(LottoViewMessage lottoViewMessage) {
        System.out.println(lottoViewMessage.getViewMessage());
    }

    public void println(){
        System.out.println();
    }
}
