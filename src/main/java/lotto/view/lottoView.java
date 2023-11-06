package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;

import java.util.List;

import static lotto.service.LottoService.inputPrice;

public class LottoView {

    public static Integer getNumberOfLottoForPrice() {
        Integer numberOfLotto;

        System.out.println("구입금액을 입력해 주세요.");
        numberOfLotto = inputPrice(Console.readLine());
        System.out.println();
        return numberOfLotto;
    }

    public static void printLottoList(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.toString());
        }
    }


}
