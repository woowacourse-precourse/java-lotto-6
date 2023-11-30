# Enum 이란?

## Enum의 장점
- 코드가 단순해지며, 가독성이 좋아진다.
- why? if,else,switch,case 등과 같은 구문을 사용하지 않고 구분할 수 있다.
- 잘못된 상수가 들어가는 경우를 방지할 수 있다.

`public class EnumExample {
// Enum 정의
public enum Day {
SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}

    public static void main(String[] args) {
        Day today = Day.MONDAY;

        // Enum 값 사용
        if (today == Day.MONDAY) {
            System.out.println("Today is Monday");
        }
    }
}`