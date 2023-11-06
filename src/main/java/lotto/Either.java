package lotto;

public class Either<T,R> {
  private final T left;
  private final R right;

  private Either(T left, R right) {
    this.left = left;
    this.right = right;
  }

  public static <T,R> Either<T,R> left(T left) {
    return new Either<>(left, null);
  }

  public static <T,R> Either<T,R> right(R right) {
    return new Either<>(null, right);
  }

  public boolean isLeft() {
    return left != null;
  }

  public boolean isRight() {
    return right != null;
  }

  public T getLeft() {
    return left;
  }

  public R getRight() {
    return right;
  }
}
