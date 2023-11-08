### 🧩 구현 기능 🧩
- 입력
  - 로또 구입 금액 입력
    - 1,000원 단위로 입력 받으며, ```money%1000!=0```인 경우, 예외처리
  - 당첨 번호를 입력
    - 각 번호는 쉼표 단위로 구분
  - 보너스 번호 입력
- 출력 
  - 발행한 로또 수량과 로또 번호 출력 
    - 로또 번호는 오름차순으로 정렬
  - 당첨 내역 출력
    ```
    3개 일치 (5,000원) - n개
    4개 일치 (50,000원) - n개
    5개 일치 (1,500,000원) - n개
    5개 일치, 보너스 볼 일치 (30,000,000원) - n개
    6개 일치 (2,000,000,000원) - n개
    ```
  - 수익률 출력
    - 소수점 둘째 자리에서 반올림
- 공통 요구 사항
  - 예외 발생 시 에러 메세지(Enum) 출력 
  ```
  [ERROR] (메세지 내용)
  ```

### 📝 상세 기능 명세 📝

 - Model(Domain)
   - Lotto : 각 로또의 상세 유효성 검사를 수행하며, 로또 당첨 번호와 비교하는 기능을 수행한다.
   - Lottos : List<Lotto>의 일급 컬렉션으로, 사용자가 구매한 로또를 생성, 검증, 반환한다. 
 - View
   - InputView : 구매 금액, 당첨 번호, 보너스 번호를 입력받으며, 간단한 유효성 검사를 실행한다.
   - OutputView : 프로그램 진행, 결과, 오류 메세지 등을 출력한다.
 - Controller
   - LottoController : 전반적인 로또 프로그램을 진행, 관리한다.
 - Service
   - LottoService : 로또 결과를 계산하고, 결과를 도출하는 비즈니스 로직을 수행한다.
   - TotalPrize : Map<LottoRank, Integer>의 일급 컬렉션으로 로또 결과를 담고 있다.
 - Utils
   - Constants : 로또 갯수, 범위, 금액 단위 등 상수를 관리하는 enum.
   - ErrorCode : 로또 프로그램에서 발생할 수 있는 예외코드를 관리하는 enum.
   - LottoRank : 로또 당첨 정보를 담고있는 enum.
   - LottoGenerator : 사용자가 구매한 로또를 자동 생성해주는 클래스.
### 💾 파일 구조 💾

 ```
📦src
┣ 📂main
┃ ┗ 📂java
┃ ┃ ┗ 📂lotto
┃ ┃ ┃ ┣ 📂controller
┃ ┃ ┃ ┃ ┗ 📜LottoController.java
┃ ┃ ┃ ┣ 📂domain
┃ ┃ ┃ ┃ ┣ 📜Lotto.java
┃ ┃ ┃ ┃ ┗ 📜Lottos.java
┃ ┃ ┃ ┣ 📂service
┃ ┃ ┃ ┃ ┣ 📜LottoService.java
┃ ┃ ┃ ┃ ┗ 📜TotalPrize.java
┃ ┃ ┃ ┣ 📂utils
┃ ┃ ┃ ┃ ┣ 📜Constants.java
┃ ┃ ┃ ┃ ┣ 📜ErrorCode.java
┃ ┃ ┃ ┃ ┣ 📜LottoGenerator.java
┃ ┃ ┃ ┃ ┗ 📜LottoRank.java
┃ ┃ ┃ ┣ 📂view
┃ ┃ ┃ ┃ ┣ 📜InputView.java
┃ ┃ ┃ ┃ ┗ 📜OutputView.java
┃ ┃ ┃ ┗ 📜Application.java
┗ 📂test
┃ ┗ 📂java
┃ ┃ ┗ 📂lotto
┃ ┃ ┃ ┣ 📂domainTest
┃ ┃ ┃ ┃ ┣ 📜LottosTest.java
┃ ┃ ┃ ┃ ┗ 📜LottoTest.java
┃ ┃ ┃ ┣ 📂serviceTest
┃ ┃ ┃ ┃ ┗ 📜TotalPrizeTest.java
┃ ┃ ┃ ┗ 📜ApplicationTest.java
  ```