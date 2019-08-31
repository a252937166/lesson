package com.ouyang.lesson.service.impl;

import com.ouyang.lesson.dao.WalletDAO;
import com.ouyang.lesson.model.Wallet;
import com.ouyang.lesson.service.WallectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ouyangduning
 * @date 2019/9/1 01:58
 */
@Service
public class WallectServiceImpl implements WallectService {

    @Autowired
    private WalletDAO walletDAO;

    /**
     * 转账
     * 事务声明，失败回滚
     * @param from 转账者ID
     * @param to 收钱者ID
     * @param money 转账金额（分）
     * @return 是否成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean transfer(Integer from, Integer to, Integer money) {
        //如果扣款成功，执行入账操作
        if (walletDAO.reduceBalance(from,money) > 0) {
            //模拟异常业务
            int a  = 1/0;
            walletDAO.increaseBalance(to,money);
            return true;
        }
        return false;
    }

    @Override
    public Wallet findById(Integer id) {
        return walletDAO.selectByPrimaryKey(id);
    }
}
