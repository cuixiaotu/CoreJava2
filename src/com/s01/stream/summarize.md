## Java核心技术卷2
### 第一章 流库
#### 1.1 从迭代到流
流比迭代更易读，更符合程序处理逻辑
1. 流不存储其元素 按需生成
2. 流的操作不影响其数据源
3. 流的操作是惰性的  操作所有流，但是操作会在满足条件的时候停止

#### 1.2 流的创建
Stream可以将任意集合转换为一个流
1. Stream.of()
2. Array.stream(array,from,to)
3. Stream.empty()
4. Stream.generate(Supplier<T>)
5. Stream.iterate(BigInteger.ZERO,n->n.add(BigInter.One)

#### 1.3 流的方法
1. filter 过滤当前流
2. map    转换流中的值  
3. flatMap 包含流的了流

#### 1.4 抽取子流和连接流
1. limit 
2. skip
3. concat 

#### 1.5 其他流转换
1. distinct 
2. sorted
3. peek

#### 1.6 简单约简
1. max
2. min
3. findFirst
4. findAny
5. anyMatch
6. allMatch 
7. noneMatch

### 1.7 包装对象
Optional<T>对象是一种包装器对象，视为更安全的放阿飞用来替代T的引用
1.7.1 值不存在时候的可替代物，只有值存在的时候才使用这个值
1. orElse
2. orElseGet
3. orElseThrow
4. ifPresent
5. map
1.7.2 不适合用Optional值
optional值不存在的时候.get方法会抛出NoSuchElementException对象
可以用isPresent先检查
1.7.3 创建Optional值
1. Optional.of()
2. Optional.empty()
3. Optional.ofNullable()
1.7.4 用flatMap构建Optional值的函数
Optional<T>对象的方法f，目标类型T可以产生Optional<U>对象的方法g.普通方法的情况下可以调用，s.f().g(),但是s.f()产生的是Optional<T>
Optional<U> result = s.f().flatMap(T::g)

### 1.8 收集结果
处理完流后，可以调用iterator方法，或者用forEach
Collectors类提供大量的生成公共收集器的工厂方法
List<String> res = stream.collect(Collectors.toList());
Set<String> res = stream.collect(Collectors.toSet());
TreeSet<String> res = stream.collect(Collectors.toCollection(TreeSet::new));

### 1.9 收集到映射表中
Collectors.toMap
Map<Integer,String> idToName = people.collect(Collectors.toMap(Person::getId,Person::getName));
Map<Integer,Peoson> idToName = people.collect(Collectors.toMap(Person::getId,Function.identity));

### 1.10 群组和分区
groupingBy     群组 
partitioningBy 分区

### 1.11 下游收集器
多种群组收集器
counting 计数
summing  总和
maxBy    下游元素的最大值
minBy    下游元素的最小值

### 1.12 约简操作
reduce 接受一个二元函数，将两个元素持续应用该函数

### 1.13 基本类型流
IntStream
LongStream
DoubleStream

mapToInt
mapToLong
mapToDouble

### 1.14 并行流
流使并行处理变的容易
Collection.parallelStream() 将任意集合转换为并行流
stream.parallel() 将顺序流转为并行流



 

java.util.stream.Stream<T> 1.8
- Stream<T> filter(Predicate<? super T> p)
    返回一个流，当前流中满足条件p的所有元素
- long count()   
    当前流中的元素个数
- static <T> Stream<T> of(T ...values)
    返回一个给定元素的流
- static <T> Stream<T> empty(T ...values)
    返回一个不包含任何元素的流
- static <T> Stream<T> generate(Supplier<T> s)
    返回一个无限流，通过反复调用函数s生成
- static <T> Stream<T> iterate(T seed,UnaryOperator<T> f)
    返回一个无限流，元素包含种子，在种子上调用f产生的值，在前一个元素上调用f产生的值等。。。

- static <T> Stream<T> filter(Predicate<? super T> predicate)
    返回一个流，包含当前流中所有满足断言条件的元素 （过滤不满足条件的元素）
- static <R> Stream<R> map(Function <? super T,? extend R> mapper)
    返回一个流，包含将mapper应用于当前流所有元素所产生的结果.
- static <R> Stream<R> map(Function <? super T,? extend R> mapper)
    返回一个流，将mapper应用于当前流所有元素所产生的结果连接到一起.     
    
- Stream<T> limit(long maxSize)
  返回一个流，包含当前流中最初的maxSize个元素
- Stream<T> skip(long n)
  返回一个流，除了前n个元素之外的
- Stream<T> Stream<T> concat( Stream<? extends T>a,Stream<? extends T>b)
  返回一个流，他的元素是a的元素后台面跟着b的元素.    
  
 - Stream<T> distinct()
   返回一个流，包含当前流中所有不同的元素
 - Stream<T> sorted()
 - Stream<T> sorted(Comparator <? super T>comparator)
   返回一个流，按照comparator排序
 - Stream<T> peek( Consumer<? extends T>action)
   返回一个流，与当前元素相同，获取元素将传递给action      

-  void forEach(Consumer <? super T> action)
    流上的每个元素调用aciton.
-  Object[] toArray()
-  Object[] toArray(IntFunction <A[]> generator)
    产生一个对象数组，或者引用A[]::new
-  <R,A>R collect(Collector <? super T,A,R> collector)    
    使用给定的收集器来收集当前流中的元素.
           

java.util.Arrays 1.2
- static <T> Stream<T> stream(T[] array,int startInclusive,int endExclusive)  1.8
    返回一个流,数组中指定范围的元素构成

java.util.regex.Pattern 1.4
- Stream<String> splitAsStream(CharSequence input)  1.8
    返回一个流,它的元素是输入中由该模式界定的部分
   

java.util.Collection<E> 1.2
- default Stream<E> stream()
    集合中所有元素的顺序流
- default Stream<E> parallelStream()
    集合中所有元素的并行流
    
java.nio.file.Files 1.7
- static Stream<String> lines(Path path) 1.8    


java.util.Optional<T> 1.8
- T orElse (T other)
    产生Optional的值，若Optional为空则产生other
- T orElseGet (Supplier <? extend T> other)
    产生Optional的值，若Optional为空则调用other结果.
- T orElseThrow (Supplier <? extend X> exceptionSupplier)
    产生Optional的值，若Optional为空则抛出exceptionSupplier的结果.
- void ifPresent(Consumer <? extend T> consumer)
    如果Optional不为空，那么将它传递给consumer
- <U>Optional<U> map <Function<? extend T,? extends U> mapper>
    产生将Optional的值传递给mapper后的结果
    
        

