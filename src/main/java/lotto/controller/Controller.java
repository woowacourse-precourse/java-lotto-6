package lotto.controller;

import lotto.model.*;
import lotto.view.Input;
import lotto.view.Output;

import java.util.ArrayList;
import java.util.List;


public class Controller {

    private final Input input;
    private final Output output;

    public Controller(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void lottoGame() {
        int insertedMoney = input.insertMoney();

        NumberOfLottoTickets numberOfLottoTickets = new NumberOfLottoTickets(insertedMoney);
        int countLottoTickets = numberOfLottoTickets.getCountLottoTickets();

        // 발행된 전체 로또
        List<List<Integer>> tickets = new ArrayList<>();

        for (int index = 0; index < countLottoTickets; index++) {
            List<Integer> lottoNumbers = new LottoTicket().getLottoNumbers();
            new LottoTickets(tickets,lottoNumbers);
        }
        output.printLottoTickets(tickets);

        // 당첨 번호 입력받기
        WinningNumbers winningNumbers = new WinningNumbers(input.inputWinningNumbers());

        // 보너스 당첨 번호
        BonusWinningNumber bonusNumber = new BonusWinningNumber(input.inputBonusNumber());


    }

}
