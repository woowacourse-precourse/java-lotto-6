package lotto.domain;

public class WinningDto {

    private Integer countThree = 0;
    private Integer countFour = 0;
    private Integer countFive = 0;
    private Integer countFivePlusBonus = 0;
    private Integer countSix = 0;
    private Double earningRate;

    public WinningDto() {
    }

    public WinningDto(Integer countThree, Integer countFour, Integer countFive,
                      Integer countFivePlusBonus, Integer countSix, Double earningRate) {
        this.countThree = countThree;
        this.countFour = countFour;
        this.countFive = countFive;
        this.countFivePlusBonus = countFivePlusBonus;
        this.countSix = countSix;
        this.earningRate = earningRate;
    }

    public Integer getCountThree() {
        return countThree;
    }

    public Integer getCountFour() {
        return countFour;
    }

    public Integer getCountFive() {
        return countFive;
    }

    public Integer getCountFivePlusBonus() {
        return countFivePlusBonus;
    }

    public Integer getCountSix() {
        return countSix;
    }

    public Double getEarningRate() {
        return earningRate;
    }

    public void addCountThree() {
        countThree++;
    }

    public void addCountFour() {
        countFour++;
    }

    public void addCountFive() {
        countFive++;
    }

    public void addCountFivePlusBonus() {
        countFivePlusBonus++;
    }

    public void addCountSix() {
        countSix++;
    }

    public int calculateTotalPrize() {
        int totalPrize = 0;
        totalPrize += Coincidence.THREE.getPrize() * countThree;
        totalPrize += Coincidence.FOUR.getPrize() * countFour;
        totalPrize += Coincidence.FIVE.getPrize() * countFive;
        totalPrize += Coincidence.FIVE_PLUS_BONUS.getPrize() * countFivePlusBonus;
        totalPrize += Coincidence.SIX.getPrize() * countSix;
        return totalPrize;
    }

    public void setEarningRate(Double earningRate) {
        this.earningRate = earningRate;
    }
}
