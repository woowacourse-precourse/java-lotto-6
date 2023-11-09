package lotto.system.shop.domain.manager.lotto;

import static lotto.system.shop.domain.GuideMessage.INPUT_BONUS_NUMBER;
import static lotto.system.shop.domain.GuideMessage.INPUT_WINNING_NUMBERS;

import java.util.List;
import lotto.system.shop.domain.LottoRank;
import lotto.system.shop.domain.Machine;
import lotto.system.shop.domain.Reader;
import lotto.system.shop.domain.Viewer;
import lotto.system.shop.domain.ticket.lotto.LottoTicket;
import lotto.system.shop.exception.reader.InvalidNumberTypeException;

public class LottoMachineManager {

    private static final String CRLF = "";

    public static LottoMachineManager bring() {
        return new LottoMachineManager();
    }

    public void initialize(Machine<LottoTicket, LottoRank> machine, Reader reader, Viewer viewer) {
        List<Integer> winningNumbers = getWinningNumbersProcess(reader, viewer);
        Integer bonusNumber = getBonusNumberProcess(reader, viewer);
        initializeMachine(machine, winningNumbers, bonusNumber);
    }

    private List<Integer> getWinningNumbersProcess(Reader reader, Viewer viewer) {
        viewer.print(INPUT_WINNING_NUMBERS);
        List<Integer> winningNumbers = getWinningNumbers(reader, viewer);
        viewer.print(CRLF);
        return winningNumbers;
    }

    private List<Integer> getWinningNumbers(Reader reader, Viewer viewer) {
        List<Integer> winningNumbers = null;
        try {
            winningNumbers = reader.readNumbers();
        } catch (InvalidNumberTypeException exception) {
            viewer.print(exception.getMessage());
            getWinningNumbers(reader, viewer);
        }
        return winningNumbers;
    }

    private Integer getBonusNumberProcess(Reader reader, Viewer viewer) {
        viewer.print(INPUT_BONUS_NUMBER);
        Integer bonusNumber = getBonusNumber(reader, viewer);
        viewer.print(CRLF);
        return bonusNumber;
    }

    private Integer getBonusNumber(Reader reader, Viewer viewer) {
        Integer bonusNumber = null;
        try {
            bonusNumber = reader.readNumber();
        } catch (InvalidNumberTypeException exception) {
            viewer.print(exception.getMessage());
            getBonusNumber(reader, viewer);
        }
        return bonusNumber;
    }

    private void initializeMachine(Machine<LottoTicket, LottoRank> machine,
        List<Integer> winningNumbers, Integer bonusNumber) {
        machine.set(winningNumbers);
        machine.set(bonusNumber);
        machine.initialize();
    }
}
