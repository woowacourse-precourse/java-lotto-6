
## 구현할 기능 정의

- 구입금액 입력받기
  - 입력받은 값에 대해 1000으로 나누고 안될시에 예외 발생
    -  `IllegalArgumentException` : 파라미터 잘못
    -  `IllegalStateException` : 부적절한 메소드가 호출되었을때
- 받은 돈만큼 로또를 발행한다.
    - 이때 중복된 숫자 없이 `IllegalArgumentException`
    - 오름차순으로 정렬 (1,2,3)
- 당첨번호를 입력받는다.
    - 이때 6자리의 숫자가 아니면 `IllegalArgumentException`
    - 1 ~ 45 사이의 수가 아니면 `RunTimeException` -> parseInt 중간에 나는 거라 RunTime으로 예외터진다.
    - 중복된 숫자가 있는지 확인하고 `IllegalArgumentException`
- 보너스 숫자를 입력받는다.
    - 숫자가 아니면 `IllegalArgumentException`
    - 당첨번호와 중복이 있는지 확인한다.
- 당첨통계를 호출한다.
    - 입력받은 수를 기준으로 반복문을 돌면서 몇개가 맞았는지 확인
    - 복권값을 list 로 가지고 있어서 contain() 을 돌려서 해결한다. → 복권값 확인
    - → 서비스 숫자 확인
- 일치한거 담아두기
- 3~ 6개 일치 다 출력 하는데 해당 개수가 몇개인지 확인