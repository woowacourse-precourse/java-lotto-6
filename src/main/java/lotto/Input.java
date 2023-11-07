package lotto;

public abstract class Input<T> {
    public void save(String readLine) {}
    protected T validate(String readLine) { return null;}
    protected String removeEmpty(String readLine) {return null;}
    protected T translateToValueType(String noEmptyReadLine) {return null;}
    protected void checkBoundary(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 번호는 1~45 범위 내에 해당해야 합니다.");
        }
    }
}
