package com.bailingnan.icommunity.dao;

import com.bailingnan.icommunity.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author bailingnan
 * @date 2021/3/14
 */
@Mapper
public interface DiscussPostMapper {
    //首页帖子实际不用传入userId，但考虑到之后需要实现我的帖子功能，这里就整合到一起，offset偏移量表示当前是第几行，limit表示每页数量
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit, int orderMode);

    //动态拼接条件，方法有且只有一个条件时，需要用@Param注解给参数取别名，也可以在属性名太长的时候取别名来简化
    int selectDiscussPostRows(@Param("userId") int userId);

    int insertDiscussPost(DiscussPost discussPost);

    DiscussPost selectDiscussPostById(int id);

    int updateCommentCount(int id, int commentCount);

    int updateType(int id, int type);

    int updateStatus(int id, int status);

    int updateScore(int id, double score);
}
