package org.wayne.thief.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.wayne.entity.Card;
import org.wayne.entity.TbBo;

import java.util.List;

/**
 * @Description:
 * @author: lwq
 */
public interface CardMapper extends BaseMapper<Card>{

    void batchInsert(List<TbBo> list);
}
