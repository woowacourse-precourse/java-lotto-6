package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.MatchResult;

import java.util.List;
import java.util.Map;

import static lotto.service.InputService.*;
import static lotto.service.OutputService.*;
import static lotto.service.ComputeService.*;

public class LottoService {
    public static void run() {
        // 로또 구입
        int lottoTicketNum = generateLottoTicket();

        // 로또 발행
        List<Lotto> randomLottos = generateRandomLottos(lottoTicketNum);

        // 당첨 번호 입력
        Lotto winningLotto = generateWinningLotto();

        // 보너스 번호 입력
        int bonusNum = generateBonusNum(winningLotto);

        // 당첨 통계
        generateResult(randomLottos, winningLotto, bonusNum);
    }

    private static int generateLottoTicket() {
        printExpenseInputForm();

        return computeLottoTicketNum();
    }

    private static List<Lotto> generateRandomLottos(int lottoTicketNum) {
        List<Lotto> randomLottos = Lotto.createRandomLottos(lottoTicketNum);

        printPurchaseResult(lottoTicketNum, randomLottos);

        return randomLottos;
    }

    private static Lotto generateWinningLotto() {
        printWinningNumInputForm();

        return Lotto.create(readWinningNumbers());
    }

    private static int generateBonusNum(Lotto winningLotto) {
        printBonusNumInputForm();

        return readBonusNumber(winningLotto);
    }


    private static void generateResult(List<Lotto> randomLottos, Lotto winningLotto, int bonusNum) {
        Map<MatchResult, Integer> result = computeResult(randomLottos, winningLotto, bonusNum);
        double margin = computeMargin(result, randomLottos.size());

        printResult(result, margin);
    }
}
