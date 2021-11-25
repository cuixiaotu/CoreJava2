Java核心技术卷2.day1 流库
流比迭代更易读，更符合程序处理逻辑
1. 流不存储其元素 按需生成
2. 流的操作不影响其数据源
3. 流的操作是惰性的  操作所有流，但是操作会在满足条件的时候停止


java.util.stream.Stream<T> 1.8
- Stream<T> filter(Predicate<? super T> p)
- long count()   

java.util.Collection<E> 1.2
- default Stream<E> stream()
- default Stream<E> parallelStream()


