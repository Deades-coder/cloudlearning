package yang.example.controller;

import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import yang.example.entities.Pay;
import yang.example.entities.dto.PayDTO;
import yang.example.resp.ResultData;
import yang.example.service.PayService;

import java.util.List;

/**
 * User:小小星仔
 * Date:2025-05-08
 * Time:15:50
 */
@RestController
public class PayController {
    @Resource
    PayService payService;
    @PostMapping(value = "/pay/add")
    public ResultData<String> addPay(@RequestBody Pay pay){
        System.out.println(pay.toString());
        int i = payService.add(pay);
        return ResultData.success("成功插入记录，返回值："+i);
    }
    @DeleteMapping(value = "/pay/del/{id}")
    public ResultData<Integer> deletePay(@PathVariable("id") Integer id) {
        int i = payService.delete(id);
        return ResultData.success(i);
    }
    @PutMapping(value = "/pay/update")
    public ResultData<String> updatePay(@RequestBody PayDTO payDTO){
        Pay pay = new Pay();
        //类型转换
        BeanUtils.copyProperties(payDTO, pay);

        int i = payService.update(pay);
        return ResultData.success("成功修改记录，返回值："+i);

    }
    @GetMapping(value = "/pay/get/{id}")
    public ResultData<Pay> getById(@PathVariable("id") Integer id){
        if(id==null||id<=0){
            throw new RuntimeException("id不能为空且必须大于0");
        }
        Pay pay = payService.getById(id);
        return ResultData.success(pay);
    }

    @GetMapping(value = "/pay/getall")
    public ResultData<List<Pay>> getAll(){
        return ResultData.success(payService.getAll());
    }
}
