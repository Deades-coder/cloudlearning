package yang.example.resp;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * User:小小星仔
 * Date:2025-05-08
 * Time:15:59
 */
@Data
@Accessors(chain = true)
public class ResultData <T>{
    private String code;
    private String message;
    private T data;
    private long timestamp;

    public ResultData(){
        this.timestamp = System.currentTimeMillis();
    }
    public static <T> ResultData<T> success(T data){
        ResultData<T> resultData = new ResultData<>();
        resultData.setCode(ReturnCodeEnum.RC200.getCode());
        resultData.setMessage(ReturnCodeEnum.RC200.getMessage());
        resultData.setData(data);
        return resultData;
    }
    public static <T> ResultData<T> fail(String code,String message){
        ResultData<T> resultData = new ResultData<>();
        resultData.setCode(code);
        resultData.setMessage(message);
        return resultData;
    }
}
