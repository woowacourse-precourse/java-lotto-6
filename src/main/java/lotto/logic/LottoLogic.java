package lotto.logic;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.controller.LottoController;
import lotto.model.Lotto;
import lotto.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoLogic implements Logic {
    private final View view;
    private final LottoController controller;
    private boolean running = true;
    private List<Integer> winningNumber;
    private int bonusNumber;

    public LottoLogic(View view, LottoController lottoController) {
        this.view = view;
        this.controller = lottoController;
    }

    @Override
    public void start() {
        while (running) {
            run();
        }
    }

    @Override
    public void run() {
        int payment = getPurchaseAmount();
        controller.generateLotto(payment);
        view.printAllLottery(controller.getLotteries());
        getWinningNumber();
        getBonusNumber();
    }

    private void getBonusNumber() {
        try {
            bonusNumber = validNumber(view.getBonusNumber());
        } catch (IllegalArgumentException e) {
            view.printError(e.getMessage());
            getBonusNumber();
        }
    }

    private void getWinningNumber() {
        String input = view.getWinningNumbers();
        try {
            winningNumber = Arrays.stream(input.split(","))
                    .map((o) -> validNumber(o))
                    .toList();
        } catch (IllegalArgumentException e) {
            view.printError(e.getMessage());
            getWinningNumber();
        }
    }

    private int validNumber(String inputNumber) {
        int number = 0;
        try {
            number = Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또 번호는 1 ~ 45 사이의 숫자여야 합니다.");
        }
        if (number <= 0 || number > 45) {
            throw new IllegalArgumentException("로또 번호는 1 ~ 45 사이의 숫자여야 합니다.");
        }
        return number;
    }

    private int validPayment(String input) {
        int payment;
        try {
            payment = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("지불 금액은 정수여야 합니다.");
        }
        if (payment <= 0) {
            throw new IllegalArgumentException("지불 금액은 0 보다 커야 합니다.");
        } else if (payment % 1000 != 0) {
            throw new IllegalArgumentException("지불 금액은 1000원 단위여야 합니다.");
        }
        return payment;
    }

    private int getPurchaseAmount() {
        try {
            String input = view.getPurchaseAmount();
            return validPayment(input);
        } catch (IllegalArgumentException e) {
            view.printError(e.getMessage());
            return getPurchaseAmount();
        }
    }

}
