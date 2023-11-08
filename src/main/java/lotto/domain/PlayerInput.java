package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import lotto.Application;

public class PlayerInput {
    public static void numberCheck(String inputNumber) {
        List<Integer> playerNumber = new ArrayList<Integer>();
        String[] splitInputNumber = inputNumber.split(",");

        try {
            for (int i = 0; i < splitInputNumber.length; i++) {
                int eachNumber = Integer.parseInt(splitInputNumber[i]);
                playerNumber.add(eachNumber);
            }
            Lotto numberCheck = new Lotto(playerNumber);
            Application.playerNumber = playerNumber;
        } catch (IllegalArgumentException e) {
            LottoStart.inputNumber();
        }
    }

    public static void bonusNumberCheck(int bonusNumber) {
        try {
            if (bonusNumber < 1 || bonusNumber > 45) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 1부터 45 사이의 숫자 하나만 입력해 주세요.");
            LottoStart.inputBonusNumber();
        }
    }
}