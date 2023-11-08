package Controller;

import Util.CheckNull;
import View.LottoView;
import Domain.lotto.Lotto;

import java.util.List;

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
