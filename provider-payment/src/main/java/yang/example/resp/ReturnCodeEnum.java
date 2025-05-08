package yang.example.resp;

import lombok.Getter;

import java.util.Arrays;

/**
 *  User:小小星仔
 *  Date:2025-05-08
 *  Time:15:54
 */
/**
 * 枚举类在编译后会被转换成 final class，并继承 java.lang.Enum
 * 枚举常量实际上是枚举类的静态实例。
 * 定义一个枚举常量，添加两个属性，code和message，分别表示返回码和返回信息。
 *
 * */
@Getter
public enum ReturnCodeEnum {
    RC999("999","操作异常"),
    RC200("200","操作成功"),
    /**服务降级**/
    RC201("201","服务开启降级保护,请稍后再试!"),
    /**热点参数限流**/
    RC202("202","热点参数限流,请稍后再试!"),
    /**系统规则不满足**/
    RC203("203","系统规则不满足要求,请稍后再试!"),
    /**授权规则不通过**/
    RC204("204","授权规则不通过,请稍后再试!"),
    /**access_denied**/
    RC403("403","无访问权限,请联系管理员授予权限"),
    /**access_denied**/
    RC401("401","匿名用户访问无权限资源时的异常"),
    RC404("404","404页面找不到的异常"),
    /**服务异常**/
    RC500("500","系统异常，请稍后重试"),
    RC375("375","数学运算异常，请稍后重试"),

    INVALID_TOKEN("2001","访问令牌不合法"),
    ACCESS_DENIED("2003","没有权限访问该资源"),
    CLIENT_AUTHENTICATION_FAILED("1001","客户端认证失败"),
    USERNAME_OR_PASSWORD_ERROR("1002","用户名或密码错误"),
    BUSINESS_ERROR("1004","业务逻辑异常"),
    UNSUPPORTED_GRANT_TYPE("1003", "不支持的认证模式");

    private final String code;
    private final String message;
    ReturnCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
    public static ReturnCodeEnum getReturnCodeEnum(String code){
        //x 代表流中的每个枚举实例,x.getCode() 获取当前枚举实例的 code 值,.equals(code) 比较是否与传入的 code 参数相等
        return Arrays.stream(ReturnCodeEnum.values()).filter(x -> x.getCode().equals(code)).findFirst().orElse(null);
    }
}
