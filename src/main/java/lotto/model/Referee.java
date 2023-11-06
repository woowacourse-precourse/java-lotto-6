package lotto.model;

import java.util.List;
import lotto.constant.GradeConstant;

public class Referee {

    private final List<Lotto> playerLottos;
    private final Lotto winningLotto;
    private final int bonusNumber;

    public Referee(List<Lotto> playerLottos, Lotto winningLotto, int bonusNumber) {
        this.playerLottos = playerLottos;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public List<GradeConstant> getGrades() {
        return playerLottos.stream()
                .map(playerLotto -> {
                    List<Integer> numbers = playerLotto.getNumbers();
                    int hit = (int) numbers.stream()
                            .filter(winningLotto::contains)
                            .count();
                    boolean hitBonus = playerLotto.contains(bonusNumber);
                    return getGrade(hit, hitBonus);
                }).toList();
    }

    private GradeConstant getGrade(int hit, boolean hitBonus) {
        if (hit == 6) {
            return GradeConstant.FIRST;
        } else if (hit == 5) {
            if (hitBonus) {
                return GradeConstant.SECOND;
            }
            return GradeConstant.THIRD;
        } else if (hit == 4) {
            return GradeConstant.FOURTH;
        } else if (hit == 3) {
            return GradeConstant.FIFTH;
        }
        return GradeConstant.NOTHING;
    }
}