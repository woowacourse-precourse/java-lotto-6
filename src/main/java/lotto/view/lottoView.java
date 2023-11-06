package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.service.LottoService.inputPrice;

public class LottoView {

    public static Integer getNumberOfLottoForPrice() {
        Integer numberOfLotto;

        System.out.println("구입금액을 입력해 주세요.");
        numberOfLotto = inputPrice(Console.readLine());
        return numberOfLotto;
    }


}
