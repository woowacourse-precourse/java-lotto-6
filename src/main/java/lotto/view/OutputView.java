package lotto.view;

import lotto.domain.BuyLottoInfo;

import java.util.List;

public class OutputView {

    public void printUserLottoInfo(BuyLottoInfo buyLottoInfo){
        System.out.println(buyLottoInfo.getLottoTicketCount() + "개를 구매했습니다.");
        for (List<Integer> numbers : buyLottoInfo.getUserLottoNumbers()){
            System.out.println(numbers);
        }
    }

}
