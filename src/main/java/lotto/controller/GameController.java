package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Game;
import lotto.model.Lotto;
import lotto.view.GameView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameController {
    Game game = new Game();
    Lotto lotto;

    public void startGame() {
        requestAmountInput();
        requestPurchaseCountOutput();
        requestLottoNumbers();
        requestWinningNumberInput();
        requestBonusNumberInput();
        requestMatchResultOutput();
        requestRevenueOutPut();
    }

    public void requestAmountInput() {
        GameView.printAmountInputPhrase();
        inputAmount();
    }

    public void inputAmount() {
        int amount = 0;

        while (true) {
            try {
                amount = stringToInteger(Console.readLine());
                checkAmountValid(amount);
                game.setAmount(amount);
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int stringToInteger(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new NumberFormatException("[ERROR] 유효하지 않은 입력입니다. 다시 입력해주세요.");
            }
        }
        return Integer.parseInt(input);
    }

    public void checkAmountValid(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 게임 금액은 1000의 배수여야 합니다.");
        }
    }

    public void requestPurchaseCountOutput() {
        GameView.printPurchaseCountOutputPhrase(game.getAmount() / game.getOneForPrice());
    }

    public void requestLottoNumbers() {
        game.generateLottoNumbers(game.getAmount() / game.getOneForPrice());
        for (List<Integer> numbers : game.getUserLottoNumbers()) {
            List<Integer> sortedUserLottoNumber = new ArrayList<>(numbers);
            Collections.sort(sortedUserLottoNumber);
            GameView.printLottoNumbers(sortedUserLottoNumber);
        }
    }

    public void requestBonusNumberInput() {
        GameView.printBonusNumberInputPhrase();
        inputBonusNumber();
    }

    public void requestRevenueOutPut() {
        GameView.printRevenue(game.getPrice(), game.getAmount());
    }

    public void requestMatchResultOutput() {
        List<Integer> matchList = game.getMatchResult(lotto.getNumbers());
        GameView.printMatchNumbers(matchList);
    }

    public void inputBonusNumber() {
        while (true) {
            try {
                int number = stringToInteger(Console.readLine());
                game.setBonusNumber(number);
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void requestWinningNumberInput() {
        while (true) {
            try {
                GameView.printWinningNumberInputPhrase();
                lotto = new Lotto(StringToInteger(splitInput(Console.readLine(), ",")));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> StringToInteger(String[] input) {
        List<Integer> intList = new ArrayList<>();
        for (String str : input) {
            try {
                int number = Integer.parseInt(str);
                intList.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력입니다. 다시 입력해주세요.");
            }
        }
        return intList;
    }

    public String[] splitInput(String input, String delimiter) {
        return input.split(delimiter);
    }
}