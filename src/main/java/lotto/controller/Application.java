package lotto.controller;

import lotto.domin.Bonus;
import lotto.domin.Lotto;
import lotto.domin.LottoNumbers;
import lotto.domin.PlayerLottoAmount;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.view.OutputView.PrintLottoNumbers;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        PlayerLottoAmount playerLottoAmount = null;
        playerLottoAmount = getPlayerLottoAmount(playerLottoAmount);
        int count = playerLottoAmount.calculateLottoCount();
        OutputView.printTicketCount(count);

        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = null;
            getLottoList(lottoList, lotto);
        }
        List<Integer> selectLottoNumber = getSelectLottoNumbers();
        int bonus = getbonus(selectLottoNumber);


    }

    private static PlayerLottoAmount getPlayerLottoAmount(PlayerLottoAmount playerLottoAmount) {
        while (true) {
            try {
                return playerLottoAmount = new PlayerLottoAmount(InputView.inputPlayPay());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void getLottoList(List<Lotto> lottoList, Lotto lotto) {
        while (true) {
            try {
                lotto = makeLotto();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        lottoList.add(lotto);
    }

    public static Lotto makeLotto() throws IllegalArgumentException {
        List<Integer> numbers = new LottoNumbers().LottoNumbers();
        PrintLottoNumbers(numbers);
        return new Lotto(numbers);
    }

    private static List<Integer> getSelectLottoNumbers() {
        List<Integer> selectLottoNumber = null;
        while (true) {
            try {
                selectLottoNumber = getSelectLottoNumber(InputView.inputLottoNumber());
                new Lotto(selectLottoNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return selectLottoNumber;
    }
    private static List<Integer> getSelectLottoNumber(String InputLotto) {
        return Arrays.stream(InputLotto.split(",")).map(Integer::parseInt).collect(Collectors.toList());
    }

    private static int getbonus(List<Integer> selectLottoNumber) {
        int bonus;
        while (true) {
            try {
                String inputBonusNumber = InputView.getInputBonusNumber();
                return bonus = new Bonus(inputBonusNumber, selectLottoNumber).getBonus();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());

            }
        }
    }

}
