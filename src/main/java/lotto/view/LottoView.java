package lotto.view;

import static lotto.view.LottoViewMessage.ASK_BONUS_NUM;
import static lotto.view.LottoViewMessage.ASK_BUY_LOTTO;
import static lotto.view.LottoViewMessage.ASK_WINNING_NUM;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Lotto;
import lotto.dto.LottoRepositoryDto;
import lotto.dto.Money;

public class LottoView {
    public Money requestBuyLotto(){
        printMessage(ASK_BUY_LOTTO);
        return new Money(Console.readLine());
    }
    public void printLottoRepository(LottoRepositoryDto lottoRepositoryDto){
        System.out.println(lottoRepositoryDto.getLottos().size()+"개를 구매했습니다.");
        for (Lotto lotto:lottoRepositoryDto.getLottos()){
            System.out.println(lotto.getNumbers());
        }
        println();
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
