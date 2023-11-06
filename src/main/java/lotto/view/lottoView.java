package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.service.lottoService.inputPrice;

public class lottoView {

    public static Integer getNumberOfLottoForPrice() {
        Integer numberOfLotto;

        System.out.println("구입금액을 입력해 주세요.");
        numberOfLotto = inputPrice(Console.readLine());
        return numberOfLotto;
    }


}
