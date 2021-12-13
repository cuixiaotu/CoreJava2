## Java核心技术卷2
### 第二章 输入与输出
#### 2.1 输入/输出流
从其中读入一个字母序列的对象称为输入流，想其中写入一个字母序列的对象叫做输出流。
Unicode每个字符都是多个字节，JAVA有专门处理Unicode的单独类(读取两字节的Char类型， Unicode码元)
1.    InputStream 
2.    OutputStream
3.    Reader
4.    Writer 
    



1. 读写单个字节/字节数组:
    InputStream read
    OutputStream write
2. 二进制读写所有基础Java类型
    DataInputStream
    DataOutputStream 
3. Unicode文本
    Reader
    Writer
4. ZIP压缩格式读写
    ZipInputStream
    ZipOutputStream


Closeable Flushable Readable Appendable

- 文件读写
    FileInputStream
    FileOutputStream
        


#### 2.2 文本的输入输出



java.io.InputStream 1.0
- abstract int read
    读取一个字节,并返回改字节，碰到输入流结尾的时候返回-1.
- int read(byte[] b)
- int read(byte[] b,int off,int len)
    读取一个字节数组，并返回实际读入的字节数.
- available()
    在不阻塞的情况下获取字节数.
- void close()
    关闭这个输入流
- void reset()
    返回最后一个标记，随后read重新读入这些字节，如果没有标记，这个流不会被重置。
- void mark(int readlimit)
    在当前位置打个标记
- boolean markSupported()
    当前流是否支持打标记

java.io.OutputStream 1.0
- abstract int write
    写出一个字节的数据
- void write(byte[] b)    
- void write(byte[] b,int off,int len)  
    写出所有的字节或某个范围的字节到数组b
- void close()
    冲刷并关闭输出
- void flush()
    冲刷输出流
