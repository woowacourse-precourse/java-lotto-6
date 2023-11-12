package Controller;

import Util.CheckNull;
import View.LottoView;
import Domain.lotto.Lotto;

import java.util.List;
/*
    발행된 Lotto들을 저장하고 내장된 view를 활용하여 필요시 해당 lotto들의 정보를 보여준다.
 */
public class LotteryController {
    List<Lotto> lotteries;
    LottoView view;

    public LotteryController(LottoView view){
        this.view = view;
    }

    public void setLotteries(List<Lotto> lotteries){
        this.lotteries = lotteries;
    }

    public void printLotteries(){
        CheckNull.check(lotteries, "ModuleController에 발행된 복권이 없습니다.");
        view.printLotteries(lotteries);
    }

    public List<Lotto> getLotteries() {
        return lotteries;
    }
}
