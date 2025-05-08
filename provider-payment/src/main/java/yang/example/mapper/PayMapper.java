package yang.example.mapper;

import tk.mybatis.mapper.common.Mapper;
import yang.example.entities.Pay;

/*
* UserMapper.java 是一个 Java 接口，定义了对数据库的操作方法（如 selectUserById、insertUser 等）。
* Service 层可以直接调用 UserMapper 接口的方法，而不需要关心 SQL 的具体实现。
 *
 * */
public interface PayMapper extends Mapper<Pay> {
}