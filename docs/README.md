# 2주차 피드백

1. 기능 목록을 클래스 설계와 구현, 함수(메서드) 설게와 구현과 같이 너무 상세하게 작성하지 않는다.
    - 클래스 이름, 함수(메서드) 시그니처와 반환값은 변경될수 있다.
    - 너무 세세한 부분까지 정리하기보다
    - 구현해야 할 기능 목록을 정리하는 데 집중한다.
2. 정상 적인 경우도 중요하지만, 예외적인 상황도 기능 목록에 정리한다.
    - 예외 상황은 시작 단계에서 모두 찾기 힘들기 때문에 기능을 구현하면서 계속 해서 추가한다.

# 초반 클래스간의 설정

![image-20231104104817104](/Users/seungchan/Library/Application Support/typora-user-images/image-20231104104817104.png)

# ✅ 기능 목록표

- [x] 사용자 클래스 User

    - [x] 돈을 지불한다.
    - [x] 로또를 받는다.
    - [x] 로또를 보여준다. User#showLottos
    - [x] 로또결과의 당첨에 대한 통계를 한다. User#doStatisticLottoResult
    - [x] 당첨 금액을 얻는다.
    - [x] 로또결과의 당첨에 대한 총 수익률을 계산한다. User#calculateTotalRate

- [x] 사용자의 당첨 판단 클래스. Judgment

    - [x] 사용자가 구매한 로또 번호와 당첨 번호를 비교한다. Judgment#compareLottos

        - [x] 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.

        - [x] 1등: 6개 번호 일치 / 2,000,000,000원

        - [x] 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원

        - [x] 3등: 5개 번호 일치 / 1,500,000원

        - [x] 4등: 4개 번호 일치 / 50,000원

        - [x] 5등: 3개 번호 일치 / 5,000원

          (3개 일치 (5,000원) - 1개)

- [x] 사용자의 당첨된 복권들 클래스 SuccessLottoEnvelop

- [x] 사용자의 수익률 클래스 RateResult

    - [x] 수익률을 계산한다. RateResult#calculate

      해당 로또 당첨금과 당청액수을 곱한 것들의 합과 구입한 가격을 나눈다.

      ```
      총 수익률은 62.5%입니다.
      ```

        - [x] 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)

- [x] 사용자의 통계 클래스 Statistic

    - [x] 당첨의 결과를 보여준다.
        - [x] 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
        - [x] 1등: 6개 번호 일치 / 2,000,000,000원
        - [x] 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
        - [x] 3등: 5개 번호 일치 / 1,500,000원
        - [x] 4등: 4개 번호 일치 / 50,000원
        - [x] 5등: 3개 번호 일치 / 5,000원
    
    - [x] 총 당첨 금액을 알려준다.
    


- [x] 로또 판매자 클래스 LottoSeller
    - [x] 로또를 판다. LottoSeller#sell
        - [x] 사용자에게 로또 봉투판다.
    - [x] 로또 봉투을 만든다. LottoSeller#makeLottoEnvelope
    - [x] 로또의 갯수를 알려준다.
    
- [x] 로또 봉투 클래스 LottoEnvelop

    - [x] 봉투에 로또을 추가한다.
    - [x] ~~봉투를 반환한다.~~

- [x] 로또 클래스 생성

- [x] 로또 자동 생성 번호 클래스 생성

    - [x] 로또을 생성한다.

        - [x] ```
      List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
      ```


- [x] 로또 진행자 클래스 LottoHost
    - [x] 당첨 번호 추첨, 보너스 번호를 뽑는다.
    - [x] ~~당첨 번호 추첨을 뽑는다. LottoHost#pickWinNum~~
    - [x] ~~보너스 번호를 뽑는다. LottoHost#pickBonusNum~~
    - [x] 중복되는 번호가 있는지 확인한다.
    - [x] ~~중복되는 당첨 번호가 있는지 확인한다. Lotto#checkDuplicateWinNum~~
    - [x] ~~중복되는 보너스 번호가 있는지 확인한다. Lotto#checkDulicateBonusNum~~

- [x] 보너스 번호 클래스 BonusLottoNum
    - [x] 보너스 번호가 같은지 확인한다. BonusNum#isSame

