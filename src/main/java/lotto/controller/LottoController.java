package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LottoController {

    LottoService lottoService = new LottoServiceImpl();
    private final int LOTTO_PRICE = 1000;
    private int price;

    public void inputBuyPrice() {
        this.price = 0;

        try {
            this.price = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException numberFormatException) {
            System.out.println("[ERROR] 금액은 숫자를 입력해주세요.");
        }

        if(price == 0) throw new IllegalArgumentException("[ERROR] 구입 금액은 0원이 될 수 없습니다.");

        lottoService.buyLotto(price);
    }

    public void outputBoughtLotto() {
        lottoService.boughtLottoList();
    }


    public void inputWinLotto(List<Integer> winLotto, int bonusNum) {
        lottoService.setAnswer(winLotto, bonusNum);
    }

    private List<Integer> inputWinLottoNumber() {
        List<Integer> winLottoList = new ArrayList<>();
        String winLotto = Console.readLine();

        try {
            winLottoList = Stream.of(winLotto.split(","))
                    .mapToInt(Integer::parseInt)
                    .boxed().toList();

        } catch (NumberFormatException numberFormatException) {
            System.out.println("[ERROR] 로또 번호는 숫자를 입력해주세요.");
        }

        return winLottoList;
    }

    private int inputBonusNum() {
        int bonusNum = 0;

        try {
            bonusNum = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException numberFormatException) {
            System.out.println("[ERROR] 보너스 번호는 숫자를 입력해주세요.");
        }

        return bonusNum;
    }

    public void outputWinStats() {
        lottoService.calculateYield(price);
    }
}
