package lotto;

public class LottoMachine {
//    private List<Integer> winningNumber = new ArrayList<>();
    // 크기가 정해져있고, 불편해서 배열쓰는게 나을수도....
    private String[] winningNumber;
    private int bonusNumber;

    public String[] getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setWinningNumber(String[] winningNumber) {
        Validator.isWinningNumberValid(winningNumber);
        Validator.isWinningNumberDistinct(winningNumber);
        Validator.isWinningNumberSizeValid(winningNumber);
//        for (String num : winningNumber){
//            this.winningNumber.add(Integer.parseInt(num));
//        }
        this.winningNumber = winningNumber;
    }

    public void setBonusNumber(String bonusNumber) {
        Validator.isBonusNumberValid(bonusNumber);
        Validator.isBonusNumberDistinct(winningNumber,bonusNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }


}
