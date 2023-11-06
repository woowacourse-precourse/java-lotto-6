## 프로그래밍 요구 사항

- [] JDK17 버전에서 실행 가능해야 한다.
- [] build.gradle 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
- [] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
- [] 3항 연산자를 쓰지 않는다.
- [] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만든다.
- [] JUnit5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
- [] 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- [] else 예약어를 쓰지 않는다.
    - switch/case도 허용하지 않는다.
- [] Java Enum을 적용한다.
- [] 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
    - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
    - 단위 테스트 작성이 익숙하지 않다면 `test/java/lotto/LottoTest` 를참고하여 학습한 후 테스트를 구현한다.
- [] `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
    - Random값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.