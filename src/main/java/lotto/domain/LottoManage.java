package lotto.domain;

public class LottoManage {
    private int correctCount = 0;
    private int correctBonusCount = 0;

    public void getWinningCount(Lotto inputLotto, BonusNumber bonusNumber, RandomLottoList randomLottoList) {
        increaseCount(inputLotto, bonusNumber, randomLottoList);
    }

    private void increaseCount(Lotto inputLotto, BonusNumber bonusNumber, RandomLottoList randomLottoList) {
        for (int inputNumber : inputLotto.getNumbers()) {
            if (randomLottoList.getRandomLottoList().contains(inputNumber)) {
                correctCount++;
            }
        }
        if (randomLottoList.getRandomLottoList().contains(bonusNumber.getBonusNumber())) {
            correctBonusCount++;
        }
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public int getCorrectBonusCount() {
        return correctBonusCount;
    }
}
