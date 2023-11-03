package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.WinningNumber;
import lotto.dto.*;

import java.util.HashSet;
import java.util.List;

public class LottoService {

    private final static Prize[] prizes = Prize.values();

    public LottosDto generateLottos(LottoNumberDto dto) {
        Lotto[] lottos = new Lotto[dto.numberOfLottos()];
        for (int i = 0; i < dto.numberOfLottos(); i++) {
            lottos[i] = new Lotto(generateNumbers());
        }
        return new LottosDto(lottos);
    }

    public WinningNumberDto postNormalNumbers(NumbersDto dto) {
        Lotto firstLotto = new Lotto(dto.numbers());
        WinningNumber winningNumber = new WinningNumber(firstLotto);
        return new WinningNumberDto(winningNumber);
    }

    public WinningNumberDto postBonusNumber(WinningNumberDto winningNumberDto, int bonusNum) {
        WinningNumber winningNumber = winningNumberDto.winningNumber();
        HashSet<Integer> set = new HashSet<>(winningNumber.getNormalNumbers());
        if (bonusNum < 1 || bonusNum > 45) {
            throw new IllegalArgumentException("보너스 번호는 1에서 45사이의 숫자여야 합니다");
        }
        if (!set.add(bonusNum)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
        winningNumber.addBonusNumber(bonusNum);
        return new WinningNumberDto(winningNumber);
    }

    private List<Integer> generateNumbers() {
        List<Integer> list = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return list;
    }

    public RanksDto judgeRanks(WinningNumberDto winningNumberDto, LottosDto lottosDto) {
        List<Integer> normalNumbers = winningNumberDto.winningNumber().getNormalNumbers();
        int bonusNumber = winningNumberDto.winningNumber().getBonusNumber();
        int[] ranks = new int[5];

        for (Lotto lotto : lottosDto.lottos()) {
            int rank = rankOfLotto(lotto.toArr(), normalNumbers, bonusNumber);
            if (rank < 5) {
                ranks[rank]++;
            }
        }
        return new RanksDto(ranks);
    }

    public RateOfReturnDto calRateOfReturn(LottoNumberDto lottoNumberDto, RanksDto ranksDto) {
        int[] ranks = ranksDto.ranks();
        float inputMoney = lottoNumberDto.numberOfLottos() * 1000f;
        int finalMoney = 0;
        for (int i = 0; i < ranks.length; i++) {
            finalMoney += ranks[i] * prizes[i].getMoney();
        }
        float rate = 100 * finalMoney / inputMoney;
        return new RateOfReturnDto(rate);
    }

    private int rankOfLotto(int[] checkNum, List<Integer> normalNum, int bonusNum) {
        boolean isBonus = false;
        int normalMatchNum = 0;

        for (int i : checkNum) {
            if (normalNum.contains(i)) {
                normalMatchNum++;
            }
            if (i == bonusNum) {
                isBonus = true;
            }
        }
        return calRank(normalMatchNum, isBonus);
    }

    private int calRank(int normalMatchNum, boolean isBonus) {
        if (normalMatchNum == 6) {
            return 0;
        }
        if ((normalMatchNum == 5) && isBonus) {
            return 1;
        }
        return 7 - normalMatchNum;
    }
}
