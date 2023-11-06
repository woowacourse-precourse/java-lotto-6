package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.BonusNumber;
import lotto.Lotto;
import lotto.configuration.BonusCount;
import lotto.configuration.ScoreBoard;
import lotto.configuration.WinningLevel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class LottoService {

    private static final String COMMAS = ",";
    private static final Integer START_NUMBER = 1;
    private static final Integer LAST_NUMBER = 45;
    private static final Integer COUNT = 6;

    public List<Integer> convertToLottoIntegerList(String userInput) {
        return Arrays.stream(userInput.split(COMMAS))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<List<Integer>> generateRandomLottoNumbers(Long length) {

        List<List<Integer>> lottoNumbers = new ArrayList<>();

        for (Integer count = 0; count < length; count++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_NUMBER, LAST_NUMBER, COUNT);
            lottoNumbers.add(numbers);
        }
        return lottoNumbers;
    }

    public Integer countMatchingWinningNumbers(List<Integer> winningLotto, List<Integer> myLotto) {

        Integer countValue = 0;

        for (int j = 0; j < COUNT; j++) {
            if (winningLotto.contains(myLotto.get(j))) {
                countValue++;
            }
        }

        return countValue;
    }

    public void repeatCompare() {

        Lotto lotto = new Lotto(convertToLottoIntegerList("1,2,3,4,5,6"));
        List<Integer> winningLotto = lotto.getLotto();
        List<List<Integer>> myLotto = generateRandomLottoNumbers(8L);

        for (int i = 0; i < 8; i++) {
            countMatchingWinningNumbers(winningLotto, myLotto.get(i));
        }
    }

    public Integer countMatchingBonusNumbers(List<Integer> winningLotto, Integer bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            return BonusCount.PLUS_ONE.getWeight();
        }
        return BonusCount.PLUS_ZERO.getWeight();
    }

    public HashMap<String, Long> generateResultScoreBoard() {
        HashMap<String, Long> scoreBoard = new HashMap<>();
        for (ScoreBoard score : ScoreBoard.values()) {
            scoreBoard.put(score.getKey(), score.getValue());
        }

        return scoreBoard;
    }

    public HashMap<String, Long> getResultScoreBoard(List<List<Integer>> myLotto, List<Integer> winningLotto, Integer bonusNumber) {
        HashMap<String, Long> scoreBoard = generateResultScoreBoard();
        for (int i = 0; i < myLotto.size(); i++) {
            scoreBoard = calculateLottoScore(countMatchingWinningNumbers(myLotto.get(i),winningLotto),bonusNumber,scoreBoard);
        }

        return scoreBoard;

    }

    public HashMap<String, Long> calculateLottoScore(Integer matchingWinningNumber, Integer matchingBonusNumber, HashMap<String, Long> scoreBoard) {
        incrementFirstPlaceScore(matchingWinningNumber,matchingBonusNumber,scoreBoard);
        incrementSecondPlaceScore(matchingWinningNumber,matchingBonusNumber,scoreBoard);
        incrementThirdPlaceScore(matchingWinningNumber,matchingBonusNumber,scoreBoard);
        incrementFourthPlaceScore(matchingWinningNumber,matchingBonusNumber,scoreBoard);
        incrementFifthPlaceScore(matchingWinningNumber,matchingBonusNumber,scoreBoard);
        return scoreBoard;
    }


    public void incrementFirstPlaceScore(Integer matchingWinningNumber, Integer matchingBonusNumber, HashMap<String, Long> scoreBoard) {
        if ((matchingWinningNumber == 6 && matchingBonusNumber == 1) || (matchingWinningNumber == 6 && matchingBonusNumber == 0)) {
            Long score = scoreBoard.get("1st") + WinningLevel.FIRST_PLACE.getReward();
            scoreBoard.put("1st",score);
        }
    }

    public void incrementSecondPlaceScore(Integer matchingWinningNumber, Integer matchingBonusNumber, HashMap<String, Long> scoreBoard) {
        if ((matchingWinningNumber == 6 && matchingBonusNumber == 1) || (matchingWinningNumber == 6 && matchingBonusNumber == 0)) {
            Long score = scoreBoard.get("2nd") + WinningLevel.FIRST_PLACE.getReward();
            scoreBoard.put("2nd",score);
        }
    }

    public void incrementThirdPlaceScore(Integer matchingWinningNumber, Integer matchingBonusNumber, HashMap<String, Long> scoreBoard) {
        if ((matchingWinningNumber == 6 && matchingBonusNumber == 1) || (matchingWinningNumber == 6 && matchingBonusNumber == 0)) {
            Long score = scoreBoard.get("3rd") + WinningLevel.FIRST_PLACE.getReward();
            scoreBoard.put("3rd",score);
        }
    }

    public void incrementFourthPlaceScore(Integer matchingWinningNumber, Integer matchingBonusNumber, HashMap<String, Long> scoreBoard) {
        if ((matchingWinningNumber == 6 && matchingBonusNumber == 1) || (matchingWinningNumber == 6 && matchingBonusNumber == 0)) {
            Long score = scoreBoard.get("4th") + WinningLevel.FIRST_PLACE.getReward();
            scoreBoard.put("4th",score);
        }
    }

    public void incrementFifthPlaceScore(Integer matchingWinningNumber, Integer matchingBonusNumber, HashMap<String, Long> scoreBoard) {
        if ((matchingWinningNumber == 6 && matchingBonusNumber == 1) || (matchingWinningNumber == 6 && matchingBonusNumber == 0)) {
            Long score = scoreBoard.get("5th") + WinningLevel.FIRST_PLACE.getReward();
            scoreBoard.put("5th",score);
        }
    }


}
