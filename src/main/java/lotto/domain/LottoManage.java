package lotto.domain;

public class LottoManage {
    private int correctCount;
    private int correctBonusCount;

    public void getWinningCount(Lotto inputLotto, BonusNumber bonusNumber, RandomLottoList randomLottoList) {
        increaseCount(inputLotto, bonusNumber, randomLottoList);
    }

    private void increaseCount(Lotto inputLotto, BonusNumber bonusNumber, RandomLottoList randomLottoList) {
        correctCount = (int) inputLotto.getNumbers().stream()
                .filter(inputNumber -> randomLottoList.getRandomLottoList().contains(inputNumber))
                .count();

        correctBonusCount = (int) randomLottoList.getRandomLottoList().stream()
                .filter(number -> number == bonusNumber.getBonusNumber())
                .count();
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public int getCorrectBonusCount() {
        return correctBonusCount;
    }
}
