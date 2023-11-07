package lotto.service;

import lotto.repository.LottoRepository;
import lotto.view.Input;
import lotto.view.Output;

import java.util.List;

public class Game {

    private final Input input = Input.getInstance();
    private final Output output = Output.getInstance();

    private LottoRepository repository;

    public Game() {
        this.repository = new LottoRepository();
    }

    public void run() {
        init();
        draw();
    }

    private void init() {
        // 구입금액 입력
        output.printPurchaseAmountMessage();
        int count = repository.buyTicket(input.inputPurchaseAmount());
        output.printLineBreak();

        // 구매 결과 출력
        output.printBuyingMessage(count);
        output.printLottoTickets(repository.getMyTickets());
        output.printLineBreak();
    }

    private void draw() {
        // 당첨 번호 입력
        output.printWinningNumbersMessage();
        List<Integer> numbers = input.inputNumbers();
        output.printLineBreak();

        // 보너스 번호 입력
        output.printBonusNumberMessage();
        int number = input.inputBonusNumber();
        output.printLineBreak();

        repository.drawLotto(numbers, number);
    }




}
