package lotto.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoPurchaseInfo;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Game {
    public Game() {

    }

    public void play() {

        int purchaseAmount = InputView.inputPurchaseAmount();
        int purchaseLottoNum = purchaseAmount / 1000;

        LottoPurchaseInfo lottoPurchaseInfo = new LottoPurchaseInfo(purchaseAmount, purchaseLottoNum);
        OutputView.outputPurchaseCount(lottoPurchaseInfo.getPurchaseLottoNum());
        OutputView.outputPurchaseLottos(lottoPurchaseInfo.getLottos());
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] winningNum = readLine().split(",");

        if (winningNum.length != 6) {
            throw new IllegalArgumentException("당첨 번호는 6개여야 합니다.");
        }

        List<Integer> nums = new ArrayList<>();
        try {
            for (String num : winningNum) {
                int number = Integer.parseInt(num);
                if (number < 1 || number > 45) {
                    throw new IllegalArgumentException("각 번호는 1~45사이 값이여야 합니다.");
                }
                if (nums.contains(number)) {
                    throw new IllegalArgumentException("중복된 번호가 존재합니다.");
                }
                nums.add(number);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값은 정수여야합니다.");
        }

        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            int bonusNum = Integer.parseInt(readLine());
            if (bonusNum < 1 || bonusNum > 45) {
                throw new IllegalArgumentException("번호는 1~45사이 값이여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값은 정수여야합니다.");
        }
    }
}
