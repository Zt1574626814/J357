package com.bdqn.mapper;

import com.bdqn.entity.ItripHotelExtendProperty;
import org.apache.ibatis.annotations.Param;
// import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (ItripHotelExtendProperty)表数据库访问层
 *
 * @author Zt
 * @since 2022-02-28 15:33:57
 */
public interface ItripHotelExtendPropertyMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ItripHotelExtendProperty queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset   起始查询
     * @param pageSize 每页条数
     * @return 对象列表
     */
    List<ItripHotelExtendProperty> queryAllByLimit(@Param("offset") int offset, @Param("pageSize") int pageSize);

    /**
     * 统计总行数
     *
     * @param itripHotelExtendProperty 查询条件
     * @return 总行数
     */
    long count(ItripHotelExtendProperty itripHotelExtendProperty);

    /**
     * 新增数据
     *
     * @param itripHotelExtendProperty 实例对象
     * @return 影响行数
     */
    int insert(ItripHotelExtendProperty itripHotelExtendProperty);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ItripHotelExtendProperty> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ItripHotelExtendProperty> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ItripHotelExtendProperty> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ItripHotelExtendProperty> entities);

    /**
     * 修改数据
     *
     * @param itripHotelExtendProperty 实例对象
     * @return 影响行数
     */
    int update(ItripHotelExtendProperty itripHotelExtendProperty);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

