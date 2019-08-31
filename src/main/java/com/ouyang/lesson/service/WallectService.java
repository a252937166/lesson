package com.ouyang.lesson.service;

import com.ouyang.lesson.model.Wallet;

/**
 * @author ouyangduning
 * @date 2019/9/1 01:58
 */
public interface WallectService {
    /**
     * 转钱
     * @param from 转账者ID
     * @param to 收钱者ID
     * @param money 转账金额（分）
     * @return 是否成功
     */
    boolean transfer(Integer from,Integer to,Integer money);

    /**
     * 根据id查找
     * @param id id
     * @return
     */
    Wallet findById(Integer id);
}
