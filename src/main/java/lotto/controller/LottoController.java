package lotto.controller;

import lotto.view.InputView;
import lotto.model.Logics;
import lotto.model.Lotto;
import lotto.model.Errors;
import lotto.view.OutputView;

import java.awt.image.LookupTable;
import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private int money = 0;
    private int bonus = 0;

    private Lotto[] lottos;
    private Lotto answer;
    private int sameThree = 0;
    private int sameFour = 0;
    private int sameFive = 0;
    private int sameBonus = 0;
    private int sameAll = 0;
    private int result = 0;
    public void gamePlay () {
        inputMoney();
        initLottos();
        printLottos();
        inputAnswer();
//        System.out.println(Logics.ListToString(this.answer.getLotto()));
        inputBonus();
    }

    private void inputMoney () {
        boolean isValidate = false;
        while(!isValidate) {
            try {
                String strMoney = InputView.printInputMoney();
                this.money = Errors.isInteger(strMoney);
                Errors.isMinMoney(this.money);
                Errors.isWrongMoney(this.money);
                isValidate = true;
            } catch (IllegalArgumentException e) {
                isValidate = false;
            }
        }
    }

    private void inputBonus () {
        boolean isValidate = false;
        while(!isValidate) {
            try {
                String strBonus = InputView.printInputBonus();
                this.bonus = Errors.isInteger(strBonus);
                Errors.isWrongRange(this.bonus);
                isValidate = true;
            } catch (IllegalArgumentException e) {
                isValidate = false;
            }
        }
    }

    private void inputAnswer () {
        boolean isValidate = false;
        while(!isValidate) {
            try {
                String strAnswer = InputView.printInputBonus();
                String[] tempAnswer = strAnswer.trim().split(",");
                List<Integer> temp = checkInputAnswer(tempAnswer);
                this.answer = new Lotto(temp);
                isValidate = true;
            } catch (IllegalArgumentException e) {
                isValidate = false;
            }
        }
    }

    private List<Integer> checkInputAnswer (String[] inputAnswers) throws IllegalArgumentException{
        List<Integer> tempList = new ArrayList<Integer>();
        for(int i = 0; i < inputAnswers.length; i++) {
            try {
                int temp = Errors.isInteger(inputAnswers[i]);
                Errors.isWrongRange(temp);
                Errors.isDuplicate(tempList, temp);
                tempList.add(temp);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException();
            }
        }
        return tempList;
    }

    private void initLottos () {
        int number = this.money / 1000;
        this.lottos = new Lotto [number];
        for(int i = 0; i < number; i++) {
            lottos[i] = new Lotto(Logics.makeRandomList());
        }
    }

    private void printLottos () {
        for(int i = 0; i < this.lottos.length; i++) {
            StringBuilder temp = Logics.ListToString(this.lottos[i].getLotto());
            OutputView.printLottoNumbers(temp);
        }
    }

    private void


}
