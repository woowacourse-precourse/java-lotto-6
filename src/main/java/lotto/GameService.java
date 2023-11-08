package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class GameService {
    enum STATUS {
        ERROR1(-1), ERROR2(null),
        BONUSINCORRECT(0), BONUSCORRECT(1);

        private final Object value;

        STATUS(Integer value) {
            this.value = value;
        }

        public Object getValue() {
            return value;
        }
    }

    enum Rank {
        RANK1(2000000000),
        RANK2(30000000),
        RANK3(1500000),
        RANK4(50000),
        RANK5(5000);

        private final int value;

        Rank(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    GameRepository gameRepository = new GameRepository();

    public int validCash(String rawInput) throws IllegalArgumentException {
        try {
            int rawCash = Integer.parseInt(rawInput);
            if (rawCash % 1000 == 0 && rawCash > 0) {
                gameRepository.saveCash(rawCash);
                return rawCash / 1000;
            }
            throw new IllegalArgumentException("[ERROR] 1000원 단위, 1000원 이상의 로또 구입 금액을 입력해주세요.");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 정확한 숫자여야 합니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return (int) STATUS.ERROR1.getValue();
        }
    }

    public String generateNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        List<Integer> convert = new ArrayList<>(numbers);
        Collections.sort(convert);
        gameRepository.saveNumber(convert);
        return numbers.toString();
    }

    // 번호 포맷팅에 대한 검증만 실행, 로또 번호 검증(중복 수, 수의 범위, 번호 개수 등) 로직 : Lotto 실행
    public List<Integer> validWinNumber(String rawInput) throws IllegalArgumentException {
        try {
            List<Integer> rawWinNumber = Arrays.stream(rawInput.split(","))
                    .map(String::trim).map(Integer::parseInt)
                    .sorted().toList();
            gameRepository.saveWinLottoNumber(rawWinNumber);
            return rawWinNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 당첨 번호를 정확하게 입력해주세요. (쉼표 기준, 여섯 개)");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return (List<Integer>) STATUS.ERROR2.getValue();
        }
    }

    public int validBonusNumber(String rawInput, List<Integer> winNumber) throws IllegalArgumentException {
        try {
            int rawBonusNumber = Integer.parseInt(rawInput);
            if ((rawBonusNumber >= 1 && rawBonusNumber <= 45) && !winNumber.contains(rawBonusNumber)) {
                gameRepository.saveBonusNumber(rawBonusNumber);
                return rawBonusNumber;
            }
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 당첨 번호와 중복되지 않은 숫자여야 합니다.");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정확한 숫자로 보너스 번호를 입력해주세요.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return (int) STATUS.ERROR1.getValue();
        }
    }

    public String calcEarnRate(int rank5count, int rank4count, int rank3count, int rank2count, int rank1count) {
        int totalEarn = rank5count * Rank.RANK5.getValue()
                + rank4count * Rank.RANK4.getValue()
                + rank3count * Rank.RANK3.getValue()
                + rank2count * Rank.RANK2.getValue()
                + rank1count * Rank.RANK1.getValue();

        double EarnRate = (double)totalEarn / gameRepository.getCash() * 100;
        String formatEarnRate =  String.format("%.1f", EarnRate);
        return "총 수익률은 " + formatEarnRate + "%입니다.";
    }

    public List<String> makeScoreResultAndEarnRate(HashMap<List<Integer>, Integer> totalScore) {
        List<String> scoreResult = new ArrayList<>();
        int rank5count = totalScore.getOrDefault(List.of(3, 0), 0);
        scoreResult.add("3개 일치 (5,000원) - " + totalScore.getOrDefault(List.of(3, 0), 0) + "개");
        int rank4count = totalScore.getOrDefault(List.of(4, 0), 0);
        scoreResult.add("4개 일치 (50,000원) - " + rank4count + "개");
        int rank3count = totalScore.getOrDefault(List.of(5, 0), 0);
        scoreResult.add("5개 일치 (1,500,000원) - " + rank3count + "개");
        int rank2count = totalScore.getOrDefault(List.of(5, 1), 0);
        scoreResult.add("5개 일치, 보너스 볼 일치 (30,000,000원) - " + rank2count + "개");
        int rank1count = totalScore.getOrDefault(List.of(6, 0), 0);
        scoreResult.add("6개 일치 (2,000,000,000원) - " + rank1count + "개");
        scoreResult.add(calcEarnRate(rank5count, rank4count, rank3count, rank2count, rank1count));

        return scoreResult;
    }

    public HashMap<List<Integer>, Integer> calcTotalScore() {
        List<Integer> winLottoNumber = gameRepository.getWinLottoNumber().getNumbers();
        int bonusNumber = gameRepository.getBonusNumber();

        HashMap<List<Integer>, Integer> totalScore = new HashMap<>();
        for (Lotto lotto : gameRepository.getLottos()) {
            List<Integer> score = calcScore(lotto.getNumbers(), winLottoNumber, bonusNumber);
            totalScore.put(score, totalScore.getOrDefault(score, 0) + 1);
        }
        return totalScore;
    }

    public List<Integer> calcScore(List<Integer> lottoNumber, List<Integer> winlottoNumber, int bonusNumber) {
        // score = {일치 개수, 보너스 볼 일치 여부}
        List<Integer> score = new ArrayList<>(Collections.nCopies(2, 0));

        int count = 0;
        for (int index = 0; index < 6; index++) {
            if (lottoNumber.contains(winlottoNumber.get(index))) {
                count++;
            }
            if (lottoNumber.get(index) == bonusNumber) {
                score.set(1, (int) STATUS.BONUSCORRECT.getValue());
            }
        }
        score.set(0, count);
        return score;
    }
}