- [x] 당첨 번호 클래스 WinLottoNums
    - [x] 특정 자릿숫의 추첨 번호와 추측하는 번호가 같은지 확인한다. WinLottoNum#isSame

- [x] 당첨 번호와 보너스 번호들의 모임 클래스 LottoNumResults
    - [x] 당첨 번호 추첨 번호들과, 보너스 번호들을 같은지 확인한다.
        - [x] 당첨 번호 추첨 번호가 같은지 확인한다. isSamePickNum
        - [x] 보너스 번호가 같은지 확인한다. isSameBonusNum


- [x] 진행 클래스 Process
    - [x] 로또를 산다. Process#buyLotto
        - [x] 유저가 로또를 산다.
        - [x] 로또 판매자가 로또를 판다.
    - [x] 로또를 보여준다. Process#showLotto
        - [x] 유저가 로또를 보여준다.
    - [x] 당첨 번호를 뽑는다. Process#pickNum
        - [x] 로또진행자가 당첨 번호를 뽑는다.
        - [x] 로또 진행자가 보너스 번호를 입력한다.
    - [x] 당첨의 결과를 보여준다. Process#showResult
        - [x] 유저가 결과를 통계한다.
        - [x] 유저가 수익률을 계산한다.


- [ ] Input ( IllegalArgumentException 예외 정확하게)
    - [ ] 구입 금액 입력
        - [ ] 1000원 단위 입력을 받는다.
    - [ ] 당첨 번호 입력 (게임 호스트)
        - [ ] 처음과 끝의 문자가 `,`인지 확인이
        - [ ] 중복되는 숫자가 있는지 확인
        - [ ] `,,`의 중간에 숫자 입력을 안한 것이 있는지 확인
        - [ ] 6개 숫자를 입력한지 확인
    - [ ] 보너스 번호 입력 
        - [ ] 당첨 번호와 중복되는 숫자가있는지 확인
    - [x] 문자입력 (Utill) 1,2,3,4,5,6
        - [ ] 숫자을 포함하는가 검사
        - [x] 공백입력 검사
        - [ ] 공백 포함 검사.
        - [ ] 특수기호 포함 검사
        - [x] 입력을 받고 `trim()`
        - [x] 문자 포함 검사.
    - [ ] 숫자입력 (Utill)
        - [ ] 입력을 받고 `trim()`
        - [ ] 공백 입력 검사
        - [ ]  공백 포함 검사.
        - [ ] 양수 입력 검사
        - [ ] 문자열 포함 검사
        - [ ] 특수문자 포함 검사
        - [ ] 숫자 "0"인지 검사.


- [x] 객체 생성을 해주는 Config 클래스
    - [x] 로또 객체 생성
    - [x] 당첨 번호들 모음 객체생성
    - [x] 보너스 번호 객체 생성
    - [x] 당첨, 보너스 번호 모음 객체생성
    - [x] 로또 봉투 객체 생성

    

- [x] 출력을 하는 순서


    - [x] 로또를 구매한다.
    - [x] 판매한 로또갯수를 알려준다.
    - [x] 사용자가 로또의 정보를 보여준다.
    - [x] 게임 호스트가 당첨 번호를 입력한다.
    - [x] 게임 호스트가 보너스 번호를 입력한다.
    - [x] 사용자가 당첨 통계의 결과를 알려준다.
    - [x] 사용자가 총수익률을 알려준다.




# 예외 처리 종류

