package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.service.LottoService;
import lotto.util.ListUtil;

import java.util.Arrays;
import java.util.List;

import static lotto.util.ErrorProperties.*;
import static lotto.util.LottoProperties.*;

public class LottoController {
    public final LottoService lottoService;
    private List<Integer> winningNumbers;
    private Integer bonusNumber;

    public LottoController() {
        this.lottoService = new LottoService();
    }

    public void run() {
        System.out.println(getInputPurchaseMoney()); // 구매 금액 입력
        int purchaseMoney = 0; // 로또 구매 금액
        try {
            purchaseMoney = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            System.out.println(getErrorMessageNotInt());
            return;
        }
        System.out.println();

        try {
            lottoService.initLottoNumbers(purchaseMoney); // 로또 발행
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        lottoService.printLottoInfo(); // 발행된 로또 번호 출력
        System.out.println();

        try {
            inputWinningNumbers(); // 당첨 번호, 보너스 번호 입력
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        lottoService.extractWinning(winningNumbers, bonusNumber); // 로또 당첨 결과 출력
    }

    private void inputWinningNumbers() {
        System.out.println(getInputWinningNumber());
        String winningNumberStr = Console.readLine(); // 로또 당첨 번호

        winningNumbers = Arrays.stream(winningNumberStr.split(","))
                .mapToInt(Integer::valueOf)
                .boxed()
                .toList();

        ListUtil.validateDuplication(winningNumbers); // 로또 당첨 번호에 중복된 숫자 포함 확인

        System.out.println();
        System.out.println(getInputBonusNumber());
        bonusNumber = Integer.valueOf(Console.readLine()); // 보너스 번호
        System.out.println();
    }
}
