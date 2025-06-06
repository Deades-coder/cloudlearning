package yang.example.service.serviceImpl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import yang.example.entities.Pay;
import yang.example.mapper.PayMapper;
import yang.example.service.PayService;

import java.util.List;

/**
 * User:小小星仔
 * Date:2025-05-08
 * Time:15:44
 */
@Service
public class PayServiceImpl implements PayService {

    @Resource
    PayMapper payMapper;

    @Override
    public int add(Pay pay) {
        return payMapper.insertSelective(pay);
    }

    @Override
    public int delete(Integer id) {
        return payMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Pay pay) {
        return payMapper.updateByPrimaryKeySelective(pay);
    }

    @Override
    public Pay getById(Integer id) {
        return payMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Pay> getAll() {
        return payMapper.selectAll();
    }
}
