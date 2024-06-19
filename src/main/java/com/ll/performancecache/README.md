## xml 파일에 대한 정보
* name: 캐시의 이름

* maxElementsInMemory: 메모리에 저장할 수 있는 최대 요소 수

* maxElementsOnDisk: 디스크에 저장할 수 있는 최대 요소 수

* external: 캐시 항복이 영원히 유지되는지 여부. (여기서는 false로 설정되어 있으므로 캐시 항목은 유호 기간(timeToLiveSeconds) 또는 유휴 기간(timeToIdleSeconds)이 지나면 제거된다.)

* statistics: JMX 통계 정보 갱신 옵션

* timeToIdleSeconds: 셀정된 시간 동안 Idle(유후상태) 상태시 갱신, 캐시된 데이터가 사용 되지 않은 채로 유지되는 최대 시간

* timeToLiveSeconds: 설정된 시간 동안 유지 후 갱신, 캐시 된 데이터의 전체 수명

* overflowToDisk: 메모리에 캐시된 데이터가 메모리 한계를 초과하는 경우 디스크로 넘길지 여부를 지정

* diskPersistent: 디스크에 저장된 데이터가 시스템 재시작 후에도 유지되어야 하는지 여부를 나타냄

* memoryStoreEvictionPolicy: 메모리가 꽉 찼을 때 데이터 제거 알고리즘 옵션 ex) `LRU`, `LFU`, `FIFO`
