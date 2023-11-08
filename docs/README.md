## 목차

---

[1. 기능 작성 전 확인 사항](#span-stylebackground-colore8d5951--기능-작성-전-확인-사항-)<br>
[2. 📈 로또 📈 의 기능 목록](#span-stylebackground-colore8d5952--로또---의-기능-목록)<br>
[3. 2주차 피드백 정리](#span-stylebackground-colore8d5953-저번-2주차-피드백-정리-신경쓰자)<br>
[4. 목표](#span-stylebackground-colore8d595-4-목표)<br>
[5. 구현하며 신경 쓸 점들](#span-stylebackground-colore8d595-5-구현하며-신경-써야-할-점들)<br>
[6. 결과](#span-stylebackground-colore8d595-6-결과)

## <span style="background-color:#E8D595">**1. ✅ 기능 작성 전 확인 사항! ✅**

---

- [ ] `java -version` 으로 자바의 버전이 17인지 확인한다!
- [ ] `./gradlew clean test` 명령어로 테스트가 통과되는지 확인한다!

## <span style="background-color:#E8D595">**2. 📈 로또 📈 의 기능 목록**

---

- 입력
    - 진행
        - [x] 로또 구입 금액을 입력 받는다.
        - [x] 1~45 사이의 당첨 번호 6개를 입력 받는다.
        - [x] 보너스 번호를 입력 받는다.
    - 예외
        - [x] 로또 구입 금액은 숫자 여야 한다.
            - [x] 1000원 단위로 나누어져야 한다.
        - [x] 쉼표를 기준으로 구분한 번호는 1~45 사이의 숫자여야 한다.
            - [x] 공백을 지우고 받는다.
            - [x] 숫자가 중복이면 안된다.
        - [x] 보너스 번호 또한 중복이면 안된다.
- 로또
    - 진행
        - [x] 6개의 번호를 가진 로또를 금액에 맞게 발행한다.
            - [x] 오름차순으로 정렬한다.
                - [x] 소수점 둘째 자리에서 반올림한다.
- 출력
    - 에러
        - [x] "[ERROR]"로 시작되는 에러 문구를 출력한다.
            - [x] `IllegalArgumentException` 을 던지되, 출력 후 다시 입력 받는다.
    - 문구
        - [x] 몇개를 구매했는지 나타낸다.
        - [x] 출력한 로또를 보여준다.
        - [x] 당첨 통계를 출력한다.
        - [x] 총 수익률을 출력한다.

## <span style="background-color:#E8D595">**3. 저번 2주차 피드백 정리 (신경쓰자!)**

[장유진 2주차 회고](https://velog.io/@nellroll/%EC%9A%B0%EC%95%84%ED%95%9C-%ED%85%8C%ED%81%AC-%EC%BD%94%EC%8A%A4-6%EA%B8%B0-2%EC%A3%BC%EC%B0%A8-%ED%94%84%EB%A6%AC%EC%BD%94%EC%8A%A4-%ED%9A%8C%EA%B3%A0)

<br>

- 상수들도 `접근 제어자`를 신경쓰자!
- `매직 넘버`를 `지양`하자!
- 객체에게 `메시지`를 던져 직접 요구해보자!
- 함수의 `네이밍`에도 신경쓰자!
- Exception은 던지고 있는 Exception으로 잡아주자!
- `record`를 사용해보자!
- 가독성을 위한 method 분리도 고려해보자!
- `@DisplayName` 같은 어노테이션을 사용해보자!
- `지역 변수`로 호출도 고민해보자!
- `Stream`을 사용하여 `불변객체`로 만드는것도 반드시 고려해보자!
- `정적 팩토리 메서드`를 고려해보자!
- `Console` 에 `println()` 을 만들어 보기!

## <span style="background-color:#E8D595"> **4. 목표**

---

- [x] 피드백들을 많이 신경써서 3주차엔 새로운 피드백을 얻어보기!
- [x] 요구사항 잘 확인하기!

## <span style="background-color:#E8D595"> **5. 구현하며 신경 써야 할 점들!**

---
<br>

- [x] indent(인덴트, 들여쓰기) **depth를 3이 넘지 않도록 구현**하자. 어렵다면 함수로 분리하기!
- [x] 3항 연사자를 쓰지 말것!
- [x] 함수(또는 메서드)가 **한 가지 일만** 하도록 최대한 작게 만들자!
- [x] **JUnit 5와 AssertJ를 이용**하여 내 기능이 잘 돌아가는지 확인할 테스트 코드를 작성하자!
- [x] https://gist.github.com/stephenparish/9941e89d80e2bc58a153 에 있는 커밋 메시지 컨벤션을 지키자!
- [x] else와 switch를 사용하지 말자!
- [x] Enum을 적용하자!
- [x] 함수의 길이가 15라인을 넘지 않게 한다!
- [x] 도메인 로직에 단위 테스트를 추가하자!

## <span style="background-color:#E8D595"> **6. 결과**

---

- 정상 작동

![Animation2](https://github.com/palm-springs/PalmSpringsServer/assets/105053478/41a640a4-f7eb-4c83-b6a0-b5bc6c831c07)

- 금액이 단위로 안떨어질 경우 재입력

![Animation2](https://github.com/palm-springs/PalmSpringsServer/assets/105053478/3473ee6a-c6ed-4f2a-bf3d-c0e18205bb28)

- 중복 입력시 재입력

![Animation2](https://github.com/palm-springs/PalmSpringsServer/assets/105053478/15cc90f1-88d8-4767-ad2f-0189865c5388)