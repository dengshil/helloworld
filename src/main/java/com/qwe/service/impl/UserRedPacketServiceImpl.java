package com.qwe.service.impl;

import com.qwe.dao.RedPacketDao;
import com.qwe.dao.UserRedPacketDao;
import com.qwe.domain.RedPacket;
import com.qwe.domain.UserRedPacket;
import com.qwe.service.UserRedPacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserRedPacketServiceImpl implements UserRedPacketService {
    /**
     * grapRedPacket方法的逻辑是首先获取红包信息，如果发现红包库存大于 0，则说明还
     * 有红包可抢，抢夺红包并生成抢红包的信息将其保存到数据库中。要注意的是，数据库事
     * 务方面的设置，代码中使用注解＠Transactional 说明它会在一个事务中运行，这样就能够
     * 保证所有的操作都是在－个事务中完成的。在高井发中会发生超发的现象，后面会看到超
     * 发的实际测试。
     */


    @Autowired
    private UserRedPacketDao userRedPacketDao;

    @Autowired
    private RedPacketDao redPacketDao;

    //失败
    private static final int FAILED = 0;


    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public int grapRedPacket(Long redPacketId, Long userId) {
        //获取红包信息
        RedPacket redPacket = redPacketDao.getRedPacket(redPacketId);
        //当当前红包数大于0 时
        if (redPacket.getStock() > 0) {

            redPacketDao.decreaseRedPacket(redPacketId);
            //生成抢红包信息
            UserRedPacket userRedPacket = new UserRedPacket();
            userRedPacket.setRedPacketId(redPacketId);
            userRedPacket.setUserId(userId);
            userRedPacket.setAmount(redPacket.getUnitAmount());
            userRedPacket.setNote("抢红包" + redPacketId);
            //插入抢红包信息
            int result = userRedPacketDao.grapRedPacket(userRedPacket);
            return result;
        }
        //失败返回
        return FAILED;
    }


}
