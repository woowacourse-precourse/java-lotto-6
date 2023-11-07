package lotto;

import java.util.List;
import lotto.Common.LottoValue;
import lotto.Service.LottoNumberService.LottoNumberService;
import lotto.View.InputView.InputView;

public class Application {


    public static void main(String[] args) {
        LottoNumberService number = new LottoNumberService();
        List<Integer> list = number.getUniqueLottoNumber();


        for(Integer a : list) {
            System.out.print(a + " ");
        }


    }

}
