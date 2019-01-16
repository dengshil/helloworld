package com.qwe.service;

import com.qwe.domain.RedPacket;

public interface RedPacketService {

    /**
     * 获取红包信息
     * @param id 编号
     * @return  红包具体信息
     */
    public RedPacket getRedPacket(Long id);


    /**
     * 扣减抢红包数
     * @param id    编号
     * @return  影响条数
     */
    public int decreaseRedPacket(Long id);
}
