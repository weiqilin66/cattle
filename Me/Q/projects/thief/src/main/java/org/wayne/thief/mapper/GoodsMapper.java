package org.wayne.thief.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.wayne.entity.Auctions;
import org.wayne.entity.Card;
import org.wayne.entity.TbBo;

import java.util.List;

/**
 * @Description:
 * @author: lwq
 */
public interface GoodsMapper {

    void batchInsert(@Param("list") List<Auctions> list,@Param("card") Card card,@Param("date")String date,@Param("time")String time);
    void batchInsert2(@Param("list") List<Auctions> list,@Param("card") Card card,@Param("date")String date,@Param("time")String time);
}
