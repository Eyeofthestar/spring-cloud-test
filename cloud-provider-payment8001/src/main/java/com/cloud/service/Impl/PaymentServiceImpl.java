package com.cloud.service.Impl;

import com.cloud.mapper.PaymentDao;
import com.cloud.pojo.Payment;
import com.cloud.service.PaymentService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;



@Service
public class PaymentServiceImpl  implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return paymentDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Payment record) {
        return paymentDao.insert(record);
    }

    @Override
    public int insertSelective(Payment record) {
        return paymentDao.insertSelective(record);
    }

    @Override
    public Payment selectByPrimaryKey(Integer id) {
        if (id!=null){
            return paymentDao.selectByPrimaryKey(id);
        }
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Payment record) {
        return paymentDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Payment record) {
        return paymentDao.updateByPrimaryKey(record);
    }
}
