package lotto;

public class DrawingLotto {
    private Lotto drawingNumbers;
    private int bonusNumber;

    public DrawingLotto(Lotto drawingNumbers, int bonusNumber) {
        validate(drawingNumbers, bonusNumber);
        this.drawingNumbers = drawingNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto lotto, int bonusNumber) {
        if (Lotto.isOutOfRange(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 범위 안의 숫자를 입력해주세요");
        }
        if (lotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호 " + lotto.getNumbers() + "과 중복된 번호 " + bonusNumber + "가 입력되었습니다.");
        }
    }

    public LottoResult compareWith(Lotto lotto) {
        int match = (int) lotto.getNumbers().stream().filter(number -> drawingNumbers.getNumbers().contains(number)).count();
        switch (match) {
            case 6:
                return LottoResult.FIRST;
            case 5:
                if (lotto.getNumbers().contains(bonusNumber)) {
                    return LottoResult.SECOND;
                } else {
                    return LottoResult.THIRD;
                }
            case 4:
                return LottoResult.FOURTH;
            case 3:
                return LottoResult.FIFTH;
            default:
                return LottoResult.NONE;
        }
    }
}
