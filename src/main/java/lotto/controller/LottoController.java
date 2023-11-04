package lotto.controller;

import lotto.view.InputView;
import lotto.model.Logics;
import lotto.model.Lotto;
import lotto.model.Errors;
import lotto.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private int money = 0;
    private int bonus = 0;

    private Lotto[] lottos;
    private Lotto answer;

    private int[] results = new int[5];

    private int[] standard = {
            5000,
            50000,
            1500000,
            30000000,
            2000000000,
    };

    private int sum;
    private double percentage;
    public void gamePlay () {
        //발행할 돈 입력
        inputMoney();

        //입력된 돈을 통해 로또 생성
        initLottos();

        //생성된 로또 [,]형태로 출력
        printLottos();

        //로또의 정답 입력
        inputAnswer();

        //보너스 값 입력
        inputBonus();

        //입력된 정답 로또와 랜덤으로 생성된 로또를 비교해서 각 결과 저장
        checkEachLottos();

        //각 결과의 값을 저장해서 퍼센트로 변환
        sumOfNumbers();

        //결과 프린트
        OutputView lottoResult = new OutputView();
        lottoResult.printLottoResult(results, percentage);
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
                Errors.isDuplicate(answer.getLotto(), bonus);
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
                String strAnswer = InputView.printInputAnswer();
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
        OutputView.printBuyNumbers(this.money/1000);
        for(int i = 0; i < this.lottos.length; i++) {
            StringBuilder temp = Logics.ListToString(this.lottos[i].getLotto());
            OutputView.printLottoNumbers(temp);
        }
    }

    private void checkEachLottos () {
        for(int i = 0; i < this.lottos.length; i++) {
            int count = this.lottos[i].countMatch(this.answer, this.bonus);
            comparing(count);
        }
    }

    private void comparing (int count) {
//        if(count == 3) {
//            this.results[0]++;
//        } else if (count == 4) {
//            this.results[1]++;
//        } else if (count == 5) {
//            this.results[2]++;
//        } else if (count == 6) {
//            this.results[4]++;
//        } else if (count == -1) {
//            this.results[3]++;
//        }
        switch(count) {
            case 3 : this.results[0]++;
            case 4 : this.results[1]++;
            case 5 : this.results[2]++;
            case -1 : this.results[3]++;
            case 6 : this.results[4]++;
            default : break;
        }
    }

    private void sumOfNumbers () {
        for(int i = 0; i < this.standard.length; i++) {
            this.sum+=standard[i]*results[i];
        }
        this.percentage = Logics.benefit(this.money, this.sum);
    }
}