| **ClassNotFoundException**                                   | **클래스를 찾지 못함**                                       |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| CloneNotSupportedException                                   | Cloneable 인터페이스 미구현                                  |
| IllegalAccessException                                       | 클래스 접근을 못함                                           |
| InstantiationException                                       | 추상 클래스 또는 인터페이스를 인스턴스화 하고자 할때         |
| InterruptedException                                         | 쓰레드가 중단 되었을때                                       |
| NoSuchFieldException                                         | 지정된 필드가 없을때                                         |
| **NoSuchMethodException**                                    | **지정된 메소드가 없을때**                                   |
| [IOException] CharConversionException                        | 문자 변환에서 예외가 발생했을때                              |
| [IOException] EOFException                                   | 파일의 끝에 도달했을때                                       |
| **[IOException] FileNotFoundException**                      | **파일이 발견되지 않았을때**                                 |
| **[IOException] InterruptedIOException**                     | **입출력 처리가 중단 되었을때**                              |
| [IOException][ObjectStreamException] InvalidClassException   | 시리얼라이즈 처리에 관한 문제가 클래스 안에 있을때           |
| [IOException][ObjectStreamException] InvalidObjectException  | 시리얼라이즈된 오브젝트에서 입력 검증에 실패했을때           |
| [IOException][ObjectStreamException] NotActiveException      | 스트림 환경이 액티브하지 않을 때 메소드를 호출했을때         |
| [IOException][ObjectStreamException] NotSerializableException | 오브젝트를 시리얼라이즈 할 수 없을때                         |
| [IOException][ObjectStreamException] OptionalDataException   | 오브젝트를 읽을때 기대 이외의 데이터와 만났을때              |
| [IOException][ObjectStreamException] StreamCorruptedException | 읽은 데이터 스트림이 파손되어 있을때                         |
| [IOException][ObjectStreamException] WriteAbortedException   | 기록중에 예외가 발생한 스트림을 읽었을때                     |
| [IOException] SyncFailedException                            | 시스템 버퍼를 동기시키는 FileDescriptor.sync()의 호출 실패시 |
| [IOException] UnsupportedEncodingException                   | 지정된 문자 부호화 형식을 지원하고 있지 않을때               |
| [IOException] UTFDataFormatException                         | 부정한 UTF-8방식 문자열과 만났을때                           |
| [RuntimeException] ArithmeticException                       | 제로제산 등의 산술 예외 발생시                               |
| [RuntimeException] ArrayStoreException                       | 배열에 부정한 형태의 오브젝트를 저장하고자 할때              |
| [RuntimeException] [IllegalArgumentException] IllegalThreadStateException | 쓰레드가 요구된 처리를 하기에 적합한 상태에 있지 않을때      |
| **[RuntimeException] [IllegalArgumentException] NumberFormatException** | **부적절한 문자열을 수치로 변환하고자 할때**                 |
| [RuntimeException] IllegalMonitorStateException              | 모니터 상태가 부정일때                                       |
| [RuntimeException] IllegalStateException                     | 메소드가 요구된 처리를 하기에 적합한 상태에 있지 않을때      |
| **[RuntimeException] [IndexOutOfBoundException] ArrayIndexOutOfBoundsException** | **범위 밖의 배열 첨자 지정시**                               |
| [RuntimeException] [IndexOutOfBoundException] StringIndexOutOfBoundsException | 범위 밖의 String 첨자 지정시                                 |
| **[RuntimeException] NegativeArraySizeException**            | **음의 크기로 배열 크기를 지정하였을때**                     |
| **[RuntimeException] NullPointerException**                  | **null 오브젝트로 접근했을때**                               |
| [RuntimeException] SecurityException                         | 보안 위반시                                                  |
| [RuntimeException] UnsupportedOperationException             | 지원되지 않는 메소드를 호출했을때                            |
| @ Error                                                      |                                                              |
| [LinkageError] ClassCircularityError                         | 클래스 초기화중에 순환 참조를 검출시                         |
| [LinkageError] [ClassFormatError] UnsupportedClassVersionError | JVM이 지원되지 않는 버전의 번호를 가진 클래스 파일을 읽고자 할때 |
| [LinkageError] ExceptionInInitializerError                   | 정적 이니셜라이저로 예외가 발생시                            |
| [LinkageError] [IncompatibleClassChangeError] AbstracMethodError | 추상 메소드를 호출했을때                                     |
| [LinkageError] [IncompatibleClassChangeError] IllegalAccessError | 접근할 수 없는 메소드와 필드를 사용하고자 했을때             |
| [LinkageError] [IncompatibleClassChangeError] InstantiationError | 인터페이스 또는 추상 클래스를 인스턴스화하고자 했을때        |
| [LinkageError] [IncompatibleClassChangeError] NoSuchFieldError | 지정한 필드가 존재하지 않을때                                |
| **[LinkageError] [IncompatibleClassChangeError] NoSuchMethodError** | **지정한 메소드가 존재하지 않을때**                          |
| **[LinkageError] NoClassDefFoundError**                      | **클래스 정의가 발견되지 않았을때**                          |
| [LinkageError] UnsatisfieldLinkError                         | 클래스에 포함되는 링크 정보를 해결할 수 없을때               |
| [LinkageError] VerifyError                                   | 클래스 파일안에 부적절한 부분이 있을때                       |
| ThreadDeath                                                  | 쓰레드가 정지해야만 한다는 의미                              |
| [VirtualMachineError] InternalError                          | 내부에러                                                     |
| **[VirtualMachineError] OutOfMemoryError**                   | **메모리부족으로 메모리를 확보 못함**                        |
| **[VirtualMachineError] StackOverflowError**                 | **스택 오버 발생**                                           |
| [VirtualMachineError] UnknownError                           | 심각한 예외발생                                              |



