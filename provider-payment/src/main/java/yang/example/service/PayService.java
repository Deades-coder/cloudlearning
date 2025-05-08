package yang.example.service;

import yang.example.entities.Pay;

import java.util.List;

/**
 * User:小小星仔
 * Date:2025-05-08
 * Time:15:44
 */
public interface PayService {
    public int add(Pay pay);
    public int delete(Integer id);
    public int update(Pay pay);

    public Pay   getById(Integer id);
    public List<Pay> getAll();
}
