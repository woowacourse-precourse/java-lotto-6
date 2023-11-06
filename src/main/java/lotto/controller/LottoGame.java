package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.WinningNumbers;
import lotto.model.InputMoney;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private final int THOUSAND = 1000;
    private final OutputView outputView = new OutputView();
    private final InputMoney inputMoney = new InputMoney();
    private final BonusNumber bonusNumber = new BonusNumber();
    private final List<Lotto> totalLotto = new ArrayList<>();

    public void run() {
        countLotto(inputMoney()/THOUSAND);
        WinningNumbers winningNumbers = makeWinningNumbers();
        addBonusNumber(winningNumbers);

    }

    private void addBonusNumber(WinningNumbers winningNumbers) {
        bonusNumber.add(winningNumbers);
    }


    private WinningNumbers makeWinningNumbers() {
        outputView.winningNumbers();
        return WinningNumbers.from();
    }


    private void countLotto(int lottoPaper) {
        outputView.count(lottoPaper);

        for(int i=0; i<lottoPaper; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45,6);
            Lotto lotto = new Lotto(numbers);
            totalLotto.add(lotto);
        }

        outputView.printTotalLotto(totalLotto);
    }

    private int inputMoney(){
        outputView.inputMoney();

        while(true){
            try {
                int number = inputMoney.Number();
                if(number != 0){
                    return number;
                }
            }   catch (IllegalArgumentException e){
                System.out.println("[ERROR] 숫자를 입력해주세요.");
            }
        }
    }
}

