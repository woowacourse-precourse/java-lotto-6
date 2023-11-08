## 기능 구현 목록

### Random Number Set Generator Class
 - 인터페이스를 기반으로 구현체 설계
 - 길이를 인자로 받는 static 메서드 구현

### Lotto Publisher Class
 - 금액을 input으로 받으며 금액에 해당하는 만큼의 lotto 발행
 - 위 number generator를 기반으로 한 Lotto 발행 기능
 - 여러 lotto ticket list를 반환할 수 있는 기능

### Lotto Checker class
 - 당첨 번호(+ 보너스 번호)를 input으로 가지는 class 
 - lotto 번호와 당첨 번호와 비교하여 등수 반환 기능

### Lotto Result class
 - Lotto checker를 인스턴스 변수로 가지는 class
 - 각 lotto ticket에 대하여 checker를 통해 등수 및 당첨금을 저장하는 기능
 - 수익률 반환 기능

### Lotto Prize enum
 - 등수에 따른 당첨금 반환

### Lotto class
 - lotto numbers getter 추가