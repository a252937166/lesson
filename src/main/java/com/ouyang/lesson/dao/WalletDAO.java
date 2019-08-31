package com.ouyang.lesson.dao;

import com.ouyang.lesson.model.Wallet;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * WalletDAO继承基类
 * @author Administrator
 */
public interface WalletDAO extends MyBatisBaseDao<Wallet, Integer> {

    /**
     * 扣款
     * @param id id
     * @param money 扣款金额（分）
     * @return 更新条数
     */
    @Update("update wallet set balance = balance - #{money} where id = #{id} and balance >= #{money}")
    Integer reduceBalance(@Param("id") Integer id,@Param("money") Integer money);

    /**
     * 扣款
     * @param id id
     * @param money 增加金额（分）
     * @return 更新条数
     */
    @Update("update wallet set balance = balance + #{money} where id = #{id}")
    Integer increaseBalance(Integer id,Integer money);



}