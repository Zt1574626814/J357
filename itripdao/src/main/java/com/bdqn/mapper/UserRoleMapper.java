package com.bdqn.mapper;

import com.bdqn.entity.UserRole;
import org.apache.ibatis.annotations.Param;
// import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (UserRole)表数据库访问层
 *
 * @author Zt
 * @since 2022-02-28 15:33:59
 */
public interface UserRoleMapper {


    /**
     * 查询指定行数据
     *
     * @param offset   起始查询
     * @param pageSize 每页条数
     * @return 对象列表
     */
    List<UserRole> queryAllByLimit(@Param("offset") int offset, @Param("pageSize") int pageSize);

    /**
     * 统计总行数
     *
     * @param userRole 查询条件
     * @return 总行数
     */
    long count(UserRole userRole);



}