# 🚀 기능 요구 사항

- (**사용자**가 **로또 판매자**에게) **로또** <u>구입 금액을 입력</u>하면 (**로또 판매자**는 **사용자**가) 구입 금액에 해당하는 만큼 **로또를** <u>발행해야</u> 한다.

    - **로또** 1장의 가격은 1,000원이다.
    - 로또 구입 금액을 입력 받는다. 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.

- **(로또 진행자가)** 당첨 번호와 보너스 번호를 입력받는다.

    - **로또** 번호의 숫자 범위는 1~45까지이다.

    - 1개의 **로또를** 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.

    - (로또 진행자의 )당첨 **번호** 추첨 시 중복되지 않는 숫자 6개와 (중복되지 않는)보너스 번호 1개를 뽑는다.

    - 당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.

      ```
      1,2,3,4,5,6
      ```

    - ```
    7
    ```

- **사용자가** 구매한 로또 번호와 당첨 번호를 <u>비교하여</u> 당첨 내역

    - **당첨**은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.

          - 1등: 6개 번호 일치 / 2,000,000,000원
          - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
          - 3등: 5개 번호 일치 / 1,500,000원
          - 4등: 4개 번호 일치 / 50,000원
          - 5등: 3개 번호 일치 / 5,000원

- **수익률**을 출력하고 **로또** 게임을 종료한다.

- 사용자가 잘못된 값을 입력할 경우

    - `IllegalArgumentException`를 발생시키고,
    - "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.

    - `Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리한다.

# 입출력 요구 사항

#### ✍️ 입력

- 로또 구입 금액을 입력 받는다. 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.

```
14000
```

- 당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.

```
1,2,3,4,5,6
```

- 보너스 번호를 입력 받는다.

```
7
```

#### 👁️ 출력

- 발행한 로또 수량 및 번호를 출력한다. 로또 번호는 오름차순으로 정렬하여 보여준다.

```
8개를 구매했습니다.
[8, 21, 23, 41, 42, 43] 
[3, 5, 11, 16, 32, 38] 
[7, 11, 16, 35, 36, 44] 
[1, 8, 11, 31, 41, 42] 
[13, 14, 16, 38, 42, 45] 
[7, 11, 30, 40, 42, 43] 
[2, 13, 22, 32, 38, 45] 
[1, 3, 5, 14, 22, 45]
```

- 당첨 내역을 출력한다.

```
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
```

- 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)

```
총 수익률은 62.5%입니다.
```

- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.

```
[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.
```

#### 실행 결과 예시

```
구입금액을 입력해 주세요.
8000

8개를 구매했습니다.
[8, 21, 23, 41, 42, 43] 
[3, 5, 11, 16, 32, 38] 
[7, 11, 16, 35, 36, 44] 
[1, 8, 11, 31, 41, 42] 
[13, 14, 16, 38, 42, 45] 
[7, 11, 30, 40, 42, 43] 
[2, 13, 22, 32, 38, 45] 
[1, 3, 5, 14, 22, 45]

당첨 번호를 입력해 주세요.
1,2,3,4,5,6

보너스 번호를 입력해 주세요.
7

당첨 통계
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.
```

# 💪 추가된 요구 사항

- Java Enum을 적용한다.
- 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
    - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
    - 단위 테스트 작성이 익숙하지 않다면 `test/java/lotto/LottoTest`를 참고하여 학습한 후 테스트를 구현한다