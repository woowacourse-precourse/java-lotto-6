package lotto.statistics.calculatewinning;

import java.util.Objects;

public class WinningResults<T extends NotWin,R extends Win> {
  private final T notWin;
  private final R win;

  private WinningResults(T notWin, R win) {
    this.notWin = notWin;
    this.win = win;
  }

  public static <T extends NotWin,R extends Win> WinningResults<T,R> notWin(T notWin) {
    return new WinningResults<>(notWin, null);
  }

  public static <T extends NotWin,R extends Win> WinningResults<T,R> win(R win) {
    return new WinningResults<>(null, win);
  }

  public boolean isWin() {
    return win != null;
  }

  public boolean isNotWin() {
    return notWin != null;
  }

  public T getNotWin() {
    return notWin;
  }

  public R getWin() {
    return win;
  }

  @Override
  public String toString() {
    return "WinningResults{" +
        "notWin=" + notWin +
        ", win=" + win +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof WinningResults<?, ?> that)) {
      return false;
    }
    return Objects.equals(notWin, that.notWin) && Objects.equals(win, that.win);
  }

  @Override
  public int hashCode() {
    return Objects.hash(notWin, win);
  }
}
