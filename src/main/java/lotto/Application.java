package lotto;

import lotto.Model.Lotto.Lotto;
import lotto.Service.LottoNumberService.LottoNumberService;

public class Application {


    public static void main(String[] args) {
        LottoNumberService number = new LottoNumberService();
        Lotto lotto = number.getUniqueLottoNumber();

        // 생성된 로또 번호 출력
        System.out.println("로또 번호: " + lotto.getNumbers());



    }

}
